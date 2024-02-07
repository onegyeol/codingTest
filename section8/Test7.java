package section8;

import java.util.*;

/**
 * 코테 강의 8-7. 조합의 경우
 * 
 * 재귀를 이용해 조합수를 구해주는 프로그램을 작성
 */

public class Test7 {
    static int n, r;
    public int DFS(int n, int r){
        if(r==0 || n==r) return 1;
        else return DFS(n-1, r-1)+DFS(n-1, r);
    }
    public static void main(String[] args) {
        Test7 t = new Test7();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        r = in.nextInt();

        System.out.println(t.DFS(n,r));

    }

}
