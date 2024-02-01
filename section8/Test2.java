package section8;

import java.util.*;
/**
 * 철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C킬로그램 넘게 태울수가 없다.

철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.

N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램을 작성하세요.

 */

public class Test2 {
    static int[] arr;
    static int n, c, answer=0;

    public void DFS(int level, int sum){
        if(sum <= c){
            if(level == n) answer = Math.max(answer, sum);
            else{
                DFS(level+1, sum+arr[level]);
                DFS(level+1, sum);
            }
        }
        
    }
    public static void main(String[] args) {
        Test2 t = new Test2();
        Scanner in = new Scanner(System.in);

        c = in.nextInt();
        n = in.nextInt();
        arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }

        t.DFS(0, 0);
        System.out.println(answer);

    }
}
