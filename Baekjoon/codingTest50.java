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
    static int[][] arr1, arr2;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        arr1 = new int[n][m];
        arr2 = new int[n][m];

        // 행렬 a 입력
        for(int i=0; i<n; i++){
            String str = in.next();
            for(int j=0; j<m; j++){
                arr1[i][j] = Integer.parseInt(str.substring(j, j+1));
            }
        }

        // 행렬 b 입력
        for(int i=0; i<n; i++){
            String str = in.next();
            for(int j=0; j<m; j++){
                arr2[i][j] = Integer.parseInt(str.substring(j, j+1));
            }
        }

        int cnt=0;
        for(int i=0; i<n-2; i++){
            for(int j=0; j<m-2; j++){
                if(arr1[i][j]!=arr2[i][j]){
                    change(i, j);
                    cnt++;
                } 
            }
        }

        boolean flag=true;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr1[i][j]!=arr2[i][j]){
                    flag = false;
                } 
            }
        }

        if(flag) System.out.println(cnt);
        else System.out.println(-1);
        
    }

    static void change(int a, int b){
        for(int i=a; i<a+3; i++){
            for(int j=b; j<b+3; j++){
                arr1[i][j] = arr1[i][j]^1;
            }
        }
    }
}
