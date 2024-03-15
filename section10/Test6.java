package section10;

import java.util.*;

/**
 * 코테 강의 10-6. 최대점수 구하기
 * 
 * 이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.

각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.

제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.

(해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)
 */

public class Test6 {
    
    public static void main(String[] args) {
        Test6 t = new Test6();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] dy = new int[m+1]; //0으로 초기화되어 있음

        for(int i=0; i<n; i++){
            int score = in.nextInt();
            int time = in.nextInt();
            for(int j=m; j>=time; j--){ //문제가 하나 뿐이기때문에 뒤에서부터 반복문 진행됨.
                dy[j] = Math.max(dy[j], dy[j-time]+score);
            }
        }

        System.out.println(dy[m]);
        
    }
}
