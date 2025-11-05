package progammers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * 프로그래머스 Lv.2 2021 KAKAO BLIND RECRUITMENT 메뉴 리뉴얼
 * 
 * 각 손님들이 주문한 단품메뉴들이 문자열 형식으로 담긴 배열 orders, 
 * "스카피"가 추가하고 싶어하는 코스요리를 구성하는 단품메뉴들의 갯수가 담긴 배열 course가 매개변수로 주어질 때, 
 * "스카피"가 새로 추가하게 될 코스요리의 메뉴 구성을 문자열 형태로 배열에 담아 return 하도록 solution 함수를 완성해 주세요.
 */

public class codingTest124 {
    static Map<String, Integer> map;
    static int max=0;
    public static void main(String[] args) {
        // orders, course 입력받음
    }
    
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        
        // course 갯수만큼 
        for(int c : course){
            map = new HashMap<>();
            max=0;
            
            for(String order : orders){
                char[] str = order.toCharArray();
                Arrays.sort(str);
                order = new String(str);
                
                dfs(order, "", -1, c, 0);
            }
            
            for(String key : map.keySet()){
                int value = map.get(key);
                
                // 단품 메뉴 주문 횟수 2개 이상이어야 함
                // 조합에 따라 가장 많은 메뉴로 정함
                if(value>1 && max==value){
                    answer.add(key);
                }
            }
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }
    
    static void dfs(String order, String key, int idx, int end, int depth){
        if(depth == end){ // 길이가 동일해지면
            map.put(key, map.getOrDefault(key, 0)+1);
            max = Math.max(max, map.get(key));
        }
        
        for(int i=idx+1; i<order.length(); i++){
            dfs(order, key+order.charAt(i), i, end, depth+1);
        }
    }
}
