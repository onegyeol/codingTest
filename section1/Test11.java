package section1;

import java.util.Scanner;

public class Test11 {
    public String solution(String s){
        String answer = "";
        char[] arr = s.toCharArray();
        int cnt = 1;


        for(int i=0; i<s.length()-1; i++){
            if(arr[i] == arr[i+1]){
                cnt++;
            }
            else{
                answer += Character.toString(arr[i]);
                if(cnt > 1) {
                    answer += Integer.toString(cnt);
                    cnt = 1;
                }   
            }
        }  

        return answer;
    }
    public static void main(String[] args) {
        Test11 t = new Test11();
        Scanner in = new Scanner(System.in);

        String str = in.next();
        str += " ";

        System.out.println(t.solution(str));
    }
}
