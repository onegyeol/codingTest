package Baekjoon;
import java.util.*;

/**
 * 16956번 늑대와 양
 * 
 * 크기가 R×C인 목장이 있고, 목장은 1×1 크기의 칸으로 나누어져 있다. 각각의 칸에는 비어있거나, 양 또는 늑대가 있다. 
 * 양은 이동하지 않고 위치를 지키고 있고, 늑대는 인접한 칸을 자유롭게 이동할 수 있다. 
 * 두 칸이 인접하다는 것은 두 칸이 변을 공유하는 경우이다.

목장에 울타리를 설치해 늑대가 양이 있는 칸으로 갈 수 없게 하려고 한다. 늑대는 울타리가 있는 칸으로는 이동할 수 없다. 울타리를 설치해보자.
 */

public class codingTest10 {
    static int r, c, answer=1;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Character[][] board;
    static int[][] visited; 

    static void DFS(int x, int y){  
        for(int i=0; i<4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx>=0 && nx<r && ny>=0 && ny<c && visited[nx][ny] == 0){
                if((board[x][y] == 'S' && board[nx][ny] == 'W')){
                    answer = 0;
                }

                if((board[x][y] == 'W' && board[nx][ny] == '.')){
                    board[nx][ny] = 'D';
                    visited[nx][ny] = 1;
                    DFS(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        r = in.nextInt();
        c = in.nextInt();

        in.nextLine();

        board = new Character[r][c];
        visited = new int[r][c];

        for(int i=0; i<r; i++){
            String s = in.nextLine();
            for(int j=0; j<c; j++){
                board[i][j] = s.charAt(j);
                if(board[i][j] == 'W'){
                    
                }
            }
        }

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(board[i][j] == 'S' || board[i][j] == 'W') {
                    DFS(i, j);
                }
            }
        }

        System.out.println(answer);
        if(answer == 1){
            for(int i=0; i<r; i++){
                for(int j=0; j<c; j++){
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        }
    }
}

/**
 * 다른 풀이
 * 
 * public class Main {
    static int r, c;
    static char[][] map;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean flag = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'W') {
                    q.add(new int[]{i, j});
                }
            }
        }
        bfs();

        if (flag) {
            System.out.println("1");
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println("0");
        }


    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int x = t[0];
            int y = t[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    if (map[nx][ny] == '.') {
                        map[nx][ny] = 'D';
                    }
                    if (map[nx][ny] == 'S') {
                        flag = false;
                        return;
                    }
                }
            }
        }
    }
}

 */