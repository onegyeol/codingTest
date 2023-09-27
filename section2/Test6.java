package section2;

import java.util.Scanner;
import java.util.ArrayList;

public class Test6 {
    public boolean isPrime(int num){
        if(num == 1) return false;
        for(int j=2; j<num; j++){ //1과 자기자신 빼고 나눠지는게 있으면 소수 아님
            if(num % j == 0) return false;
        }
        return true;

    }
    public ArrayList<Integer> solution(int n, int[] a){
        ArrayList<Integer> result = new ArrayList<>();
        int tmp = 0;
        int cnt = 0;

        for(int i=0; i<n; i++){
            cnt = 0;
            tmp = 0;
            while(a[i] != 0){
                tmp = tmp * 10 + a[i] % 10;
                a[i] /= 10;
            }

            if(isPrime(tmp)) result.add(tmp);
    
            
        }

        return result;
    }
    public static void main(String[] args) {
        Test6 t = new Test6();
        Scanner in = new Scanner(System.in);

        int k = in.nextInt();
        int[] arr = new int[k];

        for(int i=0; i<k; i++){
            int tmp = in.nextInt();
            arr[i] = tmp;
        }

        for(int s : t.solution(k, arr)){
            System.out.print(s + " ");
        }
        
    }
    
}
