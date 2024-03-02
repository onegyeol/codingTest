package section10;

import java.util.*;

/**
 * 코테 강의 10-1. 계단 오르기
 * 
 * 철수는 계단을 오를 때 한 번에 한 계단 또는 두 계단씩 올라간다. 만약 총 4계단을 오른다면 그 방법의 수는

1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2 로 5가지이다.

그렇다면 총 N계단일 때 철수가 올라갈 수 있는 방법의 수는 몇 가지인가?
 */

public class Test1 {
    static int[] dy;
    public int solution(int n){ //그냥 피보나치라고 생각하면 됨
        dy[1] = 1;
        dy[2] = 2;

        for(int i=3; i<=n; i++){
            dy[i] = dy[i-2] + dy[i-1]; //2번째 전 계단에서 두칸 올라올 수도 + 1번째 전 계단에서 한칸 올라올 수도
        }
        return dy[n];
    }
    public static void main(String[] args) {
        Test1 t = new Test1();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        dy = new int[n+1]; //각 인덱스번호로 계단 번호를 나타냄
        System.out.println(t.solution(n));
    }

}
