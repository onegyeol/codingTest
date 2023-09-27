package section2;

import java.util.Scanner;

public class Test2 {
    public int solution(int[] a){
        int result = 0;
        int max_h = 0;

        for(int i=0; i<a.length; i++){
            if(max_h < a[i]){
                max_h = a[i];
                result++;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        Test2 t = new Test2();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] student = new int[n];

        for(int i=0; i<n; i++){
            int tmp = in.nextInt();
            student[i] = tmp;
        }

        System.out.println(t.solution(student));
    }
}
