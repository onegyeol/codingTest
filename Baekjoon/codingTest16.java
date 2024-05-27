package Baekjoon;

import java.io.*;
import java.util.*;

/**
 * 백준 14923번 미로 탈출 
 * 
 * 홍익이는 사악한 마법사의 꾐에 속아 N x M 미로 (Hx, Hy) 위치에 떨어졌다. 다행히도 홍익이는 마법사가 만든 미로의 탈출 위치(Ex, Ey)를 알고 있다. 하지만 미로에는 곳곳에 마법사가 설치한 벽이 있어 홍익이가 탈출하기 어렵게 하고 있다.

홍익이는 마법사의 연구실에서 훔친 지팡이가 있어, 벽을 길로 만들 수 있다. 그렇지만, 안타깝게도 마법의 지팡이는 단 한 번만 사용할 수 있다.

이때, 홍익이를 도와 미로에서 탈출할 수 있는지 알아보고, 할 수 있다면 가장 빠른 경로의 거리 D는 얼마인지 알아보자.

인접한 칸으로 이동하는데 똑같은 시간이 들고, 벽을 부수는 데 시간이 걸리지 않는다.
 */
public class codingTest16 {
    static int n,m, Hx, Hy, Ex, Ey;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        Hx = in.nextInt()-1; //시작 x 좌표
        Hy = in.nextInt()-1; //시작 y 좌표
        Ex = in.nextInt()-1; //종료 x 좌표
        Ey = in.nextInt()-1; //종료 y 좌표

        board = new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                board[i][j] = in.nextInt();
            }
        }

        System.out.println(BFS(board));
    }

    
    public static int BFS(int[][] board){
        boolean[][][] v = new boolean[n][m][2]; //벽을 부쉈는지 판단하기 위해 3차원 배열 사용
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{Hx, Hy, 1}); //시작지점에서 시작
        int cnt=0;
        while(!q.isEmpty()){
            int size = q.size();
            while(--size>=0){
                int[] tmp = q.poll();
                if(tmp[0] == Ex && tmp[1]==Ey) return cnt; //도착지점에 도달하면 끝
                for(int i=0; i<4; i++){
                    int nx = tmp[0]+dx[i];
                    int ny = tmp[1]+dy[i];
                    if(0<=nx && n>nx && 0<=ny && m>ny && !v[nx][ny][tmp[2]]){
                        if(board[nx][ny] == 0){ //길이라면 
                            v[nx][ny][tmp[2]] = true; //지나왔으니까 지팡이 사용할 필요없기에
                            q.add(new int[]{nx, ny, tmp[2]});
                        }
                        else if(board[nx][ny]==1 && tmp[2] == 1){ //벽을 부수지 않았다면
                            v[nx][ny][0] = true; //벽을 부쉈으면 0으로 바꿔줌
                            q.add(new int[]{nx, ny, 0});
                        }
                    }
                }
            }
            cnt++;
        }
        return -1;

    }
    
}
