package section2;

import java.util.Scanner;

public class Test4 {
    public int[] solution(int n){
        int[] answer = new int[n];

        answer[0] = 1;
        answer[1] = 1;

        for(int i =2; i<n; i++){
            answer[i] = answer[i-1] + answer[i-2];
        }


        return answer;
    }
    public static void main(String[] args) {
        Test4 t = new Test4();
        Scanner in = new Scanner(System.in);

        int k = in.nextInt();

        for(int i : t.solution(k)) System.out.print(i + " ");

    }
    
}
