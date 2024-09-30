package Baekjoon;

import java.util.*;

/*
 * 백준 11444번 피보나치 수 6
 * 
 */

public class codingTest45 {
    static long MOD = 1000000007;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        long n = in.nextLong();
        in.close();
        
        if(n==1) System.out.println(n);
        else{
            long[][] matrix = matrixPower(new long[][]{{1, 1}, {1, 0}}, n-1);
            System.out.println(matrix[0][0]);
        }
    }

    //행렬 제곱
    static long[][] matrixPower(long[][] matrix, long exp){
        long[][] result = {{1, 0}, {0, 1}}; // 단위 행렬
        while(exp>0){
            if(exp%2 != 0){
                result = matrixMultiply(matrix, result); //행렬 제곱
            }
            matrix=matrixMultiply(matrix, matrix); // 행렬 제곱
            exp /= 2;
        }

        return result;


    }

    // 행렬 곱셈
    static long[][] matrixMultiply(long[][] a, long[][] b){
        return new long[][]{
            {(a[0][0] * b[0][0] + a[0][1] * b[1][0])%MOD, (a[0][0] * b[0][1] + a[0][1] * b[1][1])%MOD},
            {(a[1][0] * b[0][0] + a[1][1] * b[1][0])%MOD, (a[1][0] * b[0][1] + a[1][1] * b[1][1])%MOD}
        };
    }
}
