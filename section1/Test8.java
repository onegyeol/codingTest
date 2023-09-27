package section1;

import java.util.Scanner;

public class Test8 {
    public String solution(String s){
        s = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
        StringBuilder builder = new StringBuilder();
        if(s.equals(builder.append(s).reverse().toString())) return "YES";
        else    return "NO";
    }

    public static void main(String[] args) {
        Test8 t = new Test8();
        Scanner in = new Scanner(System.in);
        
        String str = in.nextLine();

        System.out.println(t.solution(str));

    }
    
}
