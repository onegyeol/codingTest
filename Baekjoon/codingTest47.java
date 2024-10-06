package Baekjoon;

import java.util.*;
import java.io.*;

/** 백준 2178번 미로탐색
 * 
 * N×M크기의 배열로 표현되는 미로가 있다.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1
미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 
이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 
한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
 */

public class codingTest47 {
    static int n, m;
    static int[] dx = {1, 0, -1, 0}; // 상하좌우
    static int[] dy = {0, 1, 0, -1}; // 상하좌우
    static int[][] board;
    static int[][] dist; // 거리를 저장할 배열
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];  // 0-based index로 변경
        dist = new int[n][m];   // 거리 저장 배열

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) - '0';  // 문자 -> 숫자 변환
            }
        }

        bfs(0, 0);  // 시작점 (0, 0)에서 BFS 실행
        System.out.println(dist[n-1][m-1]);  // 도착점의 거리 출력
    }

    // 너비 우선 탐색 함수
    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        dist[x][y] = 1;  // 시작점은 1칸으로 시작

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                // 범위 체크 및 이동 가능 여부 체크
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && board[nextX][nextY] == 1 && dist[nextX][nextY] == 0) {
                    dist[nextX][nextY] = dist[curX][curY] + 1;  // 이동한 거리를 저장
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
    }
}
