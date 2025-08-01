package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 1254번 팰린드롬 만들기 
 * 
 * 동호는 규완이를 위한 깜짝 선물을 준비했다. 동호는 규완이가 적어놓고 간 문자열 S에 0개 이상의 문자를 문자열 뒤에 추가해서 팰린드롬을 만들려고 한다. 
 * 동호는 가능하면 가장 짧은 문자열을 만들려고 한다.
 * 동호가 만들 수 있는 가장 짧은 팰린드롬의 길이를 출력하는 프로그램을 작성하시오.
 * 
 */

public class codingTest110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        for(int i=0; i<s.length(); i++){
            if(isPalindrom(s.substring(i))){ // 최소 팰린드롬
                System.out.println(s.length()+i);
                return;
            }
        }
        
    }
    
    static boolean isPalindrom(String str){
        int left=0;
        int right=str.length()-1;

        while(left<right){
            if(str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--; 
        }

        return true;

    }
}
