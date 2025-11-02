package progammers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 프로그래머스 Lv.2 2 x n 타일링
 * 
 * 가로 길이가 2이고 세로의 길이가 1인 직사각형모양의 타일이 있습니다. 
 * 이 직사각형 타일을 이용하여 세로의 길이가 2이고 가로의 길이가 n인 바닥을 가득 채우려고 합니다. 
 * 타일을 채울 때는 다음과 같이 2가지 방법이 있습니다.
 */

public class codingTest121 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        
        int[] dp = new int[n+1];
        
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-2]+dp[i-1])% 1000000007;
        }
        
        
        return dp[n];
    }
}
