package section1;

import java.util.Scanner;

public class Test5 {
    public String solution(String str){
        String answer = "";
        char[] s = str.toCharArray();
        int lt = 0;
        int rt = str.length()-1;

        while(lt < rt){
            if(!Character.isAlphabetic(s[lt])) lt++;
            else if(!Character.isAlphabetic(s[rt])) rt--;
            else{
                char temp = s[lt];
                s[lt] = s[rt];
                s[rt] = temp;
                lt++;
                rt--;
            }
        }
        
        answer = String.valueOf(s); //s를 string으로 바꿔줌.

        return answer;
    }

    public static void main(String[] args) {
        Test5 t = new Test5();
        Scanner in = new Scanner(System.in);

        String s = in.next();

        System.out.println(t.solution(s));
    }
    
}
