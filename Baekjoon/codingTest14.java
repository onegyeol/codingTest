package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 3055번
 * 
 * 사악한 암흑의 군주 이민혁은 드디어 마법 구슬을 손에 넣었고, 그 능력을 실험해보기 위해 근처의 티떱숲에 홍수를 일으키려고 한다.
 * 
 * 이 숲에는 고슴도치가 한 마리 살고 있다. 고슴도치는 제일 친한 친구인 비버의 굴로 가능한 빨리 도망가 홍수를 피하려고 한다.

티떱숲의 지도는 R행 C열로 이루어져 있다. 비어있는 곳은 '.'로 표시되어 있고, 물이 차있는 지역은 '*', 돌은 'X'로 표시되어 있다. 
비버의 굴은 'D'로, 고슴도치의 위치는 'S'로 나타내어져 있다.

매 분마다 고슴도치는 현재 있는 칸과 인접한 네 칸 중 하나로 이동할 수 있다. 
(위, 아래, 오른쪽, 왼쪽) 물도 매 분마다 비어있는 칸으로 확장한다. 
물이 있는 칸과 인접해있는 비어있는 칸(적어도 한 변을 공유)은 물이 차게 된다. 
물과 고슴도치는 돌을 통과할 수 없다. 또, 고슴도치는 물로 차있는 구역으로 이동할 수 없고, 물도 비버의 소굴로 이동할 수 없다.

티떱숲의 지도가 주어졌을 때, 고슴도치가 안전하게 비버의 굴로 이동하기 위해 필요한 최소 시간을 구하는 프로그램을 작성하시오.

고슴도치는 물이 찰 예정인 칸으로 이동할 수 없다. 
 즉, 다음 시간에 물이 찰 예정인 칸으로 고슴도치는 이동할 수 없다. 이동할 수 있으면 고슴도치가 물에 빠지기 때문이다.
 */

public class codingTest14 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> q = new LinkedList<>();
    static Queue<int[]> water = new LinkedList<>();
    static int answer = Integer.MAX_VALUE;
    static int r, c;
    static Character[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new Character[r][c];
    
        for(int i=0; i<r; i++){
            String s = br.readLine();
            for(int j=0; j<c; j++){
                board[i][j] = s.charAt(j);
                if(board[i][j] =='S') q.add(new int[]{i, j, 0}); //거리 계산 위해 0도 넣어줌
                else if(board[i][j] == '*') water.add(new int[]{i, j});
            }
        }
        
        BFS();
        System.out.println(answer==Integer.MAX_VALUE ? "KAKTUS" : answer); //최소 거리 구하지 못하면 KAKTUS 출력

    }

    public static void BFS(){
        while(!q.isEmpty()){
            //물 퍼뜨리기
            int size = water.size();
            for(int i=0; i<size; i++){
                int[] p = water.poll();
                int x = p[0];
                int y = p[1];
                for(int j=0; j<4; j++){
                    int nx = x+dx[j];
                    int ny = y+dy[j];

                    if(nx>=0 && nx<r && ny>=0 && ny<c && board[nx][ny]=='.'){
                        board[nx][ny] = '*';
                        water.add(new int[]{nx, ny});
                    }
                }
            }

            //고슴도치 이동
            size = q.size();
            for(int i=0; i<size; i++){
                int[] p = q.poll();
                int x = p[0];
                int y = p[1];
                int time = p[2];

                for(int j=0; j<4; j++){
                    int nx = x+dx[j];
                    int ny = y+dy[j];

                    if(nx>=0 && nx<r && ny>=0 && ny<c){
                        if(board[nx][ny] == 'D'){ //비버의 굴 도착
                            answer = Math.min(answer, time+1);
                            return;
                        }
                        else if(board[nx][ny] == '.'){ //그냥 길이라면
                            board[nx][ny] = 'S'; // 고슴도치 위치 변경
                            q.add(new int[]{nx, ny, time+1});
                        }
                    }
                }
            }
        }
    }

}
