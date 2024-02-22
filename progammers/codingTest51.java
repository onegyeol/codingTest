package progammers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/** 프로그래머스 Lv.2 귤 고르기
 * 
 * 예를 들어, 경화가 수확한 귤 8개의 크기가 [1, 3, 2, 5, 4, 5, 2, 3] 이라고 합시다. 
 * 경화가 귤 6개를 판매하고 싶다면, 크기가 1, 4인 귤을 제외한 여섯 개의 귤을 상자에 담으면, 
 * 귤의 크기의 종류가 2, 3, 5로 총 3가지가 되며 이때가 서로 다른 종류가 최소일 때입니다.

경화가 한 상자에 담으려는 귤의 개수 k와 귤의 크기를 담은 배열 tangerine이 매개변수로 주어집니다. 
경화가 귤 k개를 고를 때 크기가 서로 다른 종류의 수의 최솟값을 return 하도록 solution 함수를 작성해주세요.
 */

public class codingTest51 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //내림차순정렬
        
        for(int i:tangerine){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        for(Integer i : map.keySet()){
            pq.add(map.get(i));
        }
        
        while(k>0){
            if(pq.peek() > k){ //k보다 많기에 그 갯수에서 k개만큼 고르면 됨
                pq.poll();
                answer++;
                break;
            }
            else{
                k -= pq.poll();
                answer++;
            }
        }
        return answer;
    }

}
