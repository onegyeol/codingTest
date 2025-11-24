package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * 백준 2015번 수들의 합4
 * 
 * A[1], A[2], ..., A[N]의 N개의 정수가 저장되어 있는 배열이 있다. 이 배열 A의 부분합이란 1 ≤ i ≤ j ≤ N인 정수 i와 j에 대해 A[i]부터 A[j]까지의 합을 말한다.
 * N과 A[1], A[2], ..., A[N]이 주어졌을 때, 이러한 N×(N+1)/2개의 부분합 중 합이 K인 것이 몇 개나 있는지를 구하는 프로그램을 작성하시오.
 */


public class codingTest126 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Map<Long, Long> map = new HashMap<>();
        long sum=0, answer=0;

        map.put(0L, 1L);
        for(int i=0; i<n; i++){
            sum += arr[i];

            /*
             * S[i] = arr[0] + arr[1] + arr[2] + arr[3] + arr[4]
             * S[j] = arr[0] + arr[1]
             * -----------------------------------------------
             * S[i] - S[j] = arr[2] + arr[3] + arr[4]
             * 
             * 즉, S[i] - S[j] = k
             * => S[j] = S[i]-k
             * 
             * 2, 3, 4 부분 합을 알기 위해선 전체 합 - (0, 1 합) 빼면 됨
             */
            if(map.containsKey(sum-k)){
                answer += map.get(sum-k);
            }

            map.put(sum, map.getOrDefault(sum, 0L)+1);
        }

        System.out.println(answer);
    }
}
