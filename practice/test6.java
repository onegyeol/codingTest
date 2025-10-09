package practice;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;

class AsyncTaskExecutor{
    BlockingQueue<Runnable> queue;
    Thread[] workers;
    private volatile boolean isShutdown = false;
    private int poolSize;

    public AsyncTaskExecutor(int poolSize){
        this.queue = new LinkedBlockingQueue<>();
        this.workers = new Thread[poolSize];

        for(int i=0; i<poolSize; i++){
            workers[i] = new Thread(new Worker());
            workers[i].start();
        }
    }

    public void submit(Runnable task, Consumer<Boolean> callback){
        if(isShutdown){
            throw new IllegalStateException();
        }

        Runnable wrappedTask = () -> {
            try{
                task.run();
                callback.accept(true);
            } catch (Exception e){
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
                } catch (InterruptedException e)
            }
        }

    }
}