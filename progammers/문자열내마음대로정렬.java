package progammers;

import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        
        for(int i=0; i<strings.length; i++){
            String tmp = strings[i].substring(n, n+1);
            answer[i] = tmp + strings[i];
        }
        
        Arrays.sort(answer);
        
        for(int i=0; i<answer.length; i++){
            answer[i] = answer[i].substring(1);
        }
        return answer;
    }
}
