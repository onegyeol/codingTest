package progammers; //프로그래머스 레벨 2 최소값 만들기

import java.util.Collections;
import java.util.PriorityQueue;

public class 최솟값만들기 {
    public int solution(int []A, int []B)
    {
        int ans = 0;
        
        PriorityQueue<Integer> a = new PriorityQueue<>();
        PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<A.length; i++){
            a.add(A[i]);
            b.add(B[i]);
        }
        
        while(!a.isEmpty()){
            ans += a.poll()*b.poll();
        }
        
        return ans;
    }
}
