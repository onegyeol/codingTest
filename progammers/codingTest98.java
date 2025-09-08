package progammers;

import java.util.HashMap;
import java.util.Map;

/*
 * 프로그래머스 2022 KAKAO BLIND RECRUITMENT 신고 결과 받기
 */

public class codingTest98 {
    public static void main(String[] args) {
        
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int len = id_list.length;
        int[] answer = new int[len];
        Map<String, Integer> map = new HashMap<>();
 
        for(int i=0; i<len; i++){
            map.put(id_list[i], i);
        }
        
        boolean[][] reported = new boolean[len][len];
        int[] reportedCount = new int[len]; //신고당한 횟수
        
        for (String rec : report) {
            String[] sp = rec.split(" ");
            int from = map.get(sp[0]);
            int to   = map.get(sp[1]);
            if (!reported[from][to]) {
                reported[from][to] = true;  // 중복 방지
                reportedCount[to]++;        // 피신고자 신고당함
            }
        }
        
        // 정지대상인지 ?
        boolean[] suspended = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (reportedCount[i] >= k) suspended[i] = true;
        }
        
        for (int from = 0; from < len; from++) {
            for (int to = 0; to < len; to++) {
                if (reported[from][to] && suspended[to]) {
                    answer[from]++;
                }
            }
        }
        
        return answer;
    }
}
