package progammers;

import java.util.*;

/**
 *  Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때, 
모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.

섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
 */

public class codingTest26 {
    public int solution(int[] scoville, int k) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int a : scoville) q.offer(a);
        
       while(q.peek() < k){
            if(q.size() < 2) return -1;
            else{
                int first = q.poll();
                int second = q.poll();
                
                q.offer(first + (second*2));
                answer++;
                
            }
        }
        
        return answer;
    }
}


