package Baekjoon;

import java.io.*;
import java.util.*;

/*
 * 백준 1717번 집합의 표현
 * 
 * 첫째 줄에 n, m이 주어진다. m은 입력으로 주어지는 연산의 개수이다. 
 * 다음 m개의 줄에는 각각의 연산이 주어진다. 합집합은 0 a b의 형태로 입력이 주어진다. 
 * 이는 a가 포함되어 있는 집합과, b가 포함되어 있는 집합을 합친다는 의미이다. 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은 1 a b의 형태로 입력이 주어진다. 
 * 이는 a와 b가 같은 집합에 포함되어 있는지를 확인하는 연산이다
 * 1로 시작하는 입력에 대해서 a와 $가 같은 집합에 포함되어 있으면 "YES" 또는 "yes"를, 그렇지 않다면 "NO" 또는 "no"를 한 줄에 하나씩 출력한다
 */

public class codingTest61 {
    static int n, m;
    static int[] parent;

    public static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]); // 루트노드 찾아감
        }

        return parent[x];
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b) parent[b] = a; // 합침
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];

        for(int i=0; i<=n; i++){
            parent[i] = i;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(k == 0){ // 합집합
                union(a, b);
            }
            else{
                if(find(a) == find(b)){
                    sb.append("YES\n");
                }
                else sb.append("NO\n");
            }
        }

        System.out.println(sb);
    }
}
