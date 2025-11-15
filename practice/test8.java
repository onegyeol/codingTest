package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 길이 N의 배열 A와 정수 K가 주어진다.
 * 크기 K인 연속 구간의 최대 합을 구하라.
 */

public class test8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int maxSum = sum;
        for(int i=k; i<n; i++){
            sum = sum - arr[i-k] + arr[i];
            maxSum = Math.max(maxSum, sum);
        }


        System.out.println(maxSum);
    }
}