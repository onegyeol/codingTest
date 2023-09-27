package section2;

import java.util.*;

public class Test9 {
    public int solution(int k, int[][] a){
        int result=0;
        int[] sum = new int[(k*k)+2];

        for(int i=0; i<)


        return result;
    }
    public static void main(String[] args) {
        Test9 t = new Test9();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int tmp = in.nextInt();
                arr[i][j] = tmp;
            }
        }

        System.out.println(t.solution(n, arr));

    }
    
}
