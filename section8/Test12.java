package section8;

import java.util.*;


/**
 * 코테 강의 8-12. 토마토
 * 
 * 창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면,

익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.

하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며,

토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 현수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.

토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,

며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.

정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.

여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다.

만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고,

토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.

 */

 class Point{
     public int x, y;
     Point(int x, int y){
         this.x=x;
         this.y=y;
     }
 }
 class Test12 {
     static int[] dx={-1, 0, 1, 0};
     static int[] dy={0, 1, 0, -1};
     static int[][] board, dis;
     static int n, m;
     static Queue<Point> Q=new LinkedList<>();
     public void BFS(){
         while(!Q.isEmpty()){
             Point tmp=Q.poll();
             for(int i=0; i<4; i++){
                 int nx=tmp.x+dx[i];
                 int ny=tmp.y+dy[i];
                 if(nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny]==0){
                     board[nx][ny]=1;
                     Q.offer(new Point(nx, ny));
                     dis[nx][ny]=dis[tmp.x][tmp.y]+1;
                 }
             }
         }	
     }
 
     public static void main(String[] args){
         Test12 T = new Test12();
         Scanner kb = new Scanner(System.in);
         m=kb.nextInt();
         n=kb.nextInt();
         board=new int[n][m];
         dis=new int[n][m];
         for(int i=0; i<n; i++){
             for(int j=0; j<m; j++){
                 board[i][j]=kb.nextInt();
                 if(board[i][j]==1) Q.offer(new Point(i, j));
             }
         }
         T.BFS();
         boolean flag=true;
         int answer=Integer.MIN_VALUE;
         for(int i=0; i<n; i++){
             for(int j=0; j<m; j++){
                 if(board[i][j]==0) flag=false;
             }
         }
         if(flag){
             for(int i=0; i<n; i++){
                 for(int j=0; j<m; j++){
                     answer=Math.max(answer, dis[i][j]);
                 }
             }
             System.out.println(answer);
         }
         else System.out.println(-1);
     }
 }