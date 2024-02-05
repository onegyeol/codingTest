package progammers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 Lv.1 옹알이(2)
 * 머쓱이는 태어난 지 11개월 된 조카를 돌보고 있습니다. 조카는 아직 "aya", "ye", "woo", "ma" 
 * 네 가지 발음과 네 가지 발음을 조합해서 만들 수 있는 발음밖에 하지 못하고 연속해서 같은 발음을 하는 것을 어려워합니다. 
 * 문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
 */

public class codingTest38 {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] arr = {"aya", "ye", "woo", "ma"};
        Queue<String> q = new LinkedList<>(); //연달아 발음하는 것을 찾기 위해 큐 사용
        
        for(int i=0; i<babbling.length; i++){
            String s = "";
            int len=0;
            for(int j=0; j<babbling[i].length(); j++){
                s += babbling[i].substring(j, j+1);
                for(int k=0; k<arr.length; k++){
                    if(arr[k].equals(s)){
                        if(!q.isEmpty() && (q.poll()).equals(s)) break; 
                        len += s.length();
                        q.offer(s);
                        s="";
                    }
                }
            }
            
            if(len == babbling[i].length()) answer++;
            q.clear();
        }
        return answer;
    }

    /**다른 사람 풀이
     * public int solution(String[] babblings) {
        // "aya", "ye", "woo", "ma" 4가지 발음만 가능
        int answer = 0;
        for(int i = 0; i < babblings.length; i++) {
            if(babblings[i].contains("ayaaya") || babblings[i].contains("yeye") || babblings[i].contains("woowoo") || babblings[i].contains("mama")) {
                continue;
            }

            babblings[i] = babblings[i].replace("aya", " "); //각 발음들이 존재한다면 공백으로 바꿔줌
            babblings[i] = babblings[i].replace("ye", " ");
            babblings[i] = babblings[i].replace("woo", " ");
            babblings[i] = babblings[i].replace("ma", " ");
            babblings[i] = babblings[i].replace(" ", "");

            if(babblings[i].length()  == 0) answer++; //공백으로 바뀌었다는 건 발음할 수 있단 단어가 있단 뜻이기에 answer+1

        }
        return answer;
       }
     */
}
