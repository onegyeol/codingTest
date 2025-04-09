package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 백준 3190번 뱀
 *
 * 'Dummy' 라는 도스게임이 있다. 이 게임에는 뱀이 나와서 기어다니는데, 사과를 먹으면 뱀 길이가 늘어난다. 뱀이 이리저리 기어다니다가 벽 또는 자기자신의 몸과 부딪히면 게임이 끝난다.

게임은 NxN 정사각 보드위에서 진행되고, 몇몇 칸에는 사과가 놓여져 있다. 보드의 상하좌우 끝에 벽이 있다. 게임이 시작할때 뱀은 맨위 맨좌측에 위치하고 뱀의 길이는 1 이다. 뱀은 처음에 오른쪽을 향한다.

뱀은 매 초마다 이동을 하는데 다음과 같은 규칙을 따른다.

먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
만약 벽이나 자기자신의 몸과 부딪히면 게임이 끝난다.
만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
사과의 위치와 뱀의 이동경로가 주어질 때 이 게임이 몇 초에 끝나는지 계산하라.
 */

class Point{
    int x, y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class codingTest82 {
    static int n, k, l;
    static int[][] board;
    static HashMap<Integer, String> spins = new HashMap<>();
    static Deque<int[]> snake = new LinkedList();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        board = new int[n+1][n+1];

        k = Integer.parseInt(br.readLine());

        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            board[a][b] = 1;
        }

        l = Integer.parseInt(br.readLine());

        for(int i=0; i<l; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            spins.put(t, s);
        }

        solve();
    }

    static void solve(){
        int time=0;
        int cx=1, cy=1;
        int d=0;
        snake.add(new int[]{1, 1});

        while(true){
            time++;

            int nx = cx + dx[d];
            int ny = cy + dy[d];

            if(isFinish(nx, ny)) break;

            if(board[nx][ny] == 1){ //사과를 만났을 때
                board[nx][ny] = 0; // 사과 사라짐
                snake.addFirst(new int[]{nx, ny}); // 머리쪽으로 몸 길이 늘림
            } else{
                snake.addFirst(new int[]{nx, ny});
                snake.removeLast(); // 몸 이동
            }

            if(spins.containsKey(time)){
                if(spins.get(time).equals("D")){ // 오른쪽
                    d=(d+1)%4;
                }
                else{ // 왼쪽은 (-1, 0)부터 시작
                    d=(d-1+4)%4;
                }
            }

            // 위치 업데이트
            cx = nx;
            cy = ny;
        }

        System.out.println(time);
    }

    // 게임 끝났는지 판단
    public static boolean isFinish(int nx, int ny){
        // 게임장 벗어났을 때
        if(nx<=0 || ny<=0 || nx>n || ny>n) return true;

        for (int[] body : snake) { //자신의 몸과 부딪혔을 때
            if (nx == body[0] && ny == body[1]) return true;
        }

        return false;
    }
}

/*
 * from collections import deque
 * 
 * def main():
 *      n = int(input())
 *      board = [[0]*(n+1) for _ in range(n+1)]
 *      
 *      k = int(input())
 *      for _ in range(k):
 *          a, b = map(int, input().split())
 *          board[a][b] = 1
 * 
 *      l = int(input())
 *      spins = {}
 * 
 *      for _ in range(l):
 *          t,s = input().split()
 *          spins[int(t)] = s
 * 
 *      print(solve(n, board, spins))
 * 
 * def solve(n, board, spins):
 *      time=0;
 *      cx, cy = 1, 1
 *      d = 0
 *      snake = deque([(cx, cy)])
 * 
 *      dx = [0, 1, 0, -1]
 *      dy = [1, 0, -1, 0]
 * 
 *      while True:
 *          time+=1
 * 
 *          nx = cx+dx[d]
 *          ny = cy+dy[d]
 * 
 *          if is_finish(nx, ny, n, snake):
 *              break
 * 
 *          if time in spins:
 *              if spins[time] == "D":
 *                  d=(d+1)%4
 *              elif spins[time] == "L":
 *                  d=(d-1+4)%4
 * 
 *          cx, cy = nx, ny
 * return time
 * 
 * def is_finish(nx, ny, n, snake):
 *      if nx<=0 or ny<=0 or nx>n or ny>n:
 *          return True
 *      
 *      if (nx,ny) in snake:
 *          return True
 * 
 * return False
 * 
 * if __name__ == "__main__":
 *      main()
 */