package section4;

import java.util.*;

public class Test5 {
    public int solution(int n, int k, int[] a){
        int answer=-1;
        TreeSet<Integer> tree = new TreeSet<>(Collections.reverseOrder());

        for(int lt=0; lt<n-2; lt++){
            for(int i=lt+1; i<n-1; i++){
                for(int j=i+1; j<n; j++){
                    tree.add(a[lt]+a[i]+a[j]);
                }
            }
        }

        int cnt = 1;
        for(int i : tree){
            if(cnt == k){
                answer = i;
                break;
            }
            cnt++;
        }

        return answer;
    }
    public static void main(String[] args) {
        Test5 t = new Test5();
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
