package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 1049번 기타줄
 * 
 * 끊어진 기타줄의 개수 N과 기타줄 브랜드 M개가 주어지고, 각각의 브랜드에서 파는 기타줄 6개가 들어있는 패키지의 가격, 낱개로 살 때의 가격이 주어질 때, 
 * 적어도 N개를 사기 위해 필요한 돈의 수를 최소로 하는 프로그램을 작성하시오.
 */

public class codingTest113 {
    static int n, m;
    static int[][] price;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        price = new int[m][2];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            price[i][0] = Integer.parseInt(st.nextToken());
            price[i][1] = Integer.parseInt(st.nextToken());
        }

        int minPackagePrice = Integer.MAX_VALUE;
        int minEachPrice = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            minPackagePrice = Math.min(minPackagePrice, price[i][0]);
            minEachPrice = Math.min(minEachPrice, price[i][1]);
        }

        // 낱개 가격
        int eachPrice = minEachPrice * n;
        //패키지 가격
        int packagePrice = minPackagePrice*((n+5)/6); // 6개 묶음이기에 6으로 묶었을 때 몫이 나오기 위해 5를 더함
        // 낱개 + 패키지
        int mixPrice = minPackagePrice*(n/6) + minEachPrice*(n%6);

        System.out.println(Math.min(mixPrice, Math.min(eachPrice, packagePrice)));
    }

}
