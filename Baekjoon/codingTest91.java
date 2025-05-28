package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 백준 1141번 접두사
 * 
 * 접두사X 집합이란 집합의 어떤 한 단어가, 다른 단어의 접두어가 되지 않는 집합이다. 예를 들어, {hello}, {hello, goodbye, giant, hi}, 비어있는 집합은 모두 접두사X 집합이다. 하지만, {hello, hell}, {giant, gig, g}는 접두사X 집합이 아니다. 
 * 단어 N개로 이루어진 집합이 주어질 때, 접두사X 집합인 부분집합의 최대 크기를 출력하시오
 */

public class codingTest91 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];

        for(int i=0; i<n; i++){
            str[i] = br.readLine();
        }

        Arrays.sort(str, (a, b) -> b.length()-a.length()); // 내림차순

        List<String> answer = new ArrayList<>();

        for(int i=0; i<n; i++){
            boolean flag = false;
            for(String s : answer){
                if(s.startsWith(str[i])){ // 접두사이면
                    flag=true;
                    break; // 멈춤
                }
            }
            if(!flag){ // 접두사인게 없다면 추가
                answer.add(str[i]);
            }
        }

        System.out.println(answer.size());
    }
}
