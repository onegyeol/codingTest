package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * N개의 아이템
 * 각각 (무게 W, 가치 V)이 주어지고 배낭 용량은 C이다.
 * 담을 수 있는 최대 가치를 구하라.
 */

public class test9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] dp = new int[c+1];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            for(int j=c; j>=w; j--){
                dp[j] = Math.max(dp[j], dp[j-w]+v);
            }
        }

        System.out.println(dp[c]);
        
    }
}
