package Baekjoon;

import java.util.StringTokenizer;
import java.io.*;

/**
 * 백준 1912번 연속합
 * 
 * n개의 정수로 이루어진 임의의 수열이 주어진다. 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다. 
 * 단, 수는 한 개 이상 선택해야 한다.

예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 
여기서 정답은 12+21인 33이 정답이 된다.

 */
public class codingTest22 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[n];
        
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        // Kadane의 알고리즘 적용
        int maxSoFar = input[0]; //지금 까지 발견된 최대 부분 배열 합
        int currentMax = input[0]; //현재 위치에서 최대 부분 배열 합

        for (int i = 1; i < n; i++) {
            currentMax = Math.max(input[i], currentMax + input[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        System.out.println(maxSoFar);

        /*int size = 1;
        int answer = Integer.MIN_VALUE;

        while(size <= n){
            for(int j=0; j<=n-size; j++){
                int sum=0;
                for(int i=j; i<j+size; i++){
                    sum += input[i];
                }
                answer = Math.max(answer, sum);
            }
            size++;
        }

        System.out.println(answer);*/

        
    }
}