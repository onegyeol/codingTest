package section2;

import java.util.Arrays;
import java.util.Scanner;

public class Test8 {
    public int[] solution(int k, int[] a){
        int[] answer = new int[k];

        for(int i=0; i<k; i++){
            int cnt = 1;
            for(int j=0; j<k; j++){
                if(a[i] < a[j]){
                    cnt++;
                }
            }
            answer[i] = cnt;
        }

        return answer;
    }
    public static void main(String[] args) {
        Test8 t = new Test8();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            int tmp = in.nextInt();
            arr[i] = tmp;
        }

        for(int i:t.solution(n, arr)){
            System.out.print(i + " ");
        }
    }
}
