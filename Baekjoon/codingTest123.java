package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 4963번 섬의 개수
 * 
 * 입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다. w와 h는 50보다 작거나 같은 양의 정수이다.
 * 둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.
 * 입력의 마지막 줄에는 0이 두 개 주어진다.
 * 섬의 개수 출력
 */

public class codingTest123 {
    static int w, h;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, -1, 1, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w==0 && h==0) break;

            board = new int[h][w];
            visited = new boolean[h][w];

            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(!visited[i][j] && board[i][j]==1){
                        visited[i][j] = true;
                        countIsland(i, j);
                        cnt++;
                    }
                }
            }

            sb.append(cnt + "\n");

        }

        System.out.println(sb);
    }

    static void countIsland(int x, int y){
        for(int i=0; i<8; i++){
            int curX = x+dx[i];
            int curY = y+dy[i];

            if(curX>=0 && curX<h && curY>=0 && curY<w && !visited[curX][curY] && board[curX][curY]==1){
                visited[curX][curY] = true;
                countIsland(curX, curY);
            }
        }
    }
}

