package Baekjoon;

import java.util.*;
import java.io.*;

/**
 * 백준 2606번 바이러스
 * 
 * 신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다. 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.
 * 첫째 줄에는 컴퓨터의 수가 주어진다. 컴퓨터의 수는 100 이하인 양의 정수이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다. 
 * 둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다. 이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.
 * 1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.
 * 
 */

public class codingTest52 {
    static int[] parent;

    // Union 함수
    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return false;

        if (x < y) parent[y] = x;
        else parent[x] = y;

        return true;
    }

    // Find 함수 (경로 압축)
    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]); // 값 갱신
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int m = Integer.parseInt(br.readLine()); // 연결된 쌍의 수
        parent = new int[n + 1];

        // 초기화: 자기 자신을 부모로 설정
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // 네트워크 연결 정보 입력
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        // 1번 컴퓨터와 같은 그룹에 속한 컴퓨터 수 계산
        int rootOfOne = find(1); // 1번 컴퓨터의 루트
        int count = 0;
        for (int i = 2; i <= n; i++) { // 1번 제외
            if (find(i) == rootOfOne) {
                count++;
            }
        }

        System.out.println(count);
    }
}
