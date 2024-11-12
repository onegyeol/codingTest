package Baekjoon;

import java.util.*;
import java.io.*;

/**
 * 2579번 계단 오르기
 * 계단 오르는 데는 다음과 같은 규칙이 있다.

1. 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
2. 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
3. 마지막 도착 계단은 반드시 밟아야 한다.
따라서 첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다. 하지만, 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.

각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.


 */
public class codingTest51 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        
        int[] stairs = new int[n];
        int[] dp = new int[n];

        for(int i=0; i<n; i++){
            stairs[i] = in.nextInt();
        }

         // 예외 처리: 계단이 1개 또는 2개일 때
         if (n == 1) {
            System.out.println(stairs[0]);
            return;
        } else if (n == 2) {
            System.out.println(stairs[0] + stairs[1]);
            return;
        }

        dp[0] = stairs[0];
        dp[1] = stairs[0] + stairs[1];
        dp[2] = Math.max(stairs[0]+stairs[2], stairs[1]+stairs[2]);

        for(int i=3; i<n; i++){
            dp[i] = Math.max(dp[i-2]+stairs[i], dp[i-3]+stairs[i-1]+stairs[i]); //두 계단 전에서 현재 계단으로 오는 경우, 이전 계단 전과 그 이전 계단을 밟고오는 경우 고려
        }
        
        System.out.println(dp[n-1]);
    }

    
}
