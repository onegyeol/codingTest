package progammers;

import java.util.Arrays;

public class 숫자의표현 {
    public int solution(int n) {
        int answer = 0, sum=0, lt=0, rt=0;
        int[] a = new int[n];
        Arrays.setAll(a, num-> num+1);
        
        for(rt=0; rt<n; rt++){
            sum+=a[rt];
            if(sum == n) answer++;
            while(sum >= n){
                sum -= a[lt++];
                if(sum == n) answer++;
            }
        }
        return answer;
    }
}
