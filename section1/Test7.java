package section1;

import java.util.Scanner;

public class Test7 {
    public String solution(String s){
        StringBuilder builder = new StringBuilder();
        s = s.toLowerCase();

        if(s.equals(builder.append(s).reverse().toString())){
            return "YES";
        }
        else{
            return "NO";
        }
    }

    public static void main(String[] args) {
        Test7 t = new Test7();
        Scanner in = new Scanner(System.in);

        String str = in.next();

        System.out.println(t.solution(str));
    }
}
