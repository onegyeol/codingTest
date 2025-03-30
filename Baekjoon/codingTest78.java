package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 3109번 빵집
 * 
 * 빵집이 있는 곳은 R*C 격자로 표현할 수 있다. 첫째 열은 근처 빵집의 가스관이고, 마지막 열은 원웅이의 빵집이다.

원웅이는 가스관과 빵집을 연결하는 파이프를 설치하려고 한다. 빵집과 가스관 사이에는 건물이 있을 수도 있다. 건물이 있는 경우에는 파이프를 놓을 수 없다.

가스관과 빵집을 연결하는 모든 파이프라인은 첫째 열에서 시작해야 하고, 마지막 열에서 끝나야 한다. 각 칸은 오른쪽, 오른쪽 위 대각선, 오른쪽 아래 대각선으로 연결할 수 있고, 각 칸의 중심끼리 연결하는 것이다.

원웅이는 가스를 되도록 많이 훔치려고 한다. 따라서, 가스관과 빵집을 연결하는 파이프라인을 여러 개 설치할 것이다. 이 경로는 겹칠 수 없고, 서로 접할 수도 없다. 즉, 각 칸을 지나는 파이프는 하나이어야 한다.

원웅이 빵집의 모습이 주어졌을 때, 원웅이가 설치할 수 있는 가스관과 빵집을 연결하는 파이프라인의 최대 개수를 구하는 프로그램을 작성하시오.
 */

public class codingTest78 {
    static char[][] board;
    static boolean[][] visited;
    static int r, c, answer=0;
    static int[] dx = {-1, 0, 1}; // 행 이동: 위, 중간, 아래
    static int[] dy = {1, 1, 1};  // 열 이동: 오른쪽으로 고정

    static boolean dfs(int x, int y){
        if(y==c-1) {
            answer++;
            return true;
        }

        for(int i=0; i<3; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0 || nx>=r || ny<0 || ny>=c) continue;
            if(visited[nx][ny] || board[nx][ny]=='x') continue;

            visited[nx][ny] = true;
            if(dfs(nx, ny)) return true;
        }

        return false;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];
        visited = new boolean[r][c];

        for(int i=0; i<r; i++){
            board[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<r; i++){
            if(board[i][0] == '.'){ // 첫째 열에서 시작 가능한 지점 탐색
                visited[i][0] = true;
                dfs(i, 0);
            }
        }

        System.out.println(answer);
    }
    
}

/*
 * import sys
 * input = sys.stdin.read
 * 
 * def dfs(x, y):
 *  if y==c-1:
 *      return True
 * 
 *  for dx, dy in [(-1, 1), (0, 1), (1, 1)] :
 *      nx, ny = x+dx, y+dy
 * 
 *      if 0<=nx<r and 0<=ny<c and not visited[nx][ny] and board[nx][ny] =='.':
 *          visited[nx][ny] = True
 *          if dfs(nx, ny):
 *              return True
 * return False  
 * 
 *  data = input().splitlines()
 * r, c = map(int, data[0].split())
 * board = [list(data[i+1]) for i in range(r)]
 * visited = [[False]*c for _ in range(r)]
 * 
 * answer = 0
 * 
 * for i in range(r):
 *  if board[i][0] == '.':
 *      visited[i][0] = True
 *      if(dfs(i, 0)):
 *          answer+=1
 * 
 * print(answer)
 * 
 */