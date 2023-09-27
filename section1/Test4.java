package section1;

import java.util.Scanner;

public class Test4 {
    public void solution(String[] s, int n){

        for(int i=0; i<n; i++){
            StringBuilder st = new StringBuilder();
            s[i] = st.append(s[i]).reverse().toString();
            
        }

        for(String str : s){
            System.out.println(str);
        }

    }

    public static void main(String[] args) {
        Test4 t = new Test4();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String[] str = new String[num];

        for(int i=0; i<num; i++){
            String s = in.next();
            str[i] = s;
        }

       t.solution(str, num);
       


    }
}
