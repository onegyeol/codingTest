package progammers;

/**
 * 로또를 구매한 민우는 당첨 번호 발표일을 학수고대하고 있었습니다. 
 * 하지만, 민우의 동생이 로또에 낙서를 하여, 일부 번호를 알아볼 수 없게 되었습니다. 
 * 당첨 번호 발표 후, 민우는 자신이 구매했던 로또로 당첨이 가능했던 최고 순위와 최저 순위를 알아보고 싶어 졌습니다.
 * 알아볼 수 없는 번호를 0으로 표기하기로 하고, 민우가 구매한 로또 번호 6개가 44, 1, 0, 0, 31 25라고 가정해보겠습니다. 
 * 당첨 번호 6개가 31, 10, 45, 1, 6, 19라면, 당첨 가능한 최고 순위와 최저 순위의 한 예는 아래와 같습니다.
 */

public class codingTest42 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int cnt_zero = 0, cnt_dup=0; //0 갯수와 중복 갯수 구하기 위함
        
        for(int i=0; i<lottos.length; i++){
            if(lottos[i] == 0) cnt_zero++; //0이면 cnt_zero 증가
            for(int j=0; j<win_nums.length; j++){
                if(lottos[i] == win_nums[j]) cnt_dup++; //같은 수 있다면 cnt_dup 증가
            }
        }
        
        int[] answer = {cnt_zero+cnt_dup, cnt_dup}; 
        //낙서된 번호가 모두 로또번호와 맞다면 최고 순위의 경우, 가려진수가 로또 번호와 하나도 맞지 않다면 최저 순위의 경우임
        
        for(int i=0; i<2; i++){
            if(answer[i] == 6) answer[i] = 1;
            else if(answer[i] == 5) answer[i] = 2;
            else if(answer[i] == 4) answer[i]=3;
            else if(answer[i] == 3) answer[i] = 4;
            else if(answer[i] == 2) answer[i] = 5;
            else answer[i] = 6;
        }
        return answer;
    }


    /**
     * 다른사람 풀이
     * 
     *  public int[] solution(int[] lottos, int[] win_nums) {
            Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
            int zeroCount = 0;

            for(int lotto : lottos) {
                if(lotto == 0) { //민우 로또에서 0 존재 시 건너뜀
                    zeroCount++;
                    continue;
                }
                map.put(lotto, true); //0아니면 map에 넣음
            }


            int sameCount = 0;
            for(int winNum : win_nums) { //로또 번호랑 민우 로또 번호 비교
                if(map.containsKey(winNum)) sameCount++; // 같은 번호 카운트
            }

            int maxRank = 7 - (sameCount + zeroCount);
            int minRank = 7 - sameCount;
            if(maxRank > 6) maxRank = 6;
            if(minRank > 6) minRank = 6;

            return new int[] {maxRank, minRank};
        }
     */
}
