package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 1235번 학생 번호
 * 
 * 하지만 세 자리보다 적게 남겨 놓아서는 모든 학생들의 학생 번호를 서로 다르게 만들 수 없다.
 * 학생들의 번호가 주어 졌을 때, 뒤에서 k자리만을 추려서 남겨 놓았을 때 모든 학생들의 학생 번호를 서로 다르게 만들 수 있는 최소의 k를 구하는 프로그램을 작성하시오.
 */

public class codingTest103 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = new String[n];

        for(int i=0; i<n; i++){
            input[i] = br.readLine();
        }

        int[] arr = new int[n];
        int answer=0;
        int len=input[0].length();
        for(int i=len-1; i>=0; i--){
            boolean flag=true;
            answer++;
            for(int j=0; j<n; j++){
                String str = input[j].substring(i, len);
                arr[j] = Integer.parseInt(str);
            }

            for(int j=0; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    if(arr[j] == arr[k]){
                        flag=false;
                        break;
                    }
                }
            }

            if(flag) break;
        }

        System.out.println(answer);
    }
}
