package progammers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
프로그래머스 Lv.3 여행 경로

주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.
항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
*/

public class codingTest138 {
    static List<String> answer;
    static List<String> answerList;
    static int ticketCount;
    static boolean[] visited;

    public static void main(String[] args) {
        // tickets 입력받음
    }

    public String[] solution(String[][] tickets) {
        ticketCount = tickets.length;
        visited = new boolean[ticketCount];
        answer = new ArrayList<>();
        answerList = new ArrayList<>();
        
        // 티켓을 도착지 기준으로 알파벳 순 정렬 (우선순위 높은 경로 먼저 탐색)
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        answer.add("ICN");
        dfs("ICN", tickets);

        return answerList.toArray(new String[0]);
    }
    
    public void dfs(String current, String[][] tickets) {
        if (answer.size() == ticketCount + 1) { // 모든 티켓 사용 완료
            answerList = new ArrayList<>(answer);
            return;
        }
        
        for(int i=0; i<ticketCount; i++){
            if(!visited[i] && tickets[i][0].equals(current)){
                visited[i] = true;
                answer.add(tickets[i][1]);
                
                dfs(tickets[i][1], tickets);
                
                if(!answerList.isEmpty()) return;
                
                visited[i] = false;
                answer.remove(answer.size()-1);
            }
        }
    }
}
