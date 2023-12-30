package progammers;

import java.util.Scanner;
import java.util.Arrays;

public class codingTest22 {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while (s.length() > 1) {
            int cnt = 0;
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) ==  '0') answer[1]++;
                else cnt++;
            }

            s = Integer.toBinaryString(cnt);
            answer[0]++;
        }

        return answer;
    }

    public static void main(String[] args) {
        codingTest22 t = new codingTest22();
        Scanner in = new Scanner(System.in);

        String s = in.next();

        System.out.println(Arrays.toString(t.solution(s)));
    }
}

/**
 * 다른사람 풀이
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int temp;
        while( !s.equals("1") ) {
            answer[1] += s.length();
            s = s.replaceAll("0", "");
            temp = s.length();
            s = Integer.toBinaryString(temp);
            //System.out.println("s : " + s ); 
            answer[0]++;
            answer[1] -= temp;
        }
        return answer;  
    }
}
 */
