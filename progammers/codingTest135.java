package progammers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/*
 * 프로그래머스 Lv.3 숫자 게임
 * 
 * 먼저 모든 사원이 무작위로 자연수를 하나씩 부여받습니다.
 * 각 사원은 딱 한 번씩 경기를 합니다.
 * 각 경기당 A팀에서 한 사원이, B팀에서 한 사원이 나와 서로의 수를 공개합니다. 그때 숫자가 큰 쪽이 승리하게 되고, 승리한 사원이 속한 팀은 승점을 1점 얻게 됩니다.
 * 만약 숫자가 같다면 누구도 승점을 얻지 않습니다.
 * 전체 사원들은 우선 무작위로 자연수를 하나씩 부여받았습니다. 
 * 그다음 A팀은 빠르게 출전순서를 정했고 자신들의 출전 순서를 B팀에게 공개해버렸습니다. 
 * B팀은 그것을 보고 자신들의 최종 승점을 가장 높이는 방법으로 팀원들의 출전 순서를 정했습니다. 이때의 B팀이 얻는 승점을 구해주세요.
 * A 팀원들이 부여받은 수가 출전 순서대로 나열되어있는 배열 A와 i번째 원소가 B팀의 i번 팀원이 부여받은 수를 의미하는 배열 B가 주어질 때, 
 * B 팀원들이 얻을 수 있는 최대 승점을 return 하도록 solution 함수를 완성해주세요.
 * 
 * 단순히 생각하면 이렇게 될 수 있음
 * - 승리 : 상대 선수보다 점수가 높으면서, 점수차가 가장 낮은 팀원
 * - 패배 : 상대 선수보다 점수가 낮으면서, 점수차가 가장 큰 팀원
 */

public class codingTest135 {
    public static void main(String[] args) {
        // A, B 입력받음
    }

    public int solution(int[] A, int[] B) {
        int answer = 0;
        // 역순으로 넣음
        // 남은 A팀에서 해당 점수보다 더 높은 선수는 없다는 것을 보장하기 위함
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());

        for (int i : A) {
            pq.add(i);
        }

        Arrays.sort(B);
        ArrayDeque<Integer> dp = new ArrayDeque();
        for (int i : B) {
            dp.add(i);
        }

        /*
         * A 팀 중 가장 높은 점수인 선수 고르고
         * B 팀 중 가장 높은 선수와 비교해서
         * B가 크면 그대로, B가 더 작으면 가장 점수가 낮은 선수 출전하는 방향으로
         */
        while (!pq.isEmpty()) {
            int target = pq.poll();

            if (target < dp.peekLast()) { // 이길 때는 가장 큰 숫자
                answer++;
                dp.pollLast();
            } else { // 질 때는 가장 작은 숫자 내야함
                dp.pollFirst();
            }
        }

        return answer;
    }
}
