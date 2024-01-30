package section7;

import java.util.*;

/**
 * 1번 정점에서 각 정점으로 가는 최소 이동 간선 수 출력
 * 첫째줄에 정점의 수 n과 간선의 수 m이 주어짐
 */

public class Test14 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    static int[] dis;

    public void BFS(int v){
        Queue<Integer> q = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;
        q.offer(v);
        
        while (!q.isEmpty()) {
            int k = q.poll();
            for(int nv : graph.get(k)){
                if(ch[nv] == 0){
                    ch[nv] = 1;
                    q.offer(nv);
                    dis[nv] = dis[k]+1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Test14 t = new Test14();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        graph = new ArrayList<ArrayList<Integer>>();
        ch= new int[n+1];
        dis = new int[n+1];

        for(int i=0; i<=n; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            graph.get(a).add(b);
        }

        ch[1] = 1;
        t.BFS(1);
        for(int i=2; i<=n; i++){
            System.out.println(i + " : " + dis[i]);
        }
    }
}
