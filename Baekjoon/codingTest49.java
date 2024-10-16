package Baekjoon;

import java.util.*;
import java.io.*;

/*
 * 백준 1149 RGB 거리
 * 
 * RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.
 * 집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.

1번 집의 색은 2번 집의 색과 같지 않아야 한다.
N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
 */

public class codingTest49 {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        dp = new int[n+1][3];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()); // 빨강
            int g = Integer.parseInt(st.nextToken()); // 초록
            int b = Integer.parseInt(st.nextToken()); // 파랑

            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + r; // i 번째 집을 빨강으로 칠하려면 이전 집을 초록 혹은 파랑으로 칠해야함
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + g;
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + b;
        }

        System.out.println(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));

    }

    
}
