package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * 백준 1253번 좋다
 * 
 * N개의 수 중에서 어떤 수가 다른 수 두 개의 합으로 나타낼 수 있다면 그 수를 “좋다(GOOD)”고 한다.
 * N개의 수가 주어지면 그 중에서 좋은 수의 개수는 몇 개인지 출력하라.
 * 수의 위치가 다르면 값이 같아도 다른 수이다.
 */

public class codingTest108 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);
        int answer=0;

        for(int i=0; i<n; i++){
            int target = input[i];
            // 두개 포인터 지정
            int left=0;
            int right=n-1;

            while(left < right){
                if(left==i) { // i와 똑같으면 넘김
                    left++;
                    continue;
                }

                if(right==i){
                    right--;
                    continue;
                }

                int sum = input[left]+input[right];
                if(sum == target){
                    answer++;
                    break;
                } else if(sum < target){
                    left++;
                } else{
                    right--;
                }
            }
        }

        System.out.println(answer);
        
    }
}
