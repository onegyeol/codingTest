package progammers;

import java.util.*;

public class codingTest30 {
    
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    static int answer = 0, maxDepth = 0;

    public int solution(int n, int[][] edge) {
        graph = new ArrayList<ArrayList<Integer>>();
        ch = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        ch[1] = 1;
        BFS(1);

        return answer;
    }

    public void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        q.offer(0);

        while (!q.isEmpty()) {
            int k = q.poll();
            int dis = q.poll(); //처음 dis값은 0임

            for (int nv : graph.get(k)) {
                if (ch[nv] == 0) { //방문하지 않은 노드라면
                    ch[nv] = 1;
                    q.offer(nv);
                    q.offer(dis + 1); //dis 증가
                    
                    if (maxDepth < dis + 1) { //우리가 큐에 넣은 증가된 값 기준으로 maxDepth랑 비교해야함
                        maxDepth = dis + 1;
                        answer = 1; // 새로운 최대 깊이에 도달한 경우에는 answer를 1로 초기화
                    } else if (maxDepth == dis + 1)  answer++; // 최대 깊이와 일치하는 경우에만 answer를 증가
                }
            }
        }
    }
}


