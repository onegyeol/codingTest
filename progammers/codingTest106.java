package progammers;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 프로그래머스 Lv.2 숫자 변환하기
 * 
 * 1. x에 n을 더합니다
 * 2. x에 2를 곱합니다.
 * 3. x에 3을 곱합니다.
 * 
 * 자연수 x, y, n이 매개변수로 주어질 때, x를 y로 변환하기 위해 필요한 최소 연산 횟수를 return하도록 solution 함수를 완성해주세요. 
 * 이때 x를 y로 만들 수 없다면 -1을 return 해주세요.
 */

public class codingTest106 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int x = in.nextInt();
        int y = in.nextInt();
        int n = in.nextInt();

        System.out.println(solution(x, y, n));
    }

    static int solution(int x, int y, int n) {
        int[] dp = new int[y+1];
        Arrays.fill(dp, -1);
        
        dp[x] = 0;
        
        for(int i=x; i<=y; i++){
            if(dp[i]==-1) continue;
            
            if(i+n<=y){
                // 방문한 적 없거나 더 짧은 경로가 있다면
                if(dp[i+n]==-1 || dp[i+n]>dp[i]+1) {
                    dp[i+n] = dp[i]+1;
                }
            }
            
            if(i*2<=y){
                // 방문한 적 없거나 더 짧은 경로가 있다면
                if(dp[i*2]==-1 || dp[i*2]>dp[i]+1) {
                    dp[i*2] = dp[i]+1;
                }
            }
            
            if(i*3<=y){
                // 방문한 적 없거나 더 짧은 경로가 있다면
                if(dp[i*3]==-1 || dp[i*3]>dp[i]+1) {
                    dp[i*3] = dp[i]+1;
                }
            }
        }
        
        return dp[y];
    }
}
