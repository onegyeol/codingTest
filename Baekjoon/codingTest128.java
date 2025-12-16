package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
백준 1316번 그룹 단어 체커

그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, 
kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.

단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
*/

public class codingTest128 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        String[] word = new String[n];

        for(int i=0; i<n; i++){
            word[i] = br.readLine();
        }
        int answer=0;


        for(int i=0; i<n; i++){
            Map<Character, Integer> map = new HashMap<>();
            boolean flag = true;
            for(int j=0; j<word[i].length(); j++){
                char s = word[i].charAt(j);

                if(!map.containsKey(s)){
                    map.put(s, j);
                }
                else{
                    int idx = map.get(s);
                    if(idx == j-1){
                        map.put(s, j);
                    }
                    else flag=false;
                }
            }

            if(flag) answer++;
        }

        System.out.print(answer);
    }
}
