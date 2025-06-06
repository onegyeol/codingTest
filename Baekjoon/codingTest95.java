package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * 백준 1351번 무한 수열
 * 
 * 무한 수열 A는 다음과 같다.
 * A0 = 1
 * Ai = A⌊i/P⌋ + A⌊i/Q⌋ (i ≥ 1)
 * N, P와 Q가 주어질 때, AN을 구하는 프로그램을 작성하시오.
 * 
 * int 타입으로는 0 ≤ N ≤ 10^12, 2 ≤ P, Q ≤ 10^9 범위 커버 불가
 * 
 */

public class codingTest95 {
    static long P, Q;
    static Map<Long, Long> map = new HashMap<>();

    public static long solution(long n){
        if(n==0) return 1;

        if(map.containsKey(n)) return map.get(n);

        long result = solution(n/P) + solution(n/Q); // DFS
        map.put(n, result);

        return result;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        System.out.println(solution(N));
        
    }
}
