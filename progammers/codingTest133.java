package progammers;

import java.util.Arrays;

/*
 * 프로그래머스 Lv.3 입국심사
 * 
 * 처음에 모든 심사대는 비어있습니다. 
 * 한 심사대에서는 동시에 한 명만 심사를 할 수 있습니다. 가장 앞에 서 있는 사람은 비어 있는 심사대로 가서 심사를 받을 수 있습니다. 
 * 하지만 더 빨리 끝나는 심사대가 있으면 기다렸다가 그곳으로 가서 심사를 받을 수도 있습니다.
 * 모든 사람이 심사를 받는데 걸리는 시간을 최소로 하고 싶습니다.
 * 입국심사를 기다리는 사람 수 n, 각 심사관이 한 명을 심사하는데 걸리는 시간이 담긴 배열 times가 매개변수로 주어질 때, 
 * 모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 return 하도록 solution 함수를 작성해주세요.
 */

public class codingTest133 {
    public static void main(String[] args) {
        // n, times 입력받음
    }

    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        // 이분탐색
        long left=1;
        // 가장 오래걸리는 시간
        long right=(long) times[times.length-1]*n;
        long answer=right;
        
        while(left <= right){
            long sum=0;
            long mid = (left+right)/2;
            
            // 각 심사관이 mid 시간동안 처리할 수 있는 인원 계산
            for(int time : times){
                sum += mid/time;
                if(sum>=n) break;
            }
            
            if(sum>=n){
                answer = mid;
                right = mid-1;
            } else{
                left = mid+1;
            }
        }
        
        
        return answer;
    }
}
