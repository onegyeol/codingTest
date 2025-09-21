package progammers;

import java.util.HashMap;
import java.util.Map;

/*
 * 프로그래머스 Lv.1 2022 KAKAO TECH INTERNSHIP 성격 유형 검사하기
 */

public class codingTest104 {
    public static void main(String[] args) {
        
    }
    static String solution(String[] survey, int[] choices) {
        Map<Character, Integer> scoreMap = new HashMap<>();
        String types = "RTCFJMAN"; // 8개 지표
        for (char c : types.toCharArray()) {
            scoreMap.put(c, 0);
        }
        
        for(int i=0; i<survey.length; i++){
            char disagree = survey[i].charAt(0);
            char agree = survey[i].charAt(1);
            int choice = choices[i];
            
            if (choice<4){
               scoreMap.put(disagree, scoreMap.get(disagree) + (4 - choice));
            }
            else if (choice>4){
               scoreMap.put(agree, scoreMap.get(agree)+(choice-4));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(scoreMap.get('R') >= scoreMap.get('T') ? 'R':'T');
        sb.append(scoreMap.get('C') >= scoreMap.get('F') ? 'C':'F');
        sb.append(scoreMap.get('J') >= scoreMap.get('M') ? 'J':'M');
        sb.append(scoreMap.get('A') >= scoreMap.get('N') ? 'A':'N');
        return sb.toString();
    }
}
