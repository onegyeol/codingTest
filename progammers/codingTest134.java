package progammers;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 프로그래머스 Lv.2 미로탈출
 * 
 * 1 x 1 크기의 칸들로 이루어진 직사각형 격자 형태의 미로에서 탈출하려고 합니다. 
 * 각 칸은 통로 또는 벽으로 구성되어 있으며, 벽으로 된 칸은 지나갈 수 없고 통로로 된 칸으로만 이동할 수 있습니다. 
 * 통로들 중 한 칸에는 미로를 빠져나가는 문이 있는데, 이 문은 레버를 당겨서만 열 수 있습니다. 레버 또한 통로들 중 한 칸에 있습니다. 
 * 따라서, 출발 지점에서 먼저 레버가 있는 칸으로 이동하여 레버를 당긴 후 미로를 빠져나가는 문이 있는 칸으로 이동하면 됩니다. 
 * 이때 아직 레버를 당기지 않았더라도 출구가 있는 칸을 지나갈 수 있습니다. 미로에서 한 칸을 이동하는데 1초가 걸린다고 할 때, 최대한 빠르게 미로를 빠져나가는데 걸리는 시간을 구하려 합니다.
 * 
 * 미로를 나타낸 문자열 배열 maps가 매개변수로 주어질 때, 미로를 탈출하는데 필요한 최소 시간을 return 하는 solution 함수를 완성해주세요. 만약, 탈출할 수 없다면 -1을 return 해주세요.
 */

public class codingTest134 {
    public static void main(String[] args) {
        // maps 입력받음
    }

    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();

        char[][] grid = new char[n][m];
        int sx = 0, sy = 0, lx = 0, ly = 0, ex = 0, ey = 0;

        // 격자 초기화 및 S, L, E 위치 파악
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = maps[i].charAt(j);
                if (grid[i][j] == 'S') {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 'L') {
                    lx = i;
                    ly = j;
                } else if (grid[i][j] == 'E') {
                    ex = i;
                    ey = j;
                }
            }
        }

        // S → L 거리 계산
        int dist1 = bfs(grid, sx, sy, lx, ly);

        // L → E 거리 계산
        int dist2 = bfs(grid, lx, ly, ex, ey);

        // 둘 다 도달 가능해야 함
        if (dist1 < 0 || dist2 < 0) {
            return -1;
        }
        return dist1 + dist2;
    }

    private int bfs(char[][] grid, int startX, int startY, int targetX, int targetY) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        // 시작 위치, 경로
        q.add(new int[] { startX, startY, 0 });
        visited[startX][startY] = true;

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], d = cur[2];

            if (x == targetX && y == targetY) {
                return d;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m
                        && !visited[nx][ny]
                        && grid[nx][ny] != 'X') {
                    visited[nx][ny] = true;
                    q.add(new int[] { nx, ny, d + 1 });
                }
            }
        }
        return -1;
    }
}
