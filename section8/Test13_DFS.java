package section8;

import java.util.*;

/**
 * 코테 강의 8-13. 섬나라 아일랜드
 * 
 * N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.

각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.

섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.
 */

class Point{
    public int x, y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Test13_DFS {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int answer=0, n;
    public void DFS(int x, int y, int[][] board){
        for(int i=0; i<8; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny] == 1){
                board[nx][ny] = 0; //이미 방문한 섬은 그냥 바다로 바꿔줌
                DFS(nx, ny, board);
            }
        }
    }

    public void solution(int[][] board){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 1){ //섬일때만
                    answer++;
                    DFS(i, j, board); //그 주위의 1인 친구들 찾으러 감
                }
            }
        }
    }
    public static void main(String[] args) {
        Test13_DFS t = new Test13_DFS();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        int[][] board = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = in.nextInt();
            }
        }

        t.solution(board);
        System.out.println(answer);
    }
}
