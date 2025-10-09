package practice;

/*
 * API 요청을 제어하기 위한 RateLimiter 클래스를 구현하세요. 이 클래스는 "토큰 버킷" 알고리즘을 기반으로 동작해야 합니다.
 * 
 * RateLimiter는 생성자에서 capacity (버킷의 최대 토큰 수)와 refillRatePerSecond (초당 리필되는 토큰 수)를 받습니다.
 * boolean tryAcquire() 메소드를 제공해야 합니다.
 * 버킷에 사용 가능한 토큰이 1개 이상 있으면, 토큰을 1개 소모하고 true를 반환합니다.
 * 버킷에 토큰이 없으면, false를 반환합니다.
 * 토큰은 마지막 요청 이후 시간에 비례하여 refillRatePerSecond에 따라 버킷에 다시 채워져야 합니다.
 * 여러 스레드가 동시에 tryAcquire()를 호출하더라도 Race Condition 없이 정확하게 동작해야 합니다. (Thread-safe)
 */

 
public class test3 {
    public static void main(String[] args) throws InterruptedException {
        RateLimiter limiter = new RateLimiter(3, 1);

        System.out.println("초기 토큰: " + limiter.getCurrentTokens()); // 예상: 3

        System.out.println("1차 요청: " + limiter.tryAcquire()); // true
        System.out.println("2차 요청: " + limiter.tryAcquire()); // true
        System.out.println("3차 요청: " + limiter.tryAcquire()); // true
        System.out.println("4차 요청: " + limiter.tryAcquire()); // false, 토큰 소진

        System.out.println("소진 후 토큰: " + limiter.getCurrentTokens()); // 예상: 0

        System.out.println("\n2초 대기...\n");
        Thread.sleep(2000); // 2초 동안 대기

        System.out.println("2초 후 토큰: " + limiter.getCurrentTokens()); // 예상: 2 (2초 동안 2개 리필)
        
        System.out.println("5차 요청: " + limiter.tryAcquire()); // true
        System.out.println("6차 요청: " + limiter.tryAcquire()); // true
        System.out.println("7차 요청: " + limiter.tryAcquire()); // false

        System.out.println("최종 토큰: " + limiter.getCurrentTokens()); // 예상: 0
    }
}

class RateLimiter{
    private int capacity, refillRatePerSecond;
    private long currentTokens;
    private long lastRefillTimestamp;

    public RateLimiter(int capacity, int refillRatePerSecond){
        this.capacity = capacity;
        this.refillRatePerSecond = refillRatePerSecond;
        this.currentTokens = capacity;
        this.lastRefillTimestamp = System.currentTimeMillis(); // 밀리초
    }

    // 메소드 전체를 동기화하기 위해 synchronized 사용
    public synchronized boolean tryAcquire(){
        refillTokens();

        if(currentTokens > 0){
            currentTokens--;
            return true;
        } else return false;
        
    }

    private void refillTokens(){
        long now = System.currentTimeMillis(); //밀리초
        long time = now - lastRefillTimestamp;

        if(time>0){
            long tokensToRefill = (time*refillRatePerSecond)/1000; // 초로 바꾸기 위해 /1000 연산 수행

            if(tokensToRefill>0){
                currentTokens = Math.min(currentTokens+tokensToRefill, capacity); // 토큰 최대 용량을 넘지 않도록
                this.lastRefillTimestamp = now;
            }
        }

    }

    public synchronized long getCurrentTokens(){
        refillTokens();
        return currentTokens;
    }
}