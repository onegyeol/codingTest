package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 18312번 시각
 * 
 * 정수 N과 K가 입력되었을 때 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서 K가 하나라도 포함되는 모든 시각을 세는 프로그램을 작성하시오. 
 * 시각을 셀 때는 디지털 시계를 기준으로, 초 단위로만 시각을 구분한다.
 */

public class codingTest119 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int answer = 0;

        for(int h=0; h<=n; h++){
            boolean hour = hasTime(h, k);
            for(int m=0; m<60; m++){
                boolean min = hasTime(m, k);
                for(int s=0; s<60; s++){
                    if(hour || min || hasTime(s, k)) answer++;
                }
            }
        }
        
        System.out.println(answer);
    }

    private static boolean hasTime(int s, int k){
        int tens = s/10;
        int ones = s%10;

        return tens==k || ones==k;
    }
}
