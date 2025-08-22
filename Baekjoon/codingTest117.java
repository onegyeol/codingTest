package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 1013번 Contact
 * 
 * 최근 김동혁 박사는 아레시보 전파망원경에서 star Vega(직녀성) 으로부터 수신한 전파 기록의 일부를 조사하여 그 전파들의 패턴을 분석하여 아래와 같이 기록하였다. 
 * (100+1+ | 01)+
 * 김동혁 박사는 다양한 전파 기록 중에서 위의 패턴을 지니는 전파를 가려내는 프로그램을 필요로 한다. 이를 수행할 수 있는 프로그램을 작성하라.
 */

public class codingTest117 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String pattern = "(100+1+|01)+";

        for(int i=0; i<n; i++){
            String input = br.readLine();
            if(input.matches(pattern)){
                sb.append("YES\n");
            }
            else{
                sb.append("NO\n");
            }
        }

        System.out.println(sb);

    }
}
