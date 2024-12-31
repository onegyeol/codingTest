package Baekjoon;

import java.io.*;
import java.util.*;

/*
 * 
 * 백준 2839번 설탕 배달
 * 
 * 상근이는 요즘 설탕공장에서 설탕을 배달하고 있다. 상근이는 지금 사탕가게에 설탕을 정확하게 N킬로그램을 배달해야 한다. 
 * 설탕공장에서 만드는 설탕은 봉지에 담겨져 있다. 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
 * 상근이는 귀찮기 때문에, 최대한 적은 봉지를 들고 가려고 한다. 
 * 예를 들어, 18킬로그램 설탕을 배달해야 할 때, 3킬로그램 봉지 6개를 가져가도 되지만, 5킬로그램 3개와 3킬로그램 1개를 배달하면, 더 적은 개수의 봉지를 배달할 수 있다.
 * 상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오
 */

public class codingTest58 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        System.out.println(sugar(n));

    }

    static int sugar(int n){
        int cnt=0;

        while(n>=0){
            if(n%5==0){ // 5로 나눠지면
                cnt += n/5; 
                return cnt;
            }

            n-=3; // 5로 안나눠지면 3을 뺌
            cnt++;
        }

        return -1; // 안나눠지면 -1 리턴
    }
}
