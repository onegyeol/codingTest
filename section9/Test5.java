package section9;

import java.util.*;

/** 코테 강의 8-5. 다익스트라 알고리즘
 * 
 * 1번 정점에서 모든 정점으로 가는 최소 거리 비용 구하기
 */

class Edge implements Comparable<Edge>{
    int vex, cost;

    public Edge(int vex, int cost){
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }

}

public class Test5 {
    static int[] dis;
    static ArrayList<ArrayList<Edge>> graph;
    static int n, m;

    public void solution(int v){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v, 0)); //시작 정점의 최소 경로는 0임
        dis[v] = 0; //그리고 check
        while(!pq.isEmpty()){
            Edge tmp = pq.poll();
            int now = tmp.vex; //큐에서 나온 정점
            int nowCost = tmp.cost; //그 정점(now)까지 가는데에 비용
            if(nowCost > dis[now]) continue; //nowCost가 크다면 최소 경로 비용 갱신할 필요 없기에 넘김
            for(Edge ob : graph.get(now)){
                if(dis[ob.vex] > nowCost + ob.cost){ //기존 최소 경로가 now정점을 거쳐서 가는 것보다 크다면
                    dis[ob.vex] = nowCost + ob.cost; //최소 거리 비용 갱신
                    pq.offer(new Edge(ob.vex, nowCost + ob.cost)); //갱신한 값을 큐에 넣어줌
                }
            }
        }

    }
    public static void main(String[] args) {
        Test5 t = new Test5();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        graph = new ArrayList<ArrayList<Edge>>();

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Edge>());
        }

        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        
        for(int i=0; i<m; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            graph.get(a).add(new Edge(b, c));
        }
        t.solution(1);
        for(int i=2; i<=n; i++){
            if(dis[i] != Integer.MAX_VALUE) System.out.println(i + " " + dis[i]);
            else System.out.println(i + " : impossible"); //경로가 없다면 impossible 출력
        }
    }
}
