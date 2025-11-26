package progammers;

import java.util.HashMap;

/*
 * 프로그래머스 Lv.1 달리기 경주
 * 
 * 선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 players와 해설진이 부른 이름을 담은 문자열 배열 callings가 매개변수로 주어질 때, 
 * 경주가 끝났을 때 선수들의 이름을 1등부터 등수 순서대로 배열에 담아 return 하는 solution 함수를 완성해주세요.
 * - 경주 진행중 1등인 선수의 이름은 불리지 않습니다.
 */

public class codingTest126 {
    public static void main(String[] args) {
        // players, callings 입력 받ㅇㅁ
    }

    public String[] solution(String[] players, String[] callings) {
        String[] answer = players;

        // HashMap을 사용하게 되면, 자료 추가 + 탐색 속도가 일반 리스트보다 빠르기에 시간 초과 발생 안함
        HashMap<String, Integer> map = new HashMap<>();
        
        // map에 순위와 이름 넣음
        for(int i=0; i<players.length; i++){
            map.put(players[i], i);
        }

        for(int i=0; i<callings.length; i++){
            int rank = map.get(callings[i]);
            
            String name = answer[rank-1];
            answer[rank-1] = answer[rank];
            answer[rank] = name;
            
            map.put(answer[rank-1], rank-1);
            map.put(answer[rank], rank);
        }
        return answer;
    }
}

