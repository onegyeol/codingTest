package progammers;

import java.util.ArrayList;
import java.util.List;

/**
 * 프로그래머스 Lv.2 모음 사전
 * 
 * 사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는, 
 * 길이 5 이하의 모든 단어가 수록되어 있습니다. 
 * 사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며, 마지막 단어는 "UUUUU"입니다.

단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.
 */

public class codingTest70 {
    static String[] words = {"A", "E", "I", "O", "U"}; //모음
    static List<String> list;
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        dfs("", 0);
        
        for(int i=0; i<list.size(); i++){
            if(list.get(i).equals(word)){
                answer = i;
                break;
            }
        }
        return answer;
    }
    
    static void dfs(String s, int l){
        list.add(s);
        if(l == 5) return;
        for(int i=0; i<5; i++){
            dfs(s+words[i], l+1);
        }
    }

    /**
     * 다른사람 풀이
     * 
     * List<String> list = new ArrayList<>();
        void dfs(String str, int len) {
            if(len > 5) return;
            list.add(str);
            for(int i = 0; i < 5; i++) dfs(str + "AEIOU".charAt(i), len + 1);
        }
        public int solution(String word) {
            dfs("", 0);
            return list.indexOf(word);
        }
     */

}
