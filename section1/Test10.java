package section1;

import java.util.Scanner;

public class Test10 {
    public int[] solution(String s, char c){
        int[] answer = new int[s.length()];
        int p = 1000;
        
       for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == c){
                p = 0;
                answer[i] = p;
            }
            else{
                p++;
                answer[i] = p;
            }
       }


        p = 1000;

        for(int i=s.length()-1; i>=0; i--){
                if(s.charAt(i) == c){
                    p = 0;
                }
                else{
                    p++;
                    answer[i] = Math.min(answer[i], p);
                }
                
        }

        return answer;
    }

    public static void main(String[] args) {
        Test10 t = new Test10();
        Scanner in = new Scanner(System.in);

        String str = in.next();
        char alp = in.next().charAt(0);

        for (int x : t.solution(str, alp)) {
            System.out.print(x + " ");
        }
        
    }
}
