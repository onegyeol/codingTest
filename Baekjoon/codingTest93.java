package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 1213번 팰린드롬 만들기
 * 
 * 임문빈은 임한수의 영어 이름으로 팰린드롬을 만들려고 하는데, 임한수의 영어 이름의 알파벳 순서를 적절히 바꿔서 팰린드롬을 만들려고 한다.
 * 임문빈을 도와 임한수의 영어 이름을 팰린드롬으로 바꾸는 프로그램을 작성하시오.
 */

public class codingTest93 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int[] alpha = new int[26];
        
        
        for(int i=0; i<str.length(); i++){
            int idx = str.charAt(i) - 'A';
            alpha[idx]++;
        }

        int odd=0;
        int num=0;

        for(int i=0; i<alpha.length; i++){
            if(alpha[i]%2==1){
                odd++;
                num=i; // 추후에 알파벳으로 바꾸기 위함
            }
            if(odd > 1){ // 알파벳의 갯수가 홀수인게 2개 이상이면 팰린드롬을 만들지 못함
                System.out.println("I'm Sorry Hansoo");
                return ;
            }
        }

        for(int i=0; i<alpha.length; i++){
            for(int j=0; j<alpha[i]/2; j++){ // 절반씩만 추가
                sb.append((char)(i+'A'));
            }
        }

        String result = sb.toString();
        if(odd==1) result += (char)(num+'A'); // 홀수인 것 중간에 추가
        result += sb.reverse().toString(); // sb에 추가된 것 반대로 해서 추가

        System.out.println(result);
        
    }
}
