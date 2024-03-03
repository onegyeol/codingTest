package section10;

import java.util.*;

/** 
 * 코테 강의 10-2. 돌다리 건너기
 * 
 * 철수는 학교에 가는데 개울을 만났습니다. 개울은 N개의 돌로 다리를 만들어 놓았습니다.

철수는 돌 다리를 건널 때 한 번에 한 칸 또는 두 칸씩 건너뛰면서 돌다리를 건널 수 있습니다.

철수가 개울을 건너는 방법은 몇 가지일까요?


 * 
 */

public class Test2 {
    static int[] ch;
    public int solution(int n){
        ch[1] = 1;
        ch[2] = 2;

        for(int i=3; i<=n+1; i++){
            ch[i] = ch[i-2] + ch[i-1];
        }
        return ch[n+1];

    }
    public static void main(String[] args) {
        Test2 t = new Test2();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        ch = new int[n+2];//앞의 계단오르기와 똑같지만 마지막 돌다리에서 땅에 도착하는 방법까지 생각해줘야 함.

        System.out.println(t.solution(n));
    }
    
}
