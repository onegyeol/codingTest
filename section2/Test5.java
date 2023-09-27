package section2;

import java.util.Scanner;

public class Test5 {
    public int solution(int n){
        int answer = 0;

        int[] ch = new int[n+1];
        for(int i=2; i<=n; i++){
            if(ch[i] == 0){
                answer++;
                for(int j=i; j<=n; j=j+i){
                    ch[j] = 1;
                }
            }

        }

        return answer;
    }
    public static void main(String[] args) {
        Test5 t = new Test5();
        Scanner in = new Scanner(System.in);

        int k = in.nextInt();

        System.out.println(t.solution(k));
    }
}
