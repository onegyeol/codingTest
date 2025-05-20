package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 14716번 현수막
 * 
 * 저번 학기 영상처리 수업을 듣고 배웠던 지식을 최대한 응용 해보고 싶은 혁진이는 이 현수막에서 글자가 몇 개인지 알아보는 프로그램을 만들려 한다.
 * 혁진이는 우선 현수막에서 글자인 부분은 1, 글자가 아닌 부분은 0으로 바꾸는 필터를 적용하여 값을 만드는데 성공했다.
 * 그런데 혁진이는 이 값을 바탕으로 글자인 부분 1이 상, 하, 좌, 우, 대각선으로 인접하여 서로 연결되어 있다면 한 개의 글자라고 생각만 하였다.
 * 혁진이가 필터를 적용하여 만든 값이 입력으로 주어졌을 때, 혁진이의 생각대로 프로그램을 구현하면 글자의 개수가 몇 개인지 출력하여라.
 *  
 */

public class codingTest90 {
    static int dx[] = {0, 0, -1, 1, -1, 1, -1, 1};
    static int dy[] = {-1, 1, 0, 0, 1, 1, -1, -1};
    static int n, m;
    static int[][] board;
    static boolean[][] visited;

    static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i=0; i<8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < m && ny >= 0 && ny < n){
                if(!visited[nx][ny] && board[nx][ny] == 1){
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); 
        n = Integer.parseInt(st.nextToken()); 
        board = new int[m][n];
        visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 1 && !visited[i][j]){
                    dfs(i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
