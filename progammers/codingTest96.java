package progammers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * 2024 KAKAO WINTER INTERNSHIP 가장 많이 받은 선물

 * 
 */
public class codingTest96 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] friends = new String[n];

        for(int i=0; i<n; i++){
            friends[i] = br.readLine();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String[][] gifts = new String[m][k];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<k; j++){
                gifts[i][j] = st.nextToken();
            }
        }

        System.out.println(solution(friends, friends));
    }

    static int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        int answer = 0;

        // 친구 번호 매핑
        Map<String, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxMap.put(friends[i], i);
        }

        // 선물 주고받기 기록
        int[][] history = new int[n][n];
        int[] sent = new int[n];
        int[] received = new int[n];

        for (String g : gifts) {
            String[] sp = g.split(" ");
            int giver = idxMap.get(sp[0]);
            int receiver = idxMap.get(sp[1]);

            history[giver][receiver]++;
            sent[giver]++;
            received[receiver]++;
        }

        // 선물 지수 계산
        int[] giftIndex = new int[n];
        for (int i = 0; i < n; i++) {
            giftIndex[i] = sent[i] - received[i];
        }

        // 다음 달 받을 선물 개수
        int[] nextMonth = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (history[i][j] > history[j][i]) {
                    nextMonth[i]++;
                } else if (history[i][j] < history[j][i]) {
                    nextMonth[j]++;
                } else {
                    if (giftIndex[i] > giftIndex[j]) {
                        nextMonth[i]++;
                    } else if (giftIndex[i] < giftIndex[j]) {
                        nextMonth[j]++;
                    }
                }
            }
        }

        // 최댓값 찾기
        for (int cnt : nextMonth) {
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

}
