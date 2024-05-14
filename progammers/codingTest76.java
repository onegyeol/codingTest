package progammers;

import java.util.*;

/**
 * 프로그래머스 Lv.2 땅따먹기
 * 
 * 땅따먹기 게임을 하려고 합니다. 
 * 땅따먹기 게임의 땅(land)은 총 N행 4열로 이루어져 있고, 모든 칸에는 점수가 쓰여 있습니다. 
 * 1행부터 땅을 밟으며 한 행씩 내려올 때, 각 행의 4칸 중 한 칸만 밟으면서 내려와야 합니다. 
 * 단, 땅따먹기 게임에는 한 행씩 내려올 때, 같은 열을 연속해서 밟을 수 없는 특수 규칙이 있습니다.
 * 
 */

public class codingTest76 {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length + 1][4]; // 각 행의 최대 값 저장 배열
    
        // 각 행 순회
        for (int i = 1; i < land.length + 1; i++) {
            // 각 열 순회
            for (int j = 0; j < 4; j++) {
                // 서로 다른 이전 땅의 종류(k)를 고려하여 최대 합 계산
                for (int k = 0; k < 4; k++) {
                    // 같은 종류의 땅은 건너뜀
                    if (j == k) continue;
    
                    // 현재 땅의 값과 이전 행의 서로 다른 종류의 땅 중 최대 합을 더하여 현재 행의 최대 값 갱신
                    dp[i][j] = Math.max(dp[i][j], land[i - 1][j] + dp[i - 1][k]);
    
                    // 현재까지 찾은 최대 값과 비교하여 최종 결과값 갱신
                    answer = Math.max(dp[i][j], answer);
                }
            }
        }
    
        return answer;
    }
    
}
