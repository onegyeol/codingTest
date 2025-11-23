package Baekjoon;

import java.util.*;

/**
 * 백준) 평범한 배낭
 * 
 * 이 문제는 아주 평범한 배낭에 관한 문제이다.

한 달 후면 국가의 부름을 받게 되는 준서는 여행을 가려고 한다. 세상과의 단절을 슬퍼하며 최대한 즐기기 위한 여행이기 때문에, 
가지고 다닐 배낭 또한 최대한 가치 있게 싸려고 한다.

준서가 여행에 필요하다고 생각하는 N개의 물건이 있다. 
각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다. 
아직 행군을 해본 적이 없는 준서는 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다. 
준서가 최대한 즐거운 여행을 하기 위해 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 알려주자.
 */

class Things{
    public int w, v;

    Things(int w, int v){
        this.w = w;
        this.v = v;
    }
}

public class codingTest1 {
    public static void main(String[] args) {
        codingTest1 t = new codingTest1();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(); //물품의 수
        int k = in.nextInt(); //버틸 수 있는 무게

        Things[] arr = new Things[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = new Things(in.nextInt(), in.nextInt());
        }

        int[][] dp = new int[n+1][k+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=k; j++){
                // 가방 무게보다 물품 무게가 더 크다면 이전걸로 대체
                if(j < arr[i].w){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i].w] + arr[i].v);
                }
            }
        }

        System.out.println(dp[n][k]);

    }
}
