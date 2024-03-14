package section10;

import java.util.*;

/**
 * 다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?

각 단위의 동전은 무한정 쓸 수 있다.

첫 번째 줄에는 동전의 종류개수 N(1<=N<=50)이 주어진다.

두 번째 줄에는 N개의 동전의 종류가 주어지고, 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.


 */

public class Test5 {
    static int n, m;
    static int[] dy; //인덱스 이용. i 금액을 만드는데 필요한 최소 동전 개수

    public int solution(int[] arr){
        Arrays.fill(dy, Integer.MAX_VALUE); //최소값을 찾기위해 최대값으로 초기화해줌
        dy[0] = 0;

        for(int i=0; i<n; i++){ //coin 개수만큼
            for(int j=arr[i]; j<=m; j++){
                dy[j] = Math.min(dy[j], dy[j-arr[i]]+1);
            }
        }

        return dy[m];
    }
    public static void main(String[] args) {
        Test5 t = new Test5();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        int[] coin = new int[n];

        for(int i=0; i<n; i++){
            coin[i] = in.nextInt();
        }
        
        m = in.nextInt();
        dy = new int[m+1];
        System.out.println(t.solution(coin));
    }
}
