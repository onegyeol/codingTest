package Baekjoon;

import java.io.*;
import java.util.*;

/*
 * 백준 16953번 A -> B
 * 
 * 정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.
 * 2를 곱한다.
 * 1을 수의 가장 오른쪽에 추가한다. 
 * A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.
 * 
 */

public class codingTest60 {
    static long a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        System.out.println(bfs());
    }

    /*
     * 입력이 2 162일때
     * 
     * q의 상태
     * 초기 큐: [2], 연산 횟수: 0
     * 1단계: [4, 21], 연산 횟수: 1
     * 2단계: [8, 42], 연산 횟수: 2
     * 3단계: [16, 85], 연산 횟수: 3
     * 4단계: [32, 170], 연산 횟수: 4
     * 5단계: [162], 연산 횟수: 5
     */
    static int bfs(){
        Queue<Long> q = new LinkedList<>();
        q.offer(a);
        int cnt=0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                long tmp = q.poll();
                if(tmp == b) return cnt+1;

                if(tmp*2 <= b) q.add(tmp*2);
                if(tmp*10+1 <= b) q.add(tmp*10+1);
            }
            
            cnt++;
        }
        return -1;
    }   
}
