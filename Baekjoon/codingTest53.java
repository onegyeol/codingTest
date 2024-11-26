package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 1012번 유기농 배추
 * 
 * 차세대 영농인 한나는 강원도 고랭지에서 유기농 배추를 재배하기로 하였다. 
 * 농약을 쓰지 않고 배추를 재배하려면 배추를 해충으로부터 보호하는 것이 중요하기 때문에, 한나는 해충 방지에 효과적인 배추흰지렁이를 구입하기로 결심한다. 
 * 이 지렁이는 배추근처에 서식하며 해충을 잡아 먹음으로써 배추를 보호한다. 
 * 특히, 어떤 배추에 배추흰지렁이가 한 마리라도 살고 있으면 이 지렁이는 인접한 다른 배추로 이동할 수 있어, 그 배추들 역시 해충으로부터 보호받을 수 있다. 
 * 한 배추의 상하좌우 네 방향에 다른 배추가 위치한 경우에 서로 인접해있는 것이다.
 * 0은 배추가 심어져 있지 않은 땅이고, 1은 배추가 심어져 있는 땅을 나타낸다.
 */

public class codingTest53 {
    static Queue<Node> q = new LinkedList<>();
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean visit[][];
    static int m, n, k, count;

    static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 갯수

        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 가로 길이
            n = Integer.parseInt(st.nextToken()); // 세로 길이
            k = Integer.parseInt(st.nextToken()); // 입력

            board = new int[n][m];
            visit = new boolean[n][m];

            for(int j=0; j<k; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                board[y][x] = 1;
            }

            count = 0;
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(visit[j][k]==false && board[j][k] == 1){
                        count++;
                        BFS(k, j);
                    }
                }
            }

            sb.append(count + "\n");

        }

        System.out.println(sb);
    }

    static void BFS(int x, int y){
        q.offer(new Node(x, y));

        while(!q.isEmpty()){
            Node node = q.poll();

            for(int i=0; i<4; i++){
                int currX = node.x + dx[i];
                int currY = node.y + dy[i];

                if(currX>=0 && currX<m && currY>=0 && currY<n && !visit[currY][currX] && board[currY][currX] == 1){
                    q.offer(new Node(currX, currY));
                    visit[currY][currX] = true;
                }
            }
        }
    }
}
