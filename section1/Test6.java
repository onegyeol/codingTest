package section1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test6 {
    public String solution(String s){
        return Arrays.asList(s.split("")).stream().distinct().collect(Collectors.joining());
    }
    
    public static void main(String[] args) {
        Test6 t = new Test6();
        Scanner in = new Scanner(System.in);

        String str = in.next();
        System.out.println(t.solution(str));
    }
}
