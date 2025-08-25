package progammers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 프로그래머스 2025 프로그래머스 코드챌린지 1차 예선 유연근무제

 */

public class codingTest93 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] schedules = new int[n];
        int[][] timelogs = new int[n][7];

        for(int i=0; i<n; i++){
            schedules[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<7; j++){
                timelogs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int startday = Integer.parseInt(br.readLine());

        System.out.println(solution(schedules, timelogs, startday));
    }

    static int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int sat = 0;
        int sun = 0;

        switch (startday) {
            case 1:
                sat = 5;
                sun = 6;
                break;
            case 2:
                sat = 4;
                sun = 5;
                break;
            case 3:
                sat = 3;
                sun = 4;
                break;
            case 4:
                sat = 2;
                sun = 3;
                break;
            case 5:
                sat = 1;
                sun = 2;
                break;
            case 6:
                sat = 0;
                sun = 1;
                break;
            case 7:
                sat = 6;
                sun = 0;
                break;
        }

        for (int i = 0; i < schedules.length; i++) {
            boolean flag = true;
            int allowed = toMinutes(schedules[i]) + 10;
            for (int k = 0; k < 7; k++) {
                if (k == sat || k == sun)
                    continue;
                if (toMinutes(timelogs[i][k]) > allowed)
                    flag = false;
            }

            if (flag)
                answer++;
        }

        return answer;
    }

    // 시 -> 분으로 변경
    static int toMinutes(int hhmm) {
        int hh = hhmm / 100; // 시
        int mm = hhmm % 100; // 분
        return hh * 60 + mm;
    }

}
