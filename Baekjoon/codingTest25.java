package Baekjoon;

import java.util.*;
import java.io.*;

/*
    백준 1016번 제곱 ㄴㄴ 수

 * 어떤 정수 X가 1보다 큰 제곱수로 나누어 떨어지지 않을 때, 그 수를 제곱ㄴㄴ수라고 한다.
 *  제곱수는 정수의 제곱이다. min과 max가 주어지면, min보다 크거나 같고, max보다 작거나 같은 제곱ㄴㄴ수가 몇 개 있는지 출력한다.
 * 
 *  소수의 제곱과 나누어 떨어지지 않는 수 구하기
 */

public class codingTest25 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long min = in.nextLong();
        long max = in.nextLong();

        int size = (int)(max-min)+1;
        
        boolean[] isPrime = new boolean[size];

        int answer=0;

        for(long i=2; i<=Math.sqrt(max); i++){
            long tmp = i*i;
            long start = min%tmp==0 ? min/tmp : (min/tmp)+1 ;
            for(long j=start; j*tmp<=max; j++){
                isPrime[(int)((j*tmp) - min)] = true;
            }
        }

        for(int i=0; i<size; i++){
            if(!isPrime[i]) answer++;
        }

        System.out.println(answer);
    }
}
