package Baekjoon;

import java.io.*;

/*
 * 백준 12904번 A와 B
 * 
 * 이런 사실에 놀란 수빈이는 간단한 게임을 만들기로 했다. 두 문자열 S와 T가 주어졌을 때, S를 T로 바꾸는 게임이다. 문자열을 바꿀 때는 다음과 같은 두 가지 연산만 가능하다.
 * 문자열의 뒤에 A를 추가한다.
 * 문자열을 뒤집고 뒤에 B를 추가한다.
 * 주어진 조건을 이용해서 S를 T로 만들 수 있는지 없는지 알아내는 프로그램을 작성하시오. 
 * 
 * S -> T가 아닌 T -> S 방향으로 접근
 */

public class codingTest70 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder(br.readLine());
        StringBuilder t = new StringBuilder(br.readLine());

        while(s.length() < t.length()){
            if(t.charAt(t.length()-1) == 'A') t.deleteCharAt(t.length()-1); // A이면 그냥 삭제
            else if(t.charAt(t.length()-1) == 'B'){ // B이면 놔둠
                t.deleteCharAt(t.length()-1);
                t.reverse();
            }
        }

        if((t.toString()).equals(s.toString())) System.out.println(1);
        else System.out.println(0);
    }
}
