package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 2003번 수들의 합2
 * 
 * N개의 수로 된 수열 A[1], A[2], …, A[N] 이 있다. 
 * 이 수열의 i번째 수부터 j번째 수까지의 합 A[i] + A[i+1] + … + A[j-1] + A[j]가 M이 되는 경우의 수를 구하는 프로그램을 작성하시오.
 */

public class codingTest125 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left=0, right=0, sum=0, answer=0;

        while(true){
            if(sum >= m){
                if(sum==m) answer++;
                sum -= arr[left++];
            } else if(right==n){
                break;
            } else{
                sum += arr[right++];
            }
        }

        System.out.println(answer);
    }
}
