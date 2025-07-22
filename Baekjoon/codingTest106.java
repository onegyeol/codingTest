package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
 * 백준 1926번 그림
 * 
 * 어떤 큰 도화지에 그림이 그려져 있을 때, 그 그림의 개수와, 그 그림 중 넓이가 가장 넓은 것의 넓이를 출력하여라. 
 * 단, 그림이라는 것은 1로 연결된 것을 한 그림이라고 정의하자. 가로나 세로로 연결된 것은 연결이 된 것이고 대각선으로 연결이 된 것은 떨어진 그림이다. 
 * 그림의 넓이란 그림에 포함된 1의 개수이다.
 */

public class codingTest106 {
    static int[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int result=0, n, m, maxArea=0;

    static int picture(int x, int y){
        visited[x][y] = true;
        int area=1;

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && board[nx][ny] == 1){
                area += picture(nx, ny);
            }
        }

        return area;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m;j ++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m;j ++){
                if(board[i][j]==1 && !visited[i][j]){
                    int area = picture(i, j);
                    result++;
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        System.out.println(result);
        System.out.println(maxArea);

    }
}
