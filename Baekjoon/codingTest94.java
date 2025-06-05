package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 1041번 주사위
 * 
 * A, B, C, D, E, F에 쓰여 있는 수가 주어진다.

지민이는 현재 동일한 주사위를 N3개 가지고 있다. 이 주사위를 적절히 회전시키고 쌓아서, N×N×N크기의 정육면체를 만들려고 한다. 이 정육면체는 탁자위에 있으므로, 5개의 면만 보인다.

N과 주사위에 쓰여 있는 수가 주어질 때, 보이는 5개의 면에 쓰여 있는 수의 합의 최솟값을 출력하는 프로그램을 작성하시오.
 */

public class codingTest94{
    static long n, oneFace, twoFace, threeFace, max=0;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[6];
        for(int i=0; i<6; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]); // N이 1일때 가장 큰 값을 제외하고, 더하기 위함
            sum += arr[i];
        }

        if(n==1){
            System.out.println(sum-max);
            return;
        }

        // 공존할 수 없는 면들 중 최소 값을 각각 찾음
        long af = Math.min(arr[0], arr[5]);
        long eb = Math.min(arr[1], arr[4]);
        long cd = Math.min(arr[2], arr[3]);

        threeFace = af+eb+cd;
        twoFace = Math.min(af+eb, Math.min(eb+cd, cd+af));
        oneFace = Math.min(af, Math.min(eb, cd));

        System.out.println(calculateMin());
    }

    static public long calculateMin(){
        long threeSide = 4;
        long twoSide = 4*(n-1)+4*(n-2);
        long oneSide = 4*(n-2)*(n-1)+(n-2)*(n-2);

        return (threeSide*threeFace) + (twoSide*twoFace) + (oneSide*oneFace);
    }
}