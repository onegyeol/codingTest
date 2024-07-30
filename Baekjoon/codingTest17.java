package Baekjoon;

import java.util.*;

/**
 * 백준 25418번
입력으로 양의 정수 A와 K가 주어지면, 아래 연산을 이용하여 A를 K로 변경하려고 한다. 정수 A를 변경할 때 사용할 수 있는 연산 종류는 다음과 같다.

- 연산 1: 정수 A에 1을 더한다.
- 연산 2: 정수 A에 2를 곱한다.

정수 A를 정수 K로 만들기 위해 필요한 최소 연산 횟수를 출력하자.

 */

public class codingTest17 {
    static int k, a;

    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[k+1];

        visited[a] = true;
        q.offer(new int[]{a, 0});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(curr[0] == k){
                System.out.println(curr[1]);
                return;
            }
            if(curr[0]*2 <= k){ // 연산 2
                visited[curr[0]*2] = true; //연산2 수행시에만 방문 체크함
                q.offer(new int[]{curr[0]*2, curr[1]+1});
            }
            if(!visited[curr[0]+1]){ // 연산 1
                q.offer(new int[]{curr[0]+1, curr[1]+1});
            }
        }


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        a = in.nextInt();
        k = in.nextInt();

        bfs();


    }

}
