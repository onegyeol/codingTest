package section6;

import java.util.*;

public class Test6 {
    public ArrayList<Integer> solution(int n, int[] a){
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = a.clone();
        Arrays.sort(tmp);

        for(int i=0; i<n; i++){
            if(tmp[i] != a[i]){
                answer.add(i+1);
            }
        }

        return answer;        
    }
    public static void main(String[] args) {
        Test6 t = new Test6();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = in.nextInt();

        for(int k : t.solution(n, arr)){
            System.out.print(k + " ");
        }   
    }
}
