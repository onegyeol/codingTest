package progammers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
프그래머스 Lv.3 2020 카카오 인턴십 보석 쇼핑

개발자 출신으로 세계 최고의 갑부가 된 어피치는 스트레스를 받을 때면 이를 풀기 위해 오프라인 매장에 쇼핑을 하러 가곤 합니다.
어피치는 쇼핑을 할 때면 매장 진열대의 특정 범위의 물건들을 모두 싹쓸이 구매하는 습관이 있습니다.
어느 날 스트레스를 풀기 위해 보석 매장에 쇼핑을 하러 간 어피치는 이전처럼 진열대의 특정 범위의 보석을 모두 구매하되 특별히 아래 목적을 달성하고 싶었습니다.
진열된 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간을 찾아서 구매

예를 들어 아래 진열대는 4종류의 보석(RUBY, DIA, EMERALD, SAPPHIRE) 8개가 진열된 예시입니다.
*/

public class codingTest140 {
    public static void main(String[] args) {
        // gems 입력받음
    }

    public int[] solution(String[] gems) {
        Set<String> gemsType = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> map = new HashMap<>();

        int left = 0;
        int minlen = Integer.MAX_VALUE;
        int[] answer = { 1, gems.length };

        for (int right = 0; right < gems.length; right++) {
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);

            while (map.size() == gemsType.size()) {
                if (right - left < minlen) {
                    minlen = right - left;
                    // answer의 답은 1부터 시작하기에
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                }

                map.put(gems[left], map.get(gems[left]) - 1);

                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                left++;
            }
        }

        return answer;
    }

}
