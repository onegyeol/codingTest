package progammers;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 프로그래머스 Lv.2 호텔 대실
 * 
 * 호텔을 운영 중인 코니는 최소한의 객실만을 사용하여 예약 손님들을 받으려고 합니다. 한 번 사용한 객실은 퇴실 시간을 기준으로 10분간 청소를 하고 다음 손님들이 사용할 수 있습니다.
 * 예약 시각이 문자열 형태로 담긴 2차원 배열 book_time이 매개변수로 주어질 때, 코니에게 필요한 최소 객실의 수를 return 하는 solution 함수를 완성해주세요.
 */

public class codingTest122 {
    public static void main(String[] args) {
        // book_time 입력받음
    }

    public int solution(String[][] book_time) {
        
        int[][] time = new int[book_time.length][2];
        
        for (int i = 0; i < book_time.length; i++) {
            time[i][0] = toMinutes(book_time[i][0]); // 입실
            time[i][1] = toMinutes(book_time[i][1]); // 퇴실
        }
        
        // 입실 시간 기준 정렬
        Arrays.sort(time, (a,b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int[] t : time){
            // 입실 가능한지 확인
            if(!q.isEmpty() && q.peek()+10 <= t[0]){
                // 입실 가능하면 방 빼기
                q.poll();
            }
            q.offer(t[1]); // 현재 손님 퇴실 시간 추가
        }
        
        return q.size();
    }
    
    static int toMinutes(String s){
        String[] time = s.split(":");
        
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
}
