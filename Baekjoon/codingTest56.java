package Baekjoon;

import java.util.*;
import java.io.*;

/*
 * 백준 11725번 트리의 부모 찾기

 * 문제
루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.

 * 입력
첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.

 * 출력
첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
 * 
 */

public class codingTest56 {
    static int n;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        parent = new int[n+1]; // 바로 상위 노드 저장
        arr = new ArrayList[n+1]; // 그래프 연결 (무방향)
        visited = new boolean[n+1]; // 방문 여부 (이미 부모 노드가 정해졌으면 다시 업데이트하지 않음)

        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
        }
        

        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        bfs();

        for(int i=2; i<=n; i++){
            System.out.println(parent[i]);
        }
    }

    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1]=true;

        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int next : arr[tmp]){
                if(visited[next]) continue; //이미 방문했다면 방문하지 않음
                visited[next] = true;
                q.add(next);
                parent[next] = tmp;
            }
        }
    }
}
