package section8;

import java.util.*;

/**
 * 이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.

각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.

제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.

 */

public class Test3 {
    static int[][] student;
    static int n, m, answer=0;
    public void DFS(int level, int sum_score, int sum_sec){
        if(sum_sec <= m){
            if(level == n) answer = Math.max(sum_score, answer);
            else{
                DFS(level+1, sum_score + student[level][0], sum_sec + student[level][1]);
                DFS(level+1, sum_score, sum_sec);
            }
        }
    }
    public static void main(String[] args) {
        Test3 t = new Test3();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        student = new int[n][2];

        for(int i=0; i<n; i++){
            student[i][0] = in.nextInt(); //점수
            student[i][1] = in.nextInt(); //걸린시간
        }

        t.DFS(0, 0, 0);
        System.out.println(answer);
    }

}
