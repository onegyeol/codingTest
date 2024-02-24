package progammers;

/** 프로그래머스 Lv.0 외계어 사전
 * 
 * PROGRAMMERS-962 행성에 불시착한 우주비행사 머쓱이는 외계행성의 언어를 공부하려고 합니다. 
 * 알파벳이 담긴 배열 spell과 외계어 사전 dic이 매개변수로 주어집니다. 
 * spell에 담긴 알파벳을 한번씩만 모두 사용한 단어가 dic에 존재한다면 1, 존재하지 않는다면 2를 return하도록 solution 함수를 완성해주세요.
 */


public class codingTest56 {
    class Solution {
        public int solution(String[] spell, String[] dic) {
            int answer=2;
            for (String word : dic) {
                boolean[] found = new boolean[spell.length]; // 스펠링의 존재 여부를 체크하기 위한 배열
    
                for (int i = 0; i < word.length(); i++) {
                    char letter = word.charAt(i); // 현재 단어의 문자
                    for (int j = 0; j < spell.length; j++) {
                        if (letter == spell[j].charAt(0)) { // 스펠링에 해당 문자가 있다면
                            found[j] = true; // 해당 인덱스에 true로 체크
                            break; // 해당 문자를 찾았으므로 다음 문자로 넘어감
                        }
                    }
                }
    
                boolean allFound = true;
                for (boolean f : found) {
                    if (!f) {
                        allFound = false;
                        break;
                    }
                }
    
                if (allFound) answer = 1; // 모든 스펠링이 딕셔너리 안에 있을 경우
            }
            return answer; // 딕셔너리 안에 모든 스펠링이 없을 경우
        }
    }
    
}
