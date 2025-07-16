package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * 백준 1251번 단어 나누기
 * 
 * 먼저 단어에서 임의의 두 부분을 골라서 단어를 쪼갠다. 즉, 주어진 단어를 세 개의 더 작은 단어로 나누는 것이다. 각각은 적어도 길이가 1 이상인 단어여야 한다. 이제 이렇게 나눈 세 개의 작은 단어들을 앞뒤를 뒤집고, 이를 다시 원래의 순서대로 합친다.
 * 예를 들어,
 * 
 * 단어 : arrested
세 단어로 나누기 : ar / rest / ed
각각 뒤집기 : ra / tser / de
합치기 : ratserde

 * 단어가 주어지면, 이렇게 만들 수 있는 단어 중에서 사전순으로 가장 앞서는 단어를 출력하는 프로그램을 작성하시오.
 */

public class codingTest105 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        ArrayList<String> result = new ArrayList<>();

        for(int i=1; i<str.length()-1; i++){
            for(int j=i+1; j<str.length(); j++){
                String part1 = new StringBuilder(str.substring(0, i)).reverse().toString();
                String part2 = new StringBuilder(str.substring(i, j)).reverse().toString();
                String part3 = new StringBuilder(str.substring(j, str.length())).reverse().toString();

                result.add(part1+part2+part3);
            }
        }

        Collections.sort(result);

        System.out.println(result.get(0));
    }
}
