package section6;

import java.util.*;

public class Test5 {
    public char solution(int n, int[] a){

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(a[i] == a[j]) {
                    return 'D';
                }
            }
        }
         
        return 'U';
    }
    public static void main(String[] args) {
        Test5 t = new Test5();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i]=in.nextInt();
        }

        /**
         * 향상된 for문으로 적으면 값을 수정할 수 없기에
         * 인덱스 번호로 접근해서 값을 입력받아야함
         */

        System.out.println(t.solution(n, arr));
    }
}
