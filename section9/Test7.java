package section9;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 코테 강의 9-7. 원더랜드(최소스패닝트리)
 * 
 * 원더랜드에 문제가 생겼다. 원더랜드의 각 도로를 유지보수하는 재정이 바닥난 것이다.

원더랜드는 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지 도로는 폐쇄하려고 한다.

첫째 줄에 도시의 개수 V(1≤V≤100)와 도로의 개수 E(1≤E≤1,000)가 주어진다.

다음 E개의 줄에는 각 도로에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다.

이는 A번 도시와 B번 도시가 유지비용이 C인 도로로 연결되어 있다는 의미이다.
 */


 // PriorityQueue 방법
class Edge implements Comparable<Edge>{
    public int v, cost;

    Edge(int v, int cost){
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Test7 {
    static int[] unf;
    public static void main(String[] args) {
        Test7 t = new Test7();
        Scanner in = new Scanner(System.in);

        int v = in.nextInt();
        int e = in.nextInt();
        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
        for(int i=0; i<=v; i++) graph.add(new ArrayList<Edge>());

        int[] ch = new int[v+1];
        for(int i=0; i<e; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt()
            graph.get(a).add(new Edge(b, c)); //무방향 그래프이기에 양쪽 모두 다 넣어 줌
            graph.get(b).add(new Edge(a, c));
        }
        int answer=0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0)); //임의의 한 점에서 출력
        while(!pq.isEmpty()){
            Edge tmp = pq.poll();
            int ev = tmp.v;
            if(ch[ev] == 0){ //방문한 도시가 아니라면
                ch[ev] = 1; //방문했다고 표시
                answer += tmp.cost; //비용을 더해줌
                for(Edge ob : graph.get(ev)){ //해당 도시에서 또 다른 도시로 이어지는 도로 찾음
                    if(ch[ob.v] == 0) pq.offer(new Edge(ob.v, ob.cost));
                }
            }
        }
        System.out.println(answer);
        
    }
    
}

/**
 * Union & Find 방법
 * 
 * class Edge implements Comparable<Edge>{
 public int v1, v2, cost;
    Edge(int v1, int v2, int cost){
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
    


}

public class Test7 {
    static int[] unf;
        

    public static int Find(int v){
        if(v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    public static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb)unf[fa] = fb;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int v = in.nextInt();
        int e = in.nextInt();
        unf = new int[v+1];
        ArrayList<Edge> arr = new ArrayList<>();

        for(int i=1; i<=v; i++) unf[i] = i;
        for(int i=0; i<e; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            arr.add(new Edge(a, b, c));
        }

        int answer = 0;
        Collections.sort(arr);
        for(Edge ob : arr){
            int fv1 = Find(ob.v1);      
            int fv2 = Find(ob.v2);
            if(fv1 != fv2){ //사이클이 형성되지 않을 때
                answer += ob.cost;
                Union(ob.v1, ob.v2);
            }      
        }

        System.out.println(answer);

    }
    
    
}

 */