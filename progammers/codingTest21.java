package progammers;


/*
사람의 수 n과 사람들이 순서대로 말한 단어 words 가 매개변수로 주어질 때, 
가장 먼저 탈락하는 사람의 번호와 그 사람이 자신의 몇 번째 차례에 탈락하는지를 구해서 return 하도록 solution 함수를 완성해주세요.



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

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        int cnt = 1; //개수 카운트하기 위해 사용
        Set<String> set = new HashSet<>(); //SET 자료구조의 특성 이용
        set.add(words[0]);
        
        for(int i=1; i<words.length; i++) {
            if(set.contains(words[i])) break;
            if(words[i].charAt(0)==words[i-1].charAt(words[i-1].length()-1)) {
                set.add(words[i]);
                cnt++;
            }
            else break;
        }
        
        if(cnt==words.length) answer = new int[] {0,0}; //올바르면 [0, 0] 리턴
        else answer = new int[] {cnt%n+1, cnt/n+1};

        return answer;
    }
}