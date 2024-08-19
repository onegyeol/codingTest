package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2294번 동전2
 * n가지 종류의 동전이 있다. 이 동전들을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 
 * 그러면서 동전의 개수가 최소가 되도록 하려고 한다. 각각의 동전은 몇 개라도 사용할 수 있다.
 */

public class codingTest23 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];

        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k+1];

        for(int i=1; i<=k; i++){
            dp[i] = Integer.MAX_VALUE-1;
        }

        for(int i=1; i<=n; i++){
            for(int j=arr[i]; j<=k; j++){
                dp[j] = Math.min(dp[j], dp[j-arr[i]]+1);
            }
        }

        if(dp[k-1] == Integer.MAX_VALUE-1) System.out.println(-1);
        else System.out.println(dp[k]);



    }
}
