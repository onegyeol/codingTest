package progammers;

import java.util.*;

class Point{
    public int x,y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class codingTest24 {

    public int BFS(int[][] maps){
        Queue<Point> q = new LinkedList<>();
        int[][] dis = new int[maps.length][maps[0].length];
        int[] dx={-1, 0, 1, 0};
        int[] dy={0, 1, 0, -1};
        
        q.offer(new Point(0, 0));
        maps[0][0] = 0;
        
        while(!q.isEmpty()){
            Point tmp = q.poll();
            for(int i=0; i<4; i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                if(nx>=0 && nx<maps.length && ny>=0 && ny<maps[0].length && maps[nx][ny]==1){
                    maps[nx][ny] = 0;
                    q.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y]+1;
                }
            }
        }
        
        return dis[maps.length-1][maps[0].length-1];
    }
    
    public int solution(int[][] maps) {
        codingTest24 t = new codingTest24();
        int answer = t.BFS(maps);
        
        if(answer == 0) return -1;
        else return answer+1;

    }

}
