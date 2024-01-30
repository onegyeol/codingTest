package progammers;

import java.util.*;

/**
 * 대결은 준비된 음식들을 일렬로 배치한 뒤, 한 선수는 제일 왼쪽에 있는 음식부터 오른쪽으로, 
 * 다른 선수는 제일 오른쪽에 있는 음식부터 왼쪽으로 순서대로 먹는 방식으로 진행됩니다. 중앙에는 물을 배치하고, 
 * 물을 먼저 먹는 선수가 승리하게 됩니다.
 * 
 * 이때, 대회의 공정성을 위해 두 선수가 먹는 음식의 종류와 양이 같아야 하며, 음식을 먹는 순서도 같아야 합니다. 
 * 또한, 이번 대회부터는 칼로리가 낮은 음식을 먼저 먹을 수 있게 배치하여 선수들이 음식을 더 잘 먹을 수 있게 하려고 합니다.
 * 
 * 제한사항
 * food에는 칼로리가 적은 순서대로 음식의 양이 담겨 있습니다.
 * food[i]는 i번 음식의 수입니다.
 * food[0]은 수웅이가 준비한 물의 양이며, 항상 1입니다.
 * 정답의 길이가 3 이상인 경우만 입력으로 주어집니다.
 */


public class codingTest29 {
    public StringBuffer solution(int[] food) {
        StringBuffer answer = new StringBuffer();
        int idx=0;
        
        for(int i=1; i<food.length; i++){
            if(food[i] >= 2){
                for(int j=0; j<food[i]/2; j++){
                    answer.insert(idx, i);
                    answer.insert(answer.length()-1-idx, i);
                    idx++;
                }
            }
        }
        
        answer.insert(idx, 0);
        
        return answer;
    }
}
