package section7;

import java.util.*;

/**
 * 방향 그래프가 주어지면 1번 정점에서 n번 정점으로 가는 모든 경로의 가지수를 출력하는 프로그램 작성.
 * 첫째 줄에는 정점의 수 n와 간선의 수 m 이 주어짐.
 */

public class Test12 {
    static int[][] graph;
    static int[] ch;
    static int answer=0, n, m;

    public void DFS(int k){
        if(k == n) answer++;
        else{
            for(int i=1; i<=n; i++){
                if(graph[k][i] == 1 && ch[i] == 0){
                    ch[i]=1;
                    DFS(i);
                    ch[i]=0; //다시 0으로 바꿔줘야 다른 정점에서 사용 가능
                }
            }
        }
    }
    public static void main(String[] args) {
        Test12 t = new Test12();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        graph = new int[n+1][n+1];
        ch = new int[n+1];

        for(int i=0; i<m; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            graph[a][b] = 1;
        }
        ch[1] = 1;
        t.DFS(1);
        System.out.println(answer);
    }
}
