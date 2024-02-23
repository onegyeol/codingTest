package progammers;

import java.util.Arrays;

/**
 * 프로그래머스 Lv.2 H-index
 * 
 * 문제 이상함..
 */

public class codingTest54 {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        for(int i=0; i<citations.length; i++){
            answer = Math.max(answer, Math.min(citations[i], citations.length-i));
        }
        return answer;
       
    }

}
