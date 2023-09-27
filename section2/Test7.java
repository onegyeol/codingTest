package section2;

import java.util.*;

public class Test7 {
    public int solution(int k, int[] a){
        int[] result = new int[k];

        for(int i=0; i<k; i++){
            if(a[i] == 0) result[i] = 0;
            else{
                if(i == 0 || result[i-1] == 0) result[i] = 1;
                else if(a[i-1] == 1) result[i] =  result[i-1] + 1;
            }
        }

        return Arrays.stream(result).sum();
    }
    public static void main(String[] args) {
        Test7 t = new Test7();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            int tmp = in.nextInt();
            arr[i] = tmp;
        }

        System.out.println(t.solution(n, arr));
    }
    
}
