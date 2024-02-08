package progammers;

import java.util.HashMap;

/**프로그래머스 Lv.1 대충 만든 자판
 * 
 * 1번 키부터 차례대로 할당된 문자들이 순서대로 담긴 문자열배열 keymap과 입력하려는 문자열들이 담긴 문자열 배열 targets가 주어질 때, 
 * 각 문자열을 작성하기 위해 키를 최소 몇 번씩 눌러야 하는지 순서대로 배열에 담아 return 하는 solution 함수를 완성해 주세요.

단, 목표 문자열을 작성할 수 없을 때는 -1을 저장합니다.
 */


public class codingTest44 {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(String s : keymap){
            for(int i=0; i<s.length(); i++){
                char key = s.charAt(i);
                map.put(key, Math.min(i+1, map.getOrDefault(key, Integer.MAX_VALUE)));
                //주어진 자판 중 최소 수를 넣기 위함
            }
        }
        
        for(int i=0; i<targets.length; i++){
            String s = targets[i];
            for(int j=0; j<s.length(); j++){
                char c = s.charAt(j);
                if(map.containsKey(c)) answer[i] += map.get(c); //map에 해당 키가 있으면
                else { //없으면 -1 넣은 후 break
                    answer[i] = -1;
                    break;
                }
            }

        }
        return answer;
    }
}
