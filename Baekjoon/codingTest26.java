package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백즌 9251번 LCS
 * 
LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.

예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.


 * 
 */
public class codingTest26 {
    static char[] a;
    static char[] b;
    static Integer[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = br.readLine().toCharArray();
        b = br.readLine().toCharArray();
        dp = new Integer[a.length][b.length];

        System.out.println(lcs(a.length-1, b.length-1)); 
    }

    static int lcs(int x, int y){
        if(x==-1 || y==-1) return 0;
        if(dp[x][y] == null){
            dp[x][y] = 0;
            if(a[x] == b[y]) dp[x][y] = lcs(x-1, y-1)+1; // 부분 수열 찾음 -> +1, 값을 누적시키며 LCS 값 증가시킴
            else dp[x][y] = Math.max(lcs(x, y-1), lcs(x-1, y)); 
        }

        return dp[x][y];
    }
}
