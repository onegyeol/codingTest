package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1759번 암호만들기
 * 
 * 바로 어제 최백준 조교가 방 열쇠를 주머니에 넣은 채 깜빡하고 서울로 가 버리는 황당한 상황에 직면한 조교들은,
 *  702호에 새로운 보안 시스템을 설치하기로 하였다. 이 보안 시스템은 열쇠가 아닌 암호로 동작하게 되어 있는 시스템이다.

암호는 서로 다른 L개의 알파벳 소문자들로 구성되며 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성되어 있다고 알려져 있다. 
또한 정렬된 문자열을 선호하는 조교들의 성향으로 미루어 보아 암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열되었을 것이라고 추측된다. 
즉, abc는 가능성이 있는 암호이지만 bac는 그렇지 않다.

새 보안 시스템에서 조교들이 암호로 사용했을 법한 문자의 종류는 C가지가 있다고 한다. 
이 알파벳을 입수한 민식, 영식 형제는 조교들의 방에 침투하기 위해 암호를 추측해 보려고 한다. 
C개의 문자들이 모두 주어졌을 때, 가능성 있는 암호들을 모두 구하는 프로그램을 작성하시오.
 */

public class codingTest4 {
    static int l, c;
    static String[] board, pw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" "); //공백 기준으로 나눔

        l = Integer.parseInt(str[0]);
        c = Integer.parseInt(str[1]);
        
        pw = new String[l]; //암호 저장
        board = new String[c]; //조교들이 쓸만한 알파벳 저장

        board = br.readLine().split(" ");
        Arrays.sort(board); //오름차순정렬
        combi(0, 0);

    }

    static void combi(int len, int start){
        if(len>=l){
            if(check(pw)){ //먼저 조건 만족하는지 확인
                for(String p : pw){
                    System.out.print(p);
                }
                System.out.println();
            }
            return;
        }

        for(int i=start; i<c; i++){
            pw[len] = board[i];
            combi(len+1, i+1);
        }
    }

    static boolean check(String[] pwd){
        int t = 0; //자음
        int v = 0; //모음
        
        for(int i=0; i<pw.length; i++){
            if(pw[i].equals("a") || pw[i].equals("e") || pw[i].equals("i")
                ||pw[i].equals("o") || pw[i].equals("u")) v++;
            else t++;
        }
        if(t>=2 && v>=1) return true; //최소 한개의 모음과 두개의 자음 필요
        else return false;
    }

}
