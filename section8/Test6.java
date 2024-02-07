package section8;


/**
 * 코테 강의 8-6 순열구하기
 * 
 * 100이하의 n개의 자연수가 주어지면 이 중 m개를 뽑아 나열 방법 출력
 * 이때 자연수는 오름차순으로 제공됨.
 * 
 */

import java.util.*;

public class Test6 {
    static int m, n;
    static int[] pm, ch, arr;
    public void DFS(int cnt, int[] arr){
        if(cnt == m){
            for(int i:pm) System.out.print(i + " ");
            System.out.println();
        }
        else{
            for(int i=0; i<n; i++){
                if(ch[i] == 0){
                    ch[i] = 1;
                    pm[cnt] = arr[i];
                    DFS(cnt+1, arr);
                    ch[i] = 0;
                }
                
            }
        }
    }

    public static void main(String[] args) {
        Test6 t = new Test6();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        pm = new int[m];
        ch = new int[n];
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }

        t.DFS(0, arr);
    }
}
