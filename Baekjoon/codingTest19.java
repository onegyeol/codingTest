package Baekjoon;

import java.util.*;
import java.io.*;

/**
 * 백준 30802번 웰컴 키트
 * 
 * 2024년 2월 3일 개최 예정인 온사이트 그랜드 아레나에서는 참가자들에게 티셔츠 한 장과 펜 한 자루가 포함된 웰컴 키트를 나눠줄 예정입니다. 
 * 키트를 제작하는 업체는 다음과 같은 조건으로만 주문이 가능합니다.

티셔츠는 S, M, L, XL, XXL, 그리고 XXXL의 6가지 사이즈가 있습니다. 
티셔츠는 같은 사이즈의 T장 묶음으로만 주문할 수 있습니다.
펜은 한 종류로, P자루씩 묶음으로 주문하거나 한 자루씩 주문할 수 있습니다.
총 N명의 참가자 중 S, M, L, XL, XXL, XXXL 사이즈의 티셔츠를 신청한 사람은 각각 
S, M, L, XL, XXL, XXXL명입니다. 티셔츠는 남아도 되지만 부족해서는 안 되고 신청한 사이즈대로 나눠주어야 합니다. 
펜은 남거나 부족해서는 안 되고 정확히 참가자 수만큼 준비되어야 합니다.

티셔츠를 T장씩 최소 몇 묶음 주문해야 하는지, 그리고 펜을 P자루씩 최대 몇 묶음 주문할 수 있고, 그 때 펜을 한 자루씩 몇 개 주문하는지 구하세요.
 */
public class codingTest19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(); //전체 인원
        int[] size = new int[6];

        for(int i=0; i<6; i++){
            size[i] = in.nextInt(); //티셔츠 사이즈 별 인원
        }

        int t = in.nextInt(); //티셔츠 묶음
        int p = in.nextInt(); //펜 묶음

        int cnt=0;

        for(int j : size){
            cnt += j/t;
            if(j!=0 && t!=1 && j%t !=0){
                cnt++;
            }
        }

        System.out.println(cnt);
        System.out.println(n/p + " " + n%p);

    
    }
}
