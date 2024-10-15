package Baekjoon;

import java.util.*;
import java.io.*;

/**
 * 백준 1463번 1로 만들기
 * 
 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.

 * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
 */

public class codingTest48 {
    static Integer[] dp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n  = in.nextInt();
        dp = new Integer[n+1];
        dp[0] = dp[1] = 0; // 해당 숫자를 해당없기에 0으로 초기화

        System.out.println(recur(n));
    }
    
    static int recur(int n){
        if(dp[n] == null){
            if(n % 6 == 0){ // 3과 2로 모두 나누어질 때
                dp[n] = Math.min(recur(n-1), Math.min(recur(n/2), recur(n/3))) + 1;
            }
            else if(n%3 == 0){ // 3으로 나누어질 때
                dp[n] = Math.min(recur(n-1), recur(n/3)) + 1;
            }
            else if(n%2 == 0){ // 2로 나누어질때
                dp[n] = Math.min(recur(n-1), recur(n/2)) + 1;
            }
            else{
                dp[n] = recur(n-1)+1;
            }
        }
        return dp[n];
    }

    
}
