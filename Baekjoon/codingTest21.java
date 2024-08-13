package Baekjoon;

import java.io.*;

/**
 * 백준 2444번 별찍기 - 7
 *
 */

public class codingTest21 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                sb.append(" ");
            }
            for(int j=1; j<=2*i-1; j++){
                sb.append("*");
            }
            sb.append("\n");
        }

        for(int i=n-1; i>0; i--){
            for(int j=1; j<=n-i; j++){
                sb.append(" ");
            }
            for(int j=1; j<=2*i-1; j++){
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
