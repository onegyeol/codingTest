package Baekjoon;

import java.util.*;
import java.io.*;

/*
 * 백준 11660번 구간 합 구하기 5
 * 
 * 첫째 줄에 표의 크기 N과 합을 구해야 하는 횟수 M이 주어진다. 
 * (1 ≤ N ≤ 1024, 1 ≤ M ≤ 100,000) 둘째 줄부터 N개의 줄에는 표에 채워져 있는 수가 1행부터 차례대로 주어진다. 
 * 다음 M개의 줄에는 네 개의 정수 x1, y1, x2, y2 가 주어지며, (x1, y1)부터 (x2, y2)의 합을 구해 출력해야 한다. 
 * 표에 채워져 있는 수는 1,000보다 작거나 같은 자연수이다. (x1 ≤ x2, y1 ≤ y2)
 */

public class codingTest46 {
    static int n, m;
    static int[][] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken()); // 표의 크기
        m = Integer.parseInt(st.nextToken()); // 합을 구해야하는 횟수

        input = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                input[i][j] = input[i][j-1] + Integer.parseInt(st.nextToken()); // 각 행의 합 누적
            }
        }

        for(int i=0; i<m; i++){
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j=x1; j<=x2; j++){
                sum += (input[j][y2] - input[j][y1-1]);
            }

            sb.append(sum + "\n");
        }

        System.out.println(sb);

    }
}
