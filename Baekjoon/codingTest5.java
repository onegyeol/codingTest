package Baekjoon;

import java.io.IOException;
import java.util.Scanner;

/**
 * 1987번 알파벳
 * 
 * 세로 R칸, 가로 C칸으로 된 표 모양의 보드가 있다. 보드의 각 칸에는 대문자 알파벳이 하나씩 적혀 있고, 좌측 상단 칸 (1행 1열) 에는 말이 놓여 있다.

말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데, 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다. 즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.

좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지를 구하는 프로그램을 작성하시오. 말이 지나는 칸은 좌측 상단의 칸도 포함된다.
 */

public class codingTest5 {
    static int r, c, answer=0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        r = in.nextInt();
        c = in.nextInt();
        in.nextLine();

        board = new int[r][c];
        visited = new boolean[26];

        for(int i=0; i<r; i++){
            String s = in.nextLine();
            for(int j=0; j<c; j++){
                board[i][j] = s.charAt(j) - 'A';
            }
        }

        DFS(0, 0, 1);
        System.out.println(answer);

    }

    static void DFS(int x, int y, int len){
        visited[board[x][y]] = true;
        answer = Math.max(answer, len);

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx <r && ny>=0 && ny<c && !visited[board[nx][ny]]){
                DFS(nx, ny, len+1);
                visited[board[nx][ny]] = false;
            }
        }
        
    }

    /**
     * 테스트 통과는 안됐는데 주어진 예시로 입력하면 똑같은 값이 나온 코드
     * 
     * public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");

        r = Integer.parseInt(st[0]);
        c = Integer.parseInt(st[1]);
        board = new char[r][c];

        for(int i=0; i<r; i++){
            String s = br.readLine();
            for(int j=0; j<c; j++){
                board[i][j] = s.charAt(j);
            }
        }

        System.out.println(BFS(0, 0));

    }

    static int BFS(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        ArrayList<Character> visited = new ArrayList<>();
        q.offer(new int[]{x, y});
        visited.add(board[x][y]);
        int cnt=1;

        while(!q.isEmpty()){
            int[] data = q.poll();
            int curX = data[0];
            int curY = data[1];

            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if(nx>=0 && nx <r && ny>=0 && ny<c){
                    if(!visited.contains(board[nx][ny])){
                        visited.add(board[nx][ny]);
                        q.offer(new int[]{nx, ny});
                        cnt++;
                    }
                }
            }
        }
        return cnt;
        
    }
     */
    
}
