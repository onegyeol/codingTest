package section3;

import java.util.*;

public class Test6 {
    public int solution(int n, int k, int[] a){
        int answer=0;

        return answer;
    }
    public static void main(String[] args) {
        Test6 t = new Test6();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<k; i++){
            arr[i] = in.nextInt();
        }

        System.out.println(t.solution(n, k, arr));
    }   
}
