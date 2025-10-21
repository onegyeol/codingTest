package progammers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
/*
 * 프로그래머스 Lv.2 배달
 * 
 * 마을의 개수 N, 각 마을을 연결하는 도로의 정보 road, 음식 배달이 가능한 시간 K가 매개변수로 주어질 때, 
 * 음식 주문을 받을 수 있는 마을의 개수를 return 하도록 solution 함수를 완성해주세요.
 */
public class codingTest118 {
    static class Node implements Comparable<Node>{
        int to, weight;

        Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
        
    }

    public int solution(int N, int[][] road, int K){
        List<Node>[] graph = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] r : road){
            int a = r[0];
            int b = r[1];
            int w = r[2];

            graph[a].add(new Node(b, w));
            graph[b].add(new Node(a, w));
        }

        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.weight > dist[cur.to]) continue;

            for(Node next : graph[cur.to]){
                // 거리 갱신 위해
                if(dist[next.to] > dist[cur.to] + next.weight){
                    dist[next.to] = dist[cur.to] + next.weight;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) count++;
        }

        return count;
    }
}
