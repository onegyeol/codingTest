package progammers;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 프로그래머스 Lv.3 이중우선순위큐
 * 이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.

명령어	수신 탑(높이)
I 숫자	큐에 주어진 숫자를 삽입합니다.
D 1	큐에서 최댓값을 삭제합니다.
D -1	큐에서 최솟값을 삭제합니다.

이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.
 */

public class codingTest71 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> q1 = new PriorityQueue<>(); //오름차순 정렬 -> 최소값
        PriorityQueue<Integer> q2 = new PriorityQueue<>(Collections.reverseOrder()); //내림차순 정렬 -> 최대값
        
        for(int i=0; i<operations.length; i++){
            String[] str = operations[i].split(" ");
            int num = Integer.parseInt(str[1]);
            
            if(str[0].equals("I")){
                q1.offer(num);
                q2.offer(num);
            }
            
            if(str[0].equals("D")){
                if(q1.isEmpty()) continue;
                if(num == -1){
                    int n = q1.poll();
                    q1.remove(n);
                    q2.remove(n);
                }
                else if(num == 1){
                    int n = q2.poll();
                    q1.remove(n);
                    q2.remove(n);
                }
            }
        }
        
        if(q1.size() > 0){
            answer[0] = q2.poll();
            answer[1] = q1.poll();
        }
        
        
        
        return answer;
    }
}
