package section1;


import java.util.ArrayList;
import java.util.Scanner;

public class Test12 {
    public String solution(int n, String s){
        String answer = "";
        
        for(int i=0; i<n; i++){
            String tmp = s.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2);
            answer += (char)num;
            s = s.substring(7);
        }

        
        return answer;
    }
    public static void main(String[] args) {
        Test12 t = new Test12();
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
        String str = in.next();

        System.out.println(t.solution(num, str));
    }
}