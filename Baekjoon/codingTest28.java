package Baekjoon;

import java.io.*;
import java.util.*;
/**
 * 백준 2225번 합분해
 * 
 * 0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램을 작성하시오.

덧셈의 순서가 바뀐 경우는 다른 경우로 센다(1+2와 2+1은 서로 다른 경우). 또한 한 개의 수를 여러 번 쓸 수도 있다.
 */

public class codingTest28 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][k+1];


        // k가 0일 때 경우의 수 0으로 초기화, k가 1일 때 경우의 수 1로 초기화(자기자신만이 n을 만들 수 있음)
        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
            dp[i][1] = 1;
        }

        // n이 1일 때 경우의 수는 K개, 1을 어떻게 배치하느냐에 따라 달라짐
        for(int i=0; i<=k; i++){
            dp[1][i] = i;
        }

        for(int i=2; i<=n; i++){
            for(int j=2; j<=k; j++){
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000;
            }
        }
        
        System.out.println(dp[n][k]);     

    }    

       
}
