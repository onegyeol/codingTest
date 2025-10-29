package progammers;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 프로그래머스 Lv.2 다리를 지나는 트럭
 * 
 * solution 함수의 매개변수로 다리에 올라갈 수 있는 트럭 수 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭 별 무게 truck_weights가 주어집니다. 
 * 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.
 */

public class codingTest112 {
    public static void main(String[] args) {
        // bridge_length, weight, truck_weights 입력 받고 solution() 함수로 넘김
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;           // 경과 시간
        int totalWeight = 0;    // 현재 다리 위 트럭 총합
        int idx = 0;            // 다음 트럭 인덱스
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<bridge_length; i++){
            q.add(0);
        }
        
        while(!q.isEmpty()){
            time++;
            totalWeight -= q.poll();
            
            if(idx < truck_weights.length){
                if(totalWeight+truck_weights[idx] <= weight){ // 대기 트럭 맨 앞 + 다리를 건너는 트럭의 무게가 최대 무게를 넘지 않으면
                    q.add(truck_weights[idx]);
                    totalWeight += truck_weights[idx];
                    idx++;
                } else{
                    q.add(0);
                }
            }
            
        }
        
        return time;
    }
}
