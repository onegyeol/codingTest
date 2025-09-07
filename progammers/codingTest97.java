package progammers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 프로그래머스 월간 코드 챌린지 시즌3 금과 은 운반하기
 */

public class codingTest97 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] g = new int[n];
        int[] s = new int[n];
        int[] w = new int[n];
        int[] t = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            g[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            s[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            w[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            t[i] = Integer.parseInt(st.nextToken());
        }

        
       System.out.println(solution(a, b, g, s, w, t));
    
    }

    static long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long lo=0, hi=(long)1e15, answer=hi;
        
        while(lo<=hi){
            long mid = (lo+hi)/2; // 현재 탐색 구간의 중간 시간 (이 시간 안에 운반 가능한지 검사)
            if(transport(mid, a, b, g, s, w, t)){ // 운반 가능하다면 
                answer = mid;
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        return answer;
    }
    
    static boolean transport(long t, int a, int b, int[] g, int[] s, int[] w, int[] time){
        long gold=0, silver=0, total=0;
        
        for(int i=0; i<g.length; i++){
            long moves = t/(2L*time[i]); // 왕복 횟수
            // 남은 시간이 편도 한 번(= time[i]) 이상이면 추가로 한 번 더 운반 가능
            if( (t%(2L*time[i])) >= time[i]) moves++;

            // 해당 도시 트럭이 시간 t 동안 운반할 수 있는 최대 무게
            long maxCarry = moves * w[i];
            
            // 실제 보유량(g[i], s[i])보다 더 많이 옮길 수는 없으므로
            gold += Math.min(g[i], maxCarry); 
            silver += Math.min(s[i], maxCarry);
            total += Math.min(g[i]+s[i], maxCarry);
        }
        
        // 목표량부다 운반량이 크거나 같다면 운반 가능한 것
        return gold>=a && silver>=b && total>=(a+b);
    }

}
