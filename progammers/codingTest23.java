package progammers;

import java.util.*;

public class codingTest23 {
    public int solution(int n) {
        int answer = 0;
        String s = Integer.toBinaryString(n);
        int cnt=0;
        
        for(char c : s.toCharArray()){
            if(c == '1') cnt++;
        }
        
        while(true){
            int cnt2=0;
            n++;
            String s2 = Integer.toBinaryString(n);
            for(char c : s2.toCharArray()){
                if(c=='1') cnt2++;
            }
            
            if(cnt == cnt2) {
                answer=n;
                break;
            }
        }

        /**
         * int answer=0;
         * int cnt = Integer.bitCount(n);
         * while(true){
         *      n++
         *      if(Integer.bitCount(n) == cnt){
         *          answer = n; break;
         *      }
         * }
         */
        return answer;
    }

}
