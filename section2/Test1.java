package section2;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Test1 {
    public ArrayList<Integer> solution(int[] a){
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(a[0]);
        
        for(int i=1; i<a.length; i++){
            if(a[i] > a[i-1]){
                answer.add(a[i]);
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Test1 t = new Test1();
        Scanner in = new Scanner(System.in);
        

        int x = in.nextInt();

        int[] arr = new int[x];
        for(int i=0; i<x; i++){
            int tmp = in.nextInt();
            arr[i] = tmp;
        }

        for(int s : t.solution(arr)){
            System.out.print(s + " ");
        }
    }
}
