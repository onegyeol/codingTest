package section6;

import java.util.*;

public class Test4 {
    public int[] solution(int s, int n, int[] works){
        int[] cache = new int[s];

        for(int x : works){
            int pos = -1;
            for(int i=0; i<s; i++) if(x == cache[i]) pos = i;
            if(pos == -1){
                for(int i=s-1; i>=1; i--){
                    cache[i] = cache[i-1];
                }  
            }
            else{
                for(int i=pos; i>=1; i--){
                    cache[i] = cache[i-1];
                }
                
            }
            cache[0] = x;
        }

        return cache;
    }
    public static void main(String[] args) {
        Test4 t = new Test4();
        Scanner in = new Scanner(System.in);

        int s = in.nextInt();
        int n = in.nextInt();
        int[] works = new int[n];

        for(int i=0; i<n; i++){
            works[i] = in.nextInt();
        }

        for(int k : t.solution(s, n, works)){
            System.out.print(k + " ");
        }
    }
}
