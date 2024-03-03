package section8;

import java.util.*;

class Point{
    public int x, y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Test13_BFS {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int n, answer=0;
    Queue<Point> q = new LinkedList<>();

    public void BFS(int x, int y, int[][] board){
        q.offer(new Point(x, y));
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i=0; i<8; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny] == 1){
                    board[nx][ny] = 0;
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }

    public void solution(int[][] board){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 1){
                    board[i][j] = 0;
                    BFS(i, j, board);
                    answer++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Test13_BFS t = new Test13_BFS();
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
