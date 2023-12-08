package progammers;
/*

내가 쓴 풀이. list 로 작성했는데 너무 비효율적인 것 같음.
굳이 리스트를 사용할 필요가 없는데..

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        int p=1, cnt=0;
        List<String> lst = new ArrayList<>();
        
        for(int i=0; i<words.length; i++){
            if(lst.contains(words[i])){
                answer[0] = (i%n)+1;
                answer[1] = (i/n)+1;
                break;
            }
            
            lst.add(words[i]);
            
            if(i>0 && (words[i-1].charAt(words[i-1].length() - 1) != words[i].charAt(0))){
                answer[0] = (i%n)+1;
                answer[1] = (i/n)+1;
                break;
            }
        }
        return answer;
    }
}*/