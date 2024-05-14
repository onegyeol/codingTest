package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 17090번 미로 탈출하기
 * 
 * 크기가 N×M인 미로가 있고, 미로는 크기가 1×1인 칸으로 나누어져 있다. 미로의 각 칸에는 문자가 하나 적혀있는데, 적혀있는 문자에 따라서 다른 칸으로 이동할 수 있다.

어떤 칸(r, c)에 적힌 문자가

U인 경우에는 (r-1, c)로 이동해야 한다.
R인 경우에는 (r, c+1)로 이동해야 한다.
D인 경우에는 (r+1, c)로 이동해야 한다.
L인 경우에는 (r, c-1)로 이동해야 한다.
미로에서 탈출 가능한 칸의 수를 계산해보자. 탈출 가능한 칸이란, 그 칸에서 이동을 시작해서 칸에 적힌대로 이동했을 때, 미로의 경계 밖으로 이동하게 되는 칸을 의미한다.
 */

public class codingTest15 {
    static int n, m;
    static char[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        int escapeCount = 0;

        // 모든 칸을 순회하면서 DFS를 수행하여 탈출 가능한 칸을 찾습니다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (DFS(i, j)) escapeCount++;
                
            }
        }

        System.out.println(escapeCount);
    }

    // DFS를 사용하여 탈출 가능한지 확인합니다.
    static boolean DFS(int x, int y) {
        boolean result = false;
        if (0>x|| 0>y ||x>=n ||y>=m)return true;

        if (board[x][y]=='T')return true;
        else if (board[x][y]=='F')return false;

        if (visited[x][y])return false;

        visited[x][y] =true;

        if (board[x][y]=='U')result = DFS(x-1,y);
        else if (board[x][y]=='R') result = DFS(x,y+1);
        else if (board[x][y]=='L') result = DFS(x,y-1);
        else if (board[x][y]=='D') result = DFS(x+1,y);

        board[x][y] = result?'T':'F';
        
        return result;
    }
}
