package section8;

import java.util.*;

/**
 * 코테 강의 8-10. 미로탐색 (DFS)
 * 
 * 7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.
 * 출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 
 * 격자판의 1은 벽이고, 0은 통로이다.
 * 격자판의 움직임은 상하좌우로만 움직임.

 */

public class Test10 {
    static int[][] board = new int[8][8];
    static int[] dx={-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer=0;

    public void DFS(int x, int y){
        if(x==7 && y==7){
            answer++;
        }
        else{
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    DFS(nx, ny);
                    board[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Test10 t = new Test10();
        Scanner in = new Scanner(System.in);

        for(int i=1; i<8; i++){
            for(int j=1; j<8; j++){
                board[i][j] = in.nextInt();
            }
        }

        board[1][1] = 1;
        t.DFS(1, 1);
        System.out.println(answer);
    }
}
