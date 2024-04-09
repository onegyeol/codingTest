package Baekjoon;

import java.util.*;

public class codingTest11 {
    static int n, m, answer=0;
    static char[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public void DFS(int x, int y){
        
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        board = new char[n][m];

        for(int i=0; i<n; i++){
            String s = in.nextLine();
            for(int j=0; j<m; j++){
                board[i][j] = s.charAt(j);
            }
        }

        System.out.println(answer);
    }
}
