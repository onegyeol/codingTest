package section9;

import java.util.*;

/**
 * 현수는 씨름 감독입니다. 현수는 씨름 선수를 선발공고를 냈고, N명의 지원자가 지원을 했습니다.

현수는 각 지원자의 키와 몸무게 정보를 알고 있습니다.

현수는 씨름 선수 선발 원칙을 다음과 같이 정했습니다.

“A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자 보다 높은(크고, 무겁다) 지원자가

존재하면 A지원자는 탈락하고, 그렇지 않으면 선발된다.”


 */

public class Test1 {
    public static void main(String[] args) {
        Test1 t = new Test1();
        Scanner kb = new Scanner(System.in);
        int answer=0;

        int n = kb.nextInt();
        int[][] player = new int[n][2];

        for(int i=0; i<n; i++){
            player[i][0] = kb.nextInt();
            player[i][1] = kb.nextInt();
        }

        for(int i=0; i<n; i++){
            int cnt=0;
            for(int j=0; j<n; j++){
                if(i == j) continue;
                else if(player[i][0] > player[j][0] || player[i][1] > player[j][1]) cnt++;
            }
            if(cnt == n-1) answer++;
        }

        System.out.println(answer);

    }
}
