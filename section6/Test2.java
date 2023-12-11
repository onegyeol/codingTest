package section6;

import java.util.*;
//버블정렬 프로그램

public class Test2 {
    public void solution(int n, int[] a){
        for(int i=0; i<n; i++){
            for(int j = i+1; j<n; j++){
                if(a[i] > a[j]){
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }

        for(int k : a) System.out.print(k + " ");
    }
    public static void main(String[] args) {
        Test2 t = new Test2();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }

        t.solution(n, arr);
    }
}
