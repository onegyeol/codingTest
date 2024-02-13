package section8;

import java.util.*;

/**
 * 코테 강의 8-8. 수열 추측하기
 * 
 * 가장 윗줄에 1부터 N까지의 숫자가 한 개씩 적혀 있다. 그리고 둘째 줄부터 차례대로 파스칼의 삼각형처럼 위의 두개를 더한 값이 저장되게 된다.
 * N과 가장 밑에 있는 숫자가 주어져 있을 때 가장 윗줄에 있는 숫자를 구하는 프로그램을 작성하시오.
 */

public class Test8 {
    static int n, f;
    static int[] c, p, ch;
    static int[][] dy = new int[35][35];
    static boolean flag = false;

    public int combi(int n, int r){
        if(dy[n][r] > 0) return dy[n][r];
        if(n==r || r==0) return 1;
        else return dy[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }

    public void DFS(int l, int sum){
        if(flag) return; //이미 출력됐으면 더이상 못구하게 flag 변수 통해 튕겨냄
        if(l == n){
            if(sum == f){
                for(int x : p) System.out.print(x + " ");
                flag = true;
            }
        }
        else{
            for(int i=1; i<=n; i++){ //i는 인덱스 번호가 아닌 값이라고 생각하면 됨
                if(ch[i] == 0){ //방문하지 않았다면 
                    ch[i] = 1;
                    p[l] = i; //인덱스 l에 값 i를 넣어줌
                    DFS(l+1, sum+(p[l]*c[l])); // 조합 배열의 l번 인덱스에 있는 값과 p배열에 있는 값을 곱해 sum에 더함
                }
            }
        }
    }

    public static void main(String[] args) {
        Test8 t = new Test8();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        f = in.nextInt();
        c = new int[n];
        p = new int[n]; //p의 숫자 자체가 값임
        ch = new int[n+1];

        for(int i=0; i<n; i++){
            c[i] = t.combi(n-1, i); //조합을 이용해 c 배열에 값을 넣어줌
        }
        t.DFS(0, 0);
    }
}
