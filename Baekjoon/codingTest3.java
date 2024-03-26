package Baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 백준 2667 단지번호 붙이기
 * <그림 1>과 같이 정사각형 모양의 지도가 있다. 
 * 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 
 * 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 
 * 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 
 * 대각선상에 집이 있는 경우는 연결된 것이 아니다. 
 * <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 
 * 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오
 */

public class codingTest3 {
    static int n;
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};
    static int[][] board;
    static boolean[][] visited;

    public int BFS(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        int cnt = 1;

        while(!q.isEmpty()){
            int[] temp = q.poll();
            int curX = temp[0];
            int curY = temp[1];

            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny] && board[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    cnt++;
                }
            }
        }
        return cnt;

    }

    public static void main(String[] args) {
        codingTest3 t = new codingTest3();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        board = new int[n][n];
        visited = new boolean[n][n];
        ArrayList<Integer> house = new ArrayList<>();

        for(int i=0; i<n; i++){
            String input = in.next();
            for(int j=0; j<n; j++){
                board[i][j] = input.charAt(j) - '0';
            }
        }

        int cnt=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && board[i][j] == 1){
                    int data = t.BFS(i, j);
                    house.add(data);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        Collections.sort(house);
        
        for(int i=0; i<house.size(); i++){
            System.out.println(house.get(i));
        }
    }
}
