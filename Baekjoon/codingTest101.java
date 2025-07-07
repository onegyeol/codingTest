package Baekjoon;

import java.util.Scanner;

/*
 * 백준 1003번 피보나치 함수
 * 
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
 * 각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.
 * N이 주어졌을 때, fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오.
 */

public class codingTest101 {
    static int[][] fibo = new int[41][2];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        fibo[0][0] = 1; // fibo(0) 호출 시 0이 1번 출력됨
        fibo[0][1] = 0;
        fibo[1][0] = 0;
        fibo[1][1] = 1;

        for(int i=2; i<41; i++){
            fibo[i][0] = fibo[i-1][0] + fibo[i-2][0];
            fibo[i][1] = fibo[i-1][1] + fibo[i-2][1];
        }
        
        int t = in.nextInt();
        for(int i=0; i<t; i++){
            int n = in.nextInt();
            sb.append(fibo[n][0] + " " + fibo[n][1] + "\n");
        }

        System.out.println(sb);
    }
}
