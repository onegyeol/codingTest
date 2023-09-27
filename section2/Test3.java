package section2;

import java.util.Scanner;


public class Test3{
    public String solution(int[] a, int[] b, int k){
            String answer = "";

            for(int j=0; j<k; j++){
                if(a[j] == b[j]) answer += "D";
                else if(a[j] == 1 && b[j] == 2) answer += "B";
                else if(a[j] == 1 && b[j] == 3) answer += "A";
                else if(a[j] == 2 && b[j] == 1) answer += "A";
                else if(a[j] == 2 && b[j] == 3) answer += "B";
                else if(a[j] == 3 && b[j] == 1) answer += "B";
                else if(a[j] == 3 && b[j] == 2) answer += "A";
            }
            return answer;
    }


    public static void main(String[] args) {
        
        Test3 t = new Test3();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] a_arr = new int[n];
        int[] b_arr = new int[n];

        for(int i=0; i<n; i++){
            int tmp = in.nextInt();
            a_arr[i] = tmp;
        }

        for(int i=0; i<n; i++){
            int tmp = in.nextInt();
            b_arr[i] = tmp;
        }

        for(char c : t.solution(a_arr, b_arr, n).toCharArray()) System.out.println(c);
        
        
    }
}