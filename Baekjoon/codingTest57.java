package Baekjoon;

import java.io.*;
import java.util.*;

/*
 * 백준 2644번 촌수계산
 * 
 * 우리 나라는 가족 혹은 친척들 사이의 관계를 촌수라는 단위로 표현하는 독특한 문화를 가지고 있다. 
 * 이러한 촌수는 다음과 같은 방식으로 계산된다. 기본적으로 부모와 자식 사이를 1촌으로 정의하고 이로부터 사람들 간의 촌수를 계산한다. 
 * 예를 들면 나와 아버지, 아버지와 할아버지는 각각 1촌으로 나와 할아버지는 2촌이 되고, 아버지 형제들과 할아버지는 1촌, 나와 아버지 형제들과는 3촌이 된다.
 * 여러 사람들에 대한 부모 자식들 간의 관계가 주어졌을 때, 주어진 두 사람의 촌수를 계산하는 프로그램을 작성하시오.
 */

public class codingTest57 {
    static int n, m, a, b;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int ans = -1;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken()); // 촌수를 계산해야 하는 서로 다른 두 사람의 번호
        b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }

        System.out.println(bfs(a, b));

    }

    static int bfs(int start, int target){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0}); // 노드와, 촌수
        visited[start] = true;

        while(!q.isEmpty()){
            int[] current = q.poll();
            int node = current[0];
            int cnt = current[1]; // 촌수

            if(node == target){ // 도달한 노드와 TARGET이 동일하면 RETURN
                return cnt;
            }

            for(int next : arr[node]){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new int[]{next, cnt+1});
                }
            }
        }

        return -1; // 촌수가 없을 때
    }

}
