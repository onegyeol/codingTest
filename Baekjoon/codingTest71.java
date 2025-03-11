package Baekjoon;

import java.util.*;
import java.io.*;

/*
 * 백준 2468번 안전한 영역
 * 
 * 어떤 지역의 높이 정보가 주어졌을 때, 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 계산하는 프로그램을 작성하시오.
 * 
 * 첫째 줄에는 어떤 지역을 나타내는 2차원 배열의 행과 열의 개수를 나타내는 수 N이 입력된다. N은 2 이상 100 이하의 정수이다. 
 * 둘째 줄부터 N개의 각 줄에는 2차원 배열의 첫 번째 행부터 N번째 행까지 순서대로 한 행씩 높이 정보가 입력된다. 
 * 각 줄에는 각 행의 첫 번째 열부터 N번째 열까지 N개의 높이 정보를 나타내는 자연수가 빈 칸을 사이에 두고 입력된다. 높이는 1이상 100 이하의 정수이다.
 */

public class codingTest71 {
    static int n;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static void dfs(int x, int y, int h){
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int currX = x + dx[i];
            int currY = y + dy[i];

            if(currX>=0 && currX<n && currY>=0 && currY<n && !visited[currX][currY] && board[currX][currY]>h){ // 방문한 노드가 아니며, 물에 잠기지 않아야함
                dfs(currX, currY, h);
            }

            
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new boolean[n][n];

        int max=0;
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(max < board[i][j]){
                    max = board[i][j];
                }
            }
        }

        int res=0;
        for(int i=0; i<=max; i++){ // 높이
            for(int j=0; j<n; j++){
                Arrays.fill(visited[j], false); // 매번 FALSE로 초기화
            }
            
            int cnt=0;
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if(board[j][k]>i && !visited[j][k]){
                        cnt++;
                        dfs(j, k, i);
                    }
                }
            }

            res = Math.max(cnt, res);
        }

        System.out.println(res);
    }   
}
