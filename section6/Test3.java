package section6;

import java.util.*;

public class Test3 {
    public int[] solution(int n, int[] a){
        int least;

        for(int i=0; i<n-1; i++){
            least = i;
            for(int j=i+1; j<n; j++)
                if(a[least] > a[j]) least = j;
            int tmp = a[i];
            a[i] = a[least];
            a[least] = tmp;
        }

        return a;
    }
    public static void main(String[] args) {
        Test3 t = new Test3();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = in.nextInt();

        for(int i : t.solution(n, arr))
            System.out.print(i + " ");
    }
}
