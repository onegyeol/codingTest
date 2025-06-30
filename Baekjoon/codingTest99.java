package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//백준 1375번 나이

public class codingTest99 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    static Map<String, Integer> comp = new HashMap<>();
    static List<List<Integer>> edges = new ArrayList<>();
    static int idCount = 0;

    public static void main(String[] args) throws Exception {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken());

        // 간선 정보 등록
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            int u = getId(a);
            int v = getId(b);
            edges.get(u).add(v); // 경로 등록
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 쿼리 처리
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            // 경로가 없으면 -1 삽입
            int u = comp.getOrDefault(a, -1);
            int v = comp.getOrDefault(b, -1);

            if (u == -1 || v == -1) {
                sb.append("gg ");
                continue;
            }

            if (reachable(u, v)) sb.append(a).append(" ");
            else if (reachable(v, u)) sb.append(b).append(" ");
            else sb.append("gg ");
        }
        System.out.println(sb);
    }

    // 이름을 ID로 변환하고, 처음 보는 이름이면 리스트도 확장
    static int getId(String name) {
        if (!comp.containsKey(name)) {
            comp.put(name, idCount++);
            edges.add(new ArrayList<>());
        }
        return comp.get(name);
    }

    // BFS로 a → b 도달 가능한지 확인
    static boolean reachable(int a, int b) {
        boolean[] visited = new boolean[idCount];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(a);
        visited[a] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : edges.get(cur)) {
                if (next == b) return true;
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        return false;
    }
}
