package progammers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 프로그래머스 Lv.1 둘만의 암호
 * 
 * 두 문자열 s와 skip, 그리고 자연수 index가 주어질 때, 다음 규칙에 따라 문자열을 만들려 합니다. 암호의 규칙은 다음과 같습니다.

문자열 s의 각 알파벳을 index만큼 뒤의 알파벳으로 바꿔줍니다.
index만큼의 뒤의 알파벳이 z를 넘어갈 경우 다시 a로 돌아갑니다.
skip에 있는 알파벳은 제외하고 건너뜁니다.

 */

public class codingTest45 {
    public String solution(String s, String skip, int index) {
        String answer = "";
        ArrayList<Character> alphabet = new ArrayList<>();
        List<Character> skip_ch = skip.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    
        char currentChar = 'a';
        
        for(int i=0; i<26; i++){
            if(!skip_ch.contains(currentChar)) alphabet.add(currentChar);
            currentChar++;
        }
        
        for(int i=0; i<s.length(); i++){
            int charIndex = alphabet.indexOf(s.charAt(i));

            if(charIndex != -1) { //s.charAt(i) 문자가 찾아지지 않을 때 런타임 에러 발생하기 때문
                int j = (charIndex + index) % alphabet.size(); //z보다 커지면 다시 a로 돌아가기 위함 로직
                answer += String.valueOf(alphabet.get(j));
            } 
            else{
                answer += String.valueOf(alphabet.get(charIndex+index));
            }
        }
        return answer;
    }

    /** 다른사람 풀이
     * 
     * public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder(); //일반 문자열은 불변이기에 StringBuilder 사용해서 가변 문자열로 

        for (char letter : s.toCharArray()) {
            char temp = letter;
            int idx = 0;
            while (idx < index) { //index 수만큼 돌아감 
                temp = temp == 'z' ? 'a' : (char) (temp + 1); //temp가 z이면 a로 돌아가고 아니면 temp에 +1 해줌
                if (!skip.contains(String.valueOf(temp))) { //skip에 temp가 들어있지 않으면 
                    idx += 1;
                }
            }
            answer.append(temp); //answer에 더해줌
        }

        return answer.toString();
    }
     */

}
