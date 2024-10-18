package Baekjoon;

import java.util.*;
import java.io.*;

/**
 * 백준 1080번 행렬
 * 
 * 0과 1로만 이루어진 행렬 A와 행렬 B가 있다. 
 * 이때, 행렬 A를 행렬 B로 바꾸는데 필요한 연산의 횟수의 최솟값을 구하는 프로그램을 작성하시오.
 * 행렬을 변환하는 연산은 어떤 3×3크기의 부분 행렬에 있는 모든 원소를 뒤집는 것이다. (0 → 1, 1 → 0)
 */

public class codingTest50 {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<2; i++){
            for(int a=0; a<n; a++){
                for(int b=0; b<m; b++){
                    
                }
            }
        }
        
    }
}
