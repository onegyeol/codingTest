package section3;

import java.util.*;

public class Test1 {
    public int[] solution(int n, int m, int[] a, int[] b){
        int[] answer = new int[a.length + b.length];

        System.arraycopy(a, 0, answer, 0, a.length);   
        System.arraycopy(b, 0, answer, a.length, b.length);
        Arrays.sort(answer);        

        return answer;
    }
    public static void main(String[] args) {
        Test1 t = new Test1();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr1 = new int[n];

        for(int i=0; i<n; i++){
            arr1[i] = in.nextInt();
        }

        int m = in.nextInt();
        int[] arr2 = new int[m];
        
        for(int i=0; i<m; i++){
            arr2[i] = in.nextInt();
        }

        for(int i : t.solution(n, m, arr1, arr2)){
            System.out.print(i + " ");
        }
    }
}
