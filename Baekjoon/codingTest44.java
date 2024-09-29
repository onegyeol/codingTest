package Baekjoon;

import java.util.*;

/**
 * 백준 2749번 피보나치3
 * 
 * 피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.

이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.

n=17일때 까지 피보나치 수를 써보면 다음과 같다.

0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597

n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
 */
public class codingTest44 {
    static int MOD = 1000000;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long n = in.nextLong();
        in.close();

        if(n==0) System.out.println(0);
        else{
            long[][] result = matrixPower(new long[][]{{1, 1}, {1, 0}}, n-1);
            System.out.println(result[0][0]);
        }
    }

    static long[][] matrixPower(long[][] matrix, long exp){ // 행렬 제곱
        long[][] result = {{1,0}, {0, 1}};
        while(exp > 0){
            if(exp%2 != 0){
                result = matrixMultiply(result, matrix); // 홀수일때 결과 행렬에 곱함
            }
            matrix = matrixMultiply(matrix, matrix);
            exp /= 2; // 지수를 반으로 줄임
        }

        return result;
    }

    static long[][] matrixMultiply(long[][] a, long[][] b){ // 행렬 곱셈
        return new long[][]{
            {(a[0][0] * b[0][0] + a[0][1] * b[1][0])%MOD, (a[0][0] * b[0][1] + a[0][1] * b[1][1])%MOD},
            {(a[1][0] * b[0][0] + a[1][1] * b[1][0])%MOD, (a[1][0] * b[0][1] + a[1][1] * b[1][1])%MOD}
        };
    }

  
}
