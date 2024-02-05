package section8;

import java.util.*;

public class Test5 {
    static int n, m, answer = Integer.MAX_VALUE;

    public void DFS(int cnt, int sum, Integer[] coins){
        if(sum > m) return;
        if(cnt >= answer) return;
        if(sum == m){
            answer = Math.min(answer, cnt);
        }
        else{
            for(int i=0; i<n; i++){
                DFS(cnt+1, sum+coins[i], coins);
            }
        }
    }
    public static void main(String[] args) {
        Test5 t = new Test5();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        Integer[] coins = new Integer[n]; //Collections.reverseOrder()을 사용하기 위해선 WrapperClass 여야 함.

        for(int i=0; i<n; i++){
            coins[i] = in.nextInt();
        }
    
        Arrays.sort(coins, Collections.reverseOrder()); //빠르게 하기 위해 입력받은 동전 종류를 내림차순으로 정렬
        
        m = in.nextInt();

        t.DFS(0, 0, coins);
        System.out.println(answer);
    }
}
