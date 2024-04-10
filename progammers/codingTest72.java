package progammers;

/**
 *  Lv.3 야근지수
 * 
 * 회사원 Demi는 가끔은 야근을 하는데요, 야근을 하면 야근 피로도가 쌓입니다. 
 * 야근 피로도는 야근을 시작한 시점에서 남은 일의 작업량을 제곱하여 더한 값입니다. 
 * Demi는 N시간 동안 야근 피로도를 최소화하도록 일할 겁니다.
 * Demi가 1시간 동안 작업량 1만큼을 처리할 수 있다고 할 때, 퇴근까지 남은 N 시간과 각 일에 대한 작업량 works에 대해 야근 피로도를 최소화한 값을 리턴하는 함수 solution을 완성해주세요.
 */

public class codingTest72 {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder()); //작업량이 제일 많은 순서대로 처리하면됨.
        
        for(int i : works){
            q.add(i);
        }
        
        for(int i=0; i<n; i++){
            int w = q.poll();
            if(w == 0) return 0; //작업량이 없다면 0 리턴
            
            q.add(w-1); //작업량 많은 순서대로 내부적으로 정렬됨
        }
        
        while(!q.isEmpty()){
            answer += Math.pow(q.poll(), 2); //각 작업량의 제곱한 값 더해줌
        }
        
        return answer;
    }
}
