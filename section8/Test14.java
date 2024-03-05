package section8;

import java.util.*;

/**
 * 코테 강의 8-14. 피자 배달 거리
 * 
 * N×N 크기의 도시지도가 있습니다. 도시지도는 1×1크기의 격자칸으로 이루어져 있습니다.

각 격자칸에는 0은 빈칸, 1은 집, 2는 피자집으로 표현됩니다. 각 격자칸은 좌표(행번호, 열 번호)로 표현됩니다.

행번호는 1번부터 N번까지이고, 열 번호도 1부터 N까지입니다.

도시에는 각 집마다 “피자배달거리”가 았는데 각 집의 피자배달거리는 해당 집과 도시의 존재하는

피자집들과의 거리 중 최소값을 해당 집의 “피자배달거리”라고 한다.

집과 피자집의 피자배달거리는 |x1-x2|+|y1-y2| 이다.

시장은 살리고자 하는 피자집 M개를 선택하는 기준으로 도시의 피자배달거리가 최소가 되는 M개의 피자집을 선택하려고 합니다.

도시의 피자 배달 거리는 각 집들의 피자 배달 거리를 합한 것을 말합니다.
 */

class Point{
    public int x, y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Test14 {
    static int n, m,answer=Integer.MAX_VALUE;
    static ArrayList<Point> home, pizza;
    static int[] combi; //각 집에서 피자집까지 최소거리 구하기 위한 조합
    public void DFS(int l, int s){
        if(l==m){
            int sum=0;
            for(Point p : home){
                int dis = Integer.MAX_VALUE;
                for(int i: combi){ //각 조합에서 집 ~ 피자집 배달거리 구함
                    dis = Math.min(dis, Math.abs(p.x-pizza.get(i).x) + Math.abs(p.y-pizza.get(i).y));
                }
                sum += dis;
            }
            answer = Math.min(sum, answer);
        }
        else{
            for(int i=s; i<pizza.size(); i++){
                combi[l] = i; //조합 추출
                DFS(l+1, i+1);
            }
        }
    }

    public static void main(String[] args) {
        Test14 t = new Test14();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        home = new ArrayList<>();
        pizza = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int tmp = in.nextInt();
                if(tmp == 1) home.add(new Point(i, j));
                else if(tmp == 2) pizza.add(new Point(i, j));
            }
        }

        combi = new int[m];

        t.DFS(0, 0);
        System.out.println(answer);

    }
}
