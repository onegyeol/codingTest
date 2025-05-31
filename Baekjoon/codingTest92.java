package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 1120번 문자열
 * 
 * 길이가 N으로 같은 문자열 X와 Y가 있을 때, 두 문자열 X와 Y의 차이는 X[i] ≠ Y[i]인 i의 개수이다. 예를 들어, X=”jimin”, Y=”minji”이면, 둘의 차이는 4이다.
 * 두 문자열 A와 B가 주어진다. 이때, A의 길이는 B의 길이보다 작거나 같다. 이제 A의 길이가 B의 길이와 같아질 때 까지 다음과 같은 연산을 할 수 있다.
 * 1. A의 앞에 아무 알파벳이나 추가한다.
 * 2. A의 뒤에 아무 알파벳이나 추가한다.
 * 이때, A와 B의 길이가 같으면서, A와 B의 차이를 최소로 하는 프로그램을 작성하시오.
 * 
 * B의 문자열은 고정. A의 앞 뒤에 아무거나 추가 가능
 * 즉, B의 어느 지점부터 A와 유사한지 찾으면 됨
 * 
 */

public class codingTest92 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        int result = Integer.MAX_VALUE;

        for(int i=0; i<=b.length()-a.length(); i++){
            int cnt=0;
            for(int j=0; j<a.length(); j++){
                if(a.charAt(j) != b.charAt(i+j)) cnt++; // 같지 않은 문자 갯수 카운트
            }
            result = Math.min(cnt, result); // 그 중 최소값을 찾음
        }

        System.out.println(result);
    }
}
