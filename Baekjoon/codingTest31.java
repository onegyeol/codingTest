package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 1978번 소수 찾기
 * 
 * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 */
public class codingTest31 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer=0;

        for(int i=0; i<n; i++){
            if(isPirme(arr[i])) answer++;
        }

        System.out.println(answer);
        
    }

    static boolean isPirme(int k){
        int cnt=0;
        if(k == 1) return false;
        
        for(int i=2; i<=k/2; i++){
            if(k%i == 0) cnt++;
        }

        if(cnt !=0 ) return false;

        return true;
    }
}
