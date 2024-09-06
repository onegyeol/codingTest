package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 
 * 백준 2293번 동전1
 * 
 * n가지 종류의 동전이 있다. 각각의 동전이 나타내는 가치는 다르다. 이 동전을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 
 * 그 경우의 수를 구하시오. 각각의 동전은 몇 개라도 사용할 수 있다.

사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다.
 */
public class codingTest27 {
    static int answer=0;
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        int[] dp = new int[k+1];

        for(int i=0; i<n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        dp[0]=1;

        for(int i=0; i<n; i++){
            for(int j=1; j<=k; j++){
                if(j>=coin[i]){
                    dp[j] += dp[j-coin[i]];
                }
            }
        }

        System.out.println(dp[k]);

    }

}
