package section8;

import java.util.*;

/**코테 강의 8-9. 조합구하기
 * 
 * 1 ~ n 까지 번호 적힌 구슬 존재. 이 중 m개 뽑는 방법의 수
 * 출력 순서는 오름차순으로.
 */

public class Test9 {
    static int n, m;
    static int[] ch, pm;
    /*내 풀이
    public void DFS(int cnt){
        if(cnt == m){
            for(int i : pm) System.out.print(i + " ");
            System.out.println();
        }
        else{
            for(int i=1; i<=n; i++){
                if(ch[i] == 0){
                    if(cnt == 0 || pm[cnt-1] < i){
                        ch[i] = 1;
                        pm[cnt] = i;
                        DFS(cnt+1);
                        ch[i] = 0;
                    }
                }
            }
        }
    }*/

    public void DFS(int cnt, int s){
        if(cnt == m){
            for(int i: pm) System.out.print(i + " ");
            System.out.println();
        }
        else{
            for(int i=s; i<=n; i++){
                pm[cnt] = i;
                DFS(cnt+1, i+1);
            }
        }
    }
    public static void main(String[] args) {
        Test9 t = new Test9();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        ch = new int[n];
        pm = new int[m];

        //t.DFS(0);
        t.DFS(0, 1);
    }

}
