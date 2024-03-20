package Baekjoon;

import java.util.*;

/**
 * 백준 2583 영역 구하기
 * 
 * 눈금의 간격이 1인 M×N(M,N≤100)크기의 모눈종이가 있다. 
 * 이 모눈종이 위에 눈금에 맞추어 K개의 직사각형을 그릴 때, 이들 K개의 직사각형의 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어진다.
 * M, N과 K 그리고 K개의 직사각형의 좌표가 주어질 때, K개의 직사각형 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어지는지, 
 * 그리고 분리된 각 영역의 넓이가 얼마인지를 구하여 이를 출력하는 프로그램을 작성하시오.
 */

public class codingTest2 {
    static int m, n, k;
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};
    static int[][] board;  //사각형인 곳은 1로, 아닌 곳은 0으로 표시
    static boolean[][] visited; //방문 여부

    public int BFS(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        int cnt=1; //분리된 영역의 넓이

        while(!q.isEmpty()){
            int[] data = q.poll();
            int curX = data[0];
            int curY = data[1];

            for(int i=0; i<4; i++){
                int nx = curX+dx[i];
                int ny = curY+dy[i];
                if(nx>=0 && nx<m && ny>=0 && ny<n){
                    if(!visited[nx][ny] && board[nx][ny] == 0){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                        cnt++;
                    }

                }
            }
        }
        return cnt;
        
    }

    public static void main(String[] args) {
        codingTest2 t = new codingTest2();
        Scanner in = new Scanner(System.in);

        m = in.nextInt();
        n = in.nextInt();
        k = in.nextInt();
        board = new int[m][n];
        visited = new boolean[m][n];
        ArrayList<Integer> width = new ArrayList<>();

        for(int i=0; i<k; i++){
            int left_x = in.nextInt();
            int left_y = in.nextInt();
            int right_x = in.nextInt();
            int right_y = in.nextInt();

            for(int a=left_y; a<right_y; a++){
                for(int b=left_x; b<right_x; b++){
                    board[a][b] = 1;
                }
            }
        }

        int cnt=0; //사각형 갯수
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && board[i][j] == 0){
                    int data = t.BFS(i, j);
                    width.add(data); //각 영역 넓이 저장
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        Collections.sort(width);
        for(int i =0; i<width.size(); i++){
            System.out.print(width.get(i) + " ");
        }
        

    }
}
