package practice;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;

/*
 * 주어진 작업을 비동기적으로 실행하고, 작업 완료 시 콜백을 실행하는 간단한 AsyncTaskExecutor 클래스를 구현하세요.
 * 생성자에서 동시에 실행할 수 있는 최대 스레드 수 (poolSize)를 받습니다.
 * void submit(Runnable task, Consumer<Boolean> callback) 메소드를 제공합니다.
 *  task: 백그라운드 스레드에서 실행될 작업입니다.
 *  callback: task가 완료된 후 호출될 콜백 함수입니다. task가 성공적으로 완료되면 true를, 예외가 발생하면 false를 인자로 받습니다.
 * submit 메소드는 즉시 리턴되어야 하며, task는 내부 스레드 풀의 스레드 중 하나에 의해 비동기적으로 실행되어야 합니다.
 * 제출된 task들은 큐에 저장되었다가 가용한 스레드에 의해 순차적으로 처리됩니다.
 * void shutdown() 메소드를 제공하여 모든 작업이 완료된 후 스레드 풀을 안전하게 종료할 수 있어야 합니다.
 */

public class test5 {
    public static void main(String[] args) throws InterruptedException {
        // 2개의 스레드를 가진 Executor 생성
        AsyncTaskExecutor executor = new AsyncTaskExecutor(2);

        // 성공하는 작업 3개 제출
        for (int i = 1; i <= 3; i++) {
            int taskId = i;
            Runnable task = () -> {
                try {
                    System.out.println("Task " + taskId + " 시작 (Thread: " + Thread.currentThread().getName() + ")");
                    Thread.sleep(1000);
                    System.out.println("Task " + taskId + " 완료");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            };
            executor.submit(task, success -> System.out.println(">> Task " + taskId + " 콜백: " + success));
        }

        // 실패하는 작업 1개 제출
        Runnable failingTask = () -> {
            System.out.println("Failing Task 시작 (Thread: " + Thread.currentThread().getName() + ")");
            throw new RuntimeException("의도된 예외 발생");
        };
        executor.submit(failingTask, success -> System.out.println(">> Failing Task 콜백: " + success));

        // 모든 작업이 큐에 들어갈 시간을 잠시 줌
        Thread.sleep(100);

        // Executor 종료
        System.out.println("\n--- Shutdown 호출 ---");
        executor.shutdown();
        System.out.println("--- Main thread 종료 ---");
    }
}   


class AsyncTaskExecutor {
    BlockingQueue<Runnable> queue;
    Thread[] workers;
    private volatile boolean isShutdown = false;

    public AsyncTaskExecutor(int poolSize) {
        this.queue = new LinkedBlockingQueue<>();
        this.workers = new Thread[poolSize];

        for (int i = 0; i < poolSize; i++) {
            workers[i] = new Thread(new Worker());
            workers[i].start(); // 생성과 동시에 스레드 시작
        }
    }

    public void submit(Runnable task, Consumer<Boolean> callback){
        if(isShutdown){
            throw new IllegalStateException("Executor has been shut down");
        }

        Runnable wrappedTask = () -> {
            try{
                task.run();
                callback.accept(true);
            } catch (Exception e){
                System.err.println("작업 실행 중 예외 발생: " + e.getMessage());
                callback.accept(false);
            }
        };

        try{
            queue.put(wrappedTask);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public void shutdown(){
        isShutdown = true;
        for(Thread worker : workers){
            worker.interrupt();
        }
    }

    private class Worker implements Runnable{

        @Override
        public void run() {
            while(!isShutdown){
                try{
                    Runnable task = queue.take();
                    task.run();
                } catch(InterruptedException e){

                }
            }
            System.out.println(Thread.currentThread().getName() + " 종료");
        }

    }
}