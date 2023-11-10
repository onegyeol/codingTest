package section3;

import java.util.*;

public class Test6 {
    public int solution(int n, int k, int[] a){
        int answer=0;

        for(int i=0; i<n; i++){
            int sum = 0, cnt=0;
            for(int j=i; j<n; j++){
                if(a[j] == 0) {
                    if(cnt == k) break;
                    sum += 1;
                    cnt++;
                }
                sum += a[j];
            }
            answer = Math.max(answer, sum);
        }

        return answer;
    }
    public static void main(String[] args) {
        Test6 t = new Test6();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }

        System.out.println(t.solution(n, k, arr));
    }   
}
