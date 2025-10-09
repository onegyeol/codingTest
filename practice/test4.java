package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

/*
 * 데이터베이스 커넥션이나 네트워크 소켓처럼 생성 비용이 비싼 객체를 재사용하기 위한 ObjectPool<T> 클래스를 구현하세요.
 * 
 * 생성자에서 maxSize, 그리고 객체를 생성하는 방법을 정의한 Supplier<T> factory를 받습니다.
 * T acquire(): 풀에서 객체를 하나 가져옵니다.
 *  사용 가능한 객체가 있으면 즉시 반환합니다.
 *  사용 가능한 객체가 없고, 현재 풀 크기가 maxSize 미만이면 factory를 이용해 새 객체를 만들어 반환합니다.
 *  사용 가능한 객체가 없고, 풀 크기가 maxSize에 도달했다면, 다른 스레드가 객체를 반납할 때까지 대기해야 합니다.
 * void release(T object): 사용이 끝난 객체를 풀에 반납합니다.
 *  객체가 반납되면, acquire()에서 대기 중인 스레드가 깨어나 객체를 가져갈 수 있어야 합니다.
 * 멀티스레드 환경에서 여러 스레드가 동시에 acquire()와 release()를 호출해도 안전하게 동작해야 합니다.
 */

public class test4 {
    public static void main(String[] args) throws InterruptedException {
        // 최대 3개의 Connection 객체를 관리하는 풀 생성
        ObjectPool<Connection> connectionPool = new ObjectPool<>(3, Connection::new);
        
        // 7개의 스레드를 생성하여 동시에 Connection 객체를 요청하도록 함
        ExecutorService executor = Executors.newFixedThreadPool(7);
        
        for (int i = 0; i < 7; i++) {
            executor.submit(() -> {
                String threadName = Thread.currentThread().getName();
                try {
                    System.out.println(threadName + ": 객체 요청 중...");
                    Connection conn = connectionPool.acquire(); // 객체 획득 시도
                    System.out.println(threadName + ": 객체 획득 성공 -> " + conn);
                    
                    // 1초간 객체 사용
                    Thread.sleep(1000);
                    
                    System.out.println(threadName + ": 객체 반납 -> " + conn);
                    connectionPool.release(conn); // 사용 후 반납
                    
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        
        executor.shutdown();
        executor.awaitTermination(20, TimeUnit.SECONDS);
    }
}

class Connection {
    private static final AtomicInteger counter = new AtomicInteger(0);
    private final int id;

    public Connection() {
        this.id = counter.getAndIncrement();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Connection 객체 생성: ID=" + id);
    }

    @Override
    public String toString() {
        return "Connection(ID=" + id + ")";
    }
}

class ObjectPool<T> {
    private final int maxSize;

    // Supplier<T>는 get()이라는 추상 메소드 하나만 가지고 있으며, 이 메소드는 매개변수 없이 단순히 T 타입의 객체를 반환
    private final Supplier<T> factory;
    private final Queue<T> pool = new LinkedList<>(); // 재사용할 객체 저장
    private int currentSize = 0;

    public ObjectPool(int maxSize, Supplier<T> factory) {
        this.maxSize = maxSize;
        this.factory = factory;
    }

    public synchronized T acquire() throws InterruptedException {
        // 객체(pool)도 없고, 새로 만들 수도 없을 때(currentSize >= maxSize) -> 대기
        while (pool.isEmpty() && currentSize >= maxSize) {
            System.out.println(Thread.currentThread().getName() + "가 대기합니다. (Pool 비었음, Size=" + currentSize + ")");
            // wait()는 현재 스레드를 대기 상태로 만들고, 객체의 lock을 일시적으로 해제
            // 다른 스레드가 release()에서 notifyAll()을 호출해줄 때까지 대기
            this.wait();
        }

        // 1. 재사용할 객체가 있는 경우
        if (!pool.isEmpty()) {
            return pool.poll(); // 큐에서 객체를 꺼내 반환
        }

        // 2. 새로 객체를 만들 수 있는 경우 (초기값 생성 로직)
        if (currentSize < maxSize) {
            currentSize++;
            return factory.get(); // 팩토리를 통해 새 객체 생성 후 반환
        }
        
        throw new IllegalStateException("Unexpected state in ObjectPool");
    }

    /**
     * 사용이 끝난 객체를 풀에 반납하고, 대기 중인 스레드를 깨움
     * 이 메소드 또한 공유 자원(pool)을 수정하므로 반드시 synchronized로 보호 필요
     */
    public synchronized void release(T object) {
        pool.add(object);
        
        // notifyAll()을 호출하여 그 스레드들을 모두 깨움
        this.notifyAll();
    }
}
