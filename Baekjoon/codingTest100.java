package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 1083번 소트
 * 
 * 크기가 N인 배열 A가 있다. 배열에 있는 모든 수는 서로 다르다. 
 * 이 배열을 소트할 때, 연속된 두 개의 원소만 교환할 수 있다. 그리고, 교환은 많아봐야 S번 할 수 있다. 이때, 소트한 결과가 사전순으로 가장 뒷서는 것을 출력한다.
 * 
 * 첫째 줄에 N이 주어진다. N은 50보다 작거나 같은 자연수이다. 
 * 둘째 줄에는 각 원소가 차례대로 주어진다. 이 값은 1000000보다 작거나 같은 자연수이다. 
 * 마지막 줄에는 S가 주어진다. S는 1000000보다 작거나 같은 음이 아닌 정수이다.
 */

public class codingTest100 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            if(s == 0) break;
            
            int max = arr[i];
            int idx = i;

            for(int j=i+1; j<n && j<=i+s; j++){
                if(max < arr[j]){ // 최대값 찾기 위함
                    max = arr[j];
                    idx = j;
                }
            }

            if(idx != i){
                for(int j=idx; j>i; j--){ // 자리 이동
                    arr[j] = arr[j-1];
                    s--;
                }
                arr[i] = max;
            }
        }

        for(int i : arr) System.out.print(i + " ");
    }
}
