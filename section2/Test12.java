package section2;

import java.util.*;

public class Test12 {
    public int solution(int n, int m, int[][] a){
        int answer = 0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                int cnt = 0;
                for(int k=0; k<m; k++){
                    int pi=0, pj=0;
                    for(int s=0; s<n; s++){
                        if(a[k][s] == i) pi = s; //등수 넣어주기
                        if(a[k][s] == j) pj = s;
                    }

                    if(pi < pj) cnt++;
                }
                if(cnt == m) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Test12 t = new Test12();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(); //배열의 열
        int m = in.nextInt(); //배열의 행
        int[][] arr = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = in.nextInt();
            }
        }

        System.out.println(t.solution(n, m, arr));
        
    }

}

