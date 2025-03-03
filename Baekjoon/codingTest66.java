package Baekjoon;

import java.util.*;
import java.io.*;

/*
 * 백준 1976번 여행 가자
 * 
 * 첫 줄에 도시의 수 N이 주어진다. N은 200이하이다. 둘째 줄에 여행 계획에 속한 도시들의 수 M이 주어진다. M은 1000이하이다. 
 * 다음 N개의 줄에는 N개의 정수가 주어진다. i번째 줄의 j번째 수는 i번 도시와 j번 도시의 연결 정보를 의미한다. 
 * 1이면 연결된 것이고 0이면 연결이 되지 않은 것이다. A와 B가 연결되었으면 B와 A도 연결되어 있다. 마지막 줄에는 여행 계획이 주어진다. 도시의 번호는 1부터 N까지 차례대로 매겨져 있다.
 * 첫 줄에 가능하면 YES 불가능하면 NO를 출력한다.
 */

public class codingTest66 {
    static int n, m;
    static int[] parent, trip;

    // 연결된 루트 노드와 연결
    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x!=y) parent[y]=x;
    }

    static int find(int x){
        if(parent[x] == x) return x;
        else return find(parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        parent = new int[n+1];
        trip = new int[m];

        // 초기 세팅
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        // 도시 연결 정보
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 1){
                    union(i+1, j+1);
                }
            }
        }

        // 여행 계획
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            trip[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag = true;
        int root = find(trip[0]);

        for(int i=1; i<m; i++){
            if(find(trip[i]) != root) {
                flag=false;
                break;
            }
        }

        System.out.println(flag ? "YES" : "NO");
        
    }

}
