package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 1697번 숨바꼭질
 * 
 * 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
 * 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
 * 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
 */

public class codingTest54 {
    static int n, m;
    static int[] check = new int [100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if(m == n) System.out.println(0);
        else bfs(n);

        
    }

    static void bfs(int num){
        Queue<Integer> q = new LinkedList<>();
        q.offer(num);
        check[num] = 1;
        
        while(!q.isEmpty()){
            int k = q.poll();

            for(int i=0; i<3; i++){
                int next;
                if(i == 0) next = k+1;
                else if(i == 1) next = k-1;
                else next = k*2;

                if(next == m) {
                    System.out.println(check[k]);
                    return;
                }

                if(next<0 || next>100000) continue;
                if(check[next] != 0) continue;

                q.offer(next);
                check[next] = check[k]+1;
            }
        }
    }
    
}
