package progammers;

import java.util.HashSet;
import java.util.Set;

/*
 * 프로그래머스 Lv.3 2019 카카오 개발자 겨울 인턴십 불량 사용자
 * 
 * 이벤트 응모자 아이디 목록이 담긴 배열 user_id와 불량 사용자 아이디 목록이 담긴 배열 banned_id가 매개변수로 주어질 때, 당첨에서 제외되어야 할 제재 아이디 목록은 몇가지 경우의 수가 가능한 지 return 하도록 solution 함수를 완성해주세요.
 */

public class codingTest136 {
    static Set<Set<String>> result = new HashSet<>();
    static boolean[] visited;

    public static void main(String[] args) {
        // user_id, banned_id 입력받음
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        // 한 패턴에 하나의 아이디만 매칭 가능 -> 총 경우의 수 찾아야 함
        dfs(0, user_id, banned_id, new HashSet<>());
        return result.size();
    }
    
    public static void dfs(int depth, String[] user_id, String[] banned_id, Set<String> selected){
        if(depth == banned_id.length){
            result.add(new HashSet<>(selected));
            return;
        }
            
        String pattern = banned_id[depth].replace("*", ".");
        
        for(int i=0; i<user_id.length; i++){
            if(!visited[i] && user_id[i].matches(pattern)){
                visited[i] = true;
                selected.add(user_id[i]);
                dfs(depth+1, user_id, banned_id, selected);
                selected.remove(user_id[i]);
                visited[i] = false;
            }
        }
    }
}
