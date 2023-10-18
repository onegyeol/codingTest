package section3;

import java.util.*;

public class Test5 {
    public int solution(int n){
        int answer=0, rt, lt=0, sum=0;
        int[] a = new int[n-1];
        Arrays.setAll(a, num -> 1+num);

        for(rt=0; rt<a.length; rt++){
            sum += a[rt];
            if(sum == n) answer++;
            while(sum >= n){
                sum -= a[lt++];
                if(sum == n) answer++;
            
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Test5 t = new Test5();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        
        System.out.println(t.solution(n));
    }
}
