package section2;

import java.util.*;

public class Test9 {
    public int solution(int k, int[][] a){
        int result=Integer.MIN_VALUE;
        int sum1, sum2;

        for(int i=0; i<k; i++){
            sum1 = sum2 = 0;
            for(int j=0; j<k; j++){
                sum1 += a[i][j];
                sum2 += a[j][i];
            }
            result = Math.max(result, sum1);
            result = Math.max(result, sum2);
        }

        sum1 = sum2 = 0;
        for(int i=0; i<k; i++){
            sum1 += a[i][i];
            sum2 += a[i][k-i-1];
        }

        result = Math.max(result, sum1);
        result = Math.max(result, sum2);

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
