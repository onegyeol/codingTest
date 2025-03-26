package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class codingTest76{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int[] diff = new int[n-1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        if(k>=n){
            System.out.println(0);
            return;
        }

        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        for(int i=0; i<n-1; i++){
            diff[i] = num[i+1] - num[i];
        }
        
        Arrays.sort(diff);

        int sum = 0;

        for(int i=0; i<n-k; i++){
            sum += diff[i];
        }

        System.out.println(sum);
    }
}