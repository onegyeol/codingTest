package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 1032번 명령 프롬프트
 * 
 * dir *.exe라고 치면 확장자가 exe인 파일이 다 나온다. "dir 패턴"과 같이 치면 그 패턴에 맞는 파일만 검색 결과로 나온다. 
 * 예를 들어, dir a?b.exe라고 검색하면 파일명의 첫 번째 글자가 a이고, 세 번째 글자가 b이고, 확장자가 exe인 것이 모두 나온다. 
 * 이때 두 번째 문자는 아무거나 나와도 된다. 예를 들어, acb.exe, aab.exe, apb.exe가 나온다.
 * 이 문제는 검색 결과가 먼저 주어졌을 때, 패턴으로 뭘 쳐야 그 결과가 나오는지를 출력하는 문제이다. 패턴에는 알파벳과 "." 그리고 "?"만 넣을 수 있다. 
 * 가능하면 ?을 적게 써야 한다. 그 디렉토리에는 검색 결과에 나온 파일만 있다고 가정하고, 파일 이름의 길이는 모두 같다.
 * 
 */

public class codingTest115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] input = new String[n];

        for(int i=0; i<n; i++){
            input[i] = br.readLine();
        }

        for(int i=0; i<input[0].length(); i++){
            boolean flag = true;
            char tmp = input[0].charAt(i);
            for(int j=1; j<n; j++){
                if(input[j].charAt(i) != tmp){
                    flag=false;
                    break;
                }
            }

            if(!flag) sb.append("?");
            else sb.append(tmp);
        }

        System.out.println(sb);

        

        
    }
}
