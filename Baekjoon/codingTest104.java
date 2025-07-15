package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*
 * 백준 1283번 단축키 지정
 * 
 * 한글 프로그램의 메뉴에는 총 N개의 옵션이 있다. 각 옵션들은 한 개 또는 여러 개의 단어로 옵션의 기능을 설명하여 놓았다. 그리고 우리는 위에서부터 차례대로 각 옵션에 단축키를 의미하는 대표 알파벳을 지정하기로 하였다. 단축키를 지정하는 법은 아래의 순서를 따른다.
 * 
 * 먼저 하나의 옵션에 대해 왼쪽에서부터 오른쪽 순서로 단어의 첫 글자가 이미 단축키로 지정되었는지 살펴본다. 만약 단축키로 아직 지정이 안 되어있다면 그 알파벳을 단축키로 지정한다.
 * 만약 모든 단어의 첫 글자가 이미 지정이 되어있다면 왼쪽에서부터 차례대로 알파벳을 보면서 단축키로 지정 안 된 것이 있다면 단축키로 지정한다.
 * 어떠한 것도 단축키로 지정할 수 없다면 그냥 놔두며 대소문자를 구분치 않는다.
 * 위의 규칙을 첫 번째 옵션부터 N번째 옵션까지 차례대로 적용한다.
 * 
 * 
N개의 줄에 각 옵션을 출력하는데 단축키로 지정된 알파벳은 좌우에 [] 괄호를 씌워서 표현한다.
 */

public class codingTest104 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Set<Character> usedKeys = new HashSet<>();

        for(int i=0; i<n; i++){
            String str = br.readLine();
            String[] stArr = str.split(" ");
            boolean flag = false;

            // 단어에서 첫 글자
            for(int j=0; j<stArr.length; j++){
                char first = Character.toUpperCase(stArr[j].charAt(0));
                if(!usedKeys.contains(first)){
                    usedKeys.add(first);
                    stArr[j] = "[" + stArr[j].charAt(0) + "]" + stArr[j].substring(1);
                    flag = true;
                    break;
                }
            }

            // 첫 글자에서 못 찾으면
            if(!flag){
                outer:
                for (int j = 0; j < stArr.length; j++) {
                    String word = stArr[j];
                    for (int k = 0; k < word.length(); k++) {
                        char ch = Character.toUpperCase(word.charAt(k));
                        if (!usedKeys.contains(ch)) {
                            usedKeys.add(ch);
                            stArr[j] = word.substring(0, k) + "[" + word.charAt(k) + "]" + word.substring(k + 1);
                            break outer;  // 단축키 하나 찾으면 두 루프 다 종료
                        }
                    }
                }
            }

            sb.append(String.join(" ", stArr)).append("\n");
        }

        System.out.println(sb);
        
    }
}
