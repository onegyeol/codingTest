package section3;

import java.util.*;

public class Test2 {
    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b){
        ArrayList<Integer> answer = new ArrayList<>();
        int p1=0, p2=0;
        Arrays.sort(a); Arrays.sort(b);

        while(p1<n && p2<m){
            if(a[p1] == b[p2]) {
                answer.add(a[p1]); 
                p1++; p2++;
            }
            else if(a[p1] > b[p2]) p2++;
            else if(a[p1] < b[p2]) p1++;
        }

        return answer;
    }
    public static void main(String[] args) {
        Test2 t = new Test2();
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
