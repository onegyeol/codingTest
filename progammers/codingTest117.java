package progammers;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 프로그래머스 Lv.2 서버 증설 횟수
 * 
 * 0시에서 23시까지의 시간대별 게임 이용자의 수를 나타내는 1차원 정수 배열 players, 
 * 서버 한 대로 감당할 수 있는 최대 이용자의 수를 나타내는 정수 m, 서버 한 대가 운영 가능한 시간을 나타내는 정수 k가 주어집니다. 
 * 이때, 모든 게임 이용자를 감당하기 위한 최소 서버 증설 횟수를 return 하도록 solution을 완성해 주세요.
 */

public class codingTest117 {
    public static void main(String[] args) {
        // players, m, k 입력 받음
    }

    public int solution(int[] players, int m, int k) {
        int answer = 0, server = 0;
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < players.length; i++) {
            int current = players[i] / m;

            while (!q.isEmpty() && i - q.peek() >= k) {
                q.poll();
                server--;
            }
            
            // 필요한 서버가 현재보다 많다면 새로 추가
            if (current > server) {
                int need = current - server; // 추가로 필요한 서버 수
                answer += need;
                server += need;
                for (int j = 0; j < need; j++) {
                    q.add(i); // i초에 추가된 서버 기록
                }
            }
        }
        return answer;
    }
}
