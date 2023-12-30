package section6;

import java.util.*;

public class Test4 {
    public int[] solution(int s, int n, int[] works){
        int[] cache = new int[s];

        for(int x : works){
            int pos = -1;
            for(int i=0; i<s; i++) if(x == cache[i]) pos = i; //캐시 배열 안에 일치하는 값이 있으면 pos에 저장
            if(pos == -1){ //cache miss
                for(int i=s-1; i>=1; i--){ //처음부터 끝까지 배열 한칸씩 뒤로 미룸
                    cache[i] = cache[i-1];
                }  
            }
            else{ //cache hit
                for(int i=pos; i>=1; i--){ //0~pos위치 앞까지 한칸씩 뒤로 미룸
                    cache[i] = cache[i-1];
                }
                
            }
            cache[0] = x; //캐시 모든 작업은 항상 제일 앞에서 이루어짐
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
