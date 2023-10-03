package section2;

import java.util.*;

public class Test10 {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(int k, int[][] a){
        int result=0; 

        for(int i=0; i<k; i++){
            for(int j=0; j<k; j++){
                boolean flag = true;
                for(int z=0; z<4; z++){
                    int nx = i+dx[z];
                    int ny = j+dy[z];
                    if(nx >= 0 && nx < k && ny >= 0 && ny < k && a[nx][ny] >= a [i][j]){
                        flag = false;
                        break;
                    }
                }
                if(flag) result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Test10 t = new Test10();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] arr = new int[n+1][n+1];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = in.nextInt();
            }
        }

        System.out.println(t.solution(n, arr));
        
    }
}
