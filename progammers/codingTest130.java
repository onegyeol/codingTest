package progammers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 프로그래머스 Lv.3 베스트 앨범
 * 
 * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 * 
 * 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 * 
 * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 */

public class codingTest130 {
    public static void main(String[] args) {
        
    }
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        // 재생 횟수 총 합계
        Map<String, Integer> genrePlaySum = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            genrePlaySum.put(genres[i], genrePlaySum.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // 각 재생 횟수, 고유 번호 
        Map<String, List<int[]>> genreSongs = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            genreSongs.computeIfAbsent(genres[i], k -> new ArrayList<>())
                .add(new int[]{plays[i], i});
        }
        
        for(String genre : genreSongs.keySet()){
            genreSongs.get(genre).sort((a, b) -> {
                if(a[0] != b[0]) return b[0]-a[0]; // 재생횟수 내림차순
                return a[1]-b[1]; // 재생횟수가 동일하다면, 고유 번호 오름차순
            });
        }
        
        List<String> genreOrder = new ArrayList<>(genrePlaySum.keySet());
        genreOrder.sort((a, b) -> genrePlaySum.get(b) - genrePlaySum.get(a)); // 내림차순 정렬
        
        int cnt=0;
        for(String genre : genreOrder){
            List<int[]> list = genreSongs.get(genre);
            
            answer.add(list.get(0)[1]);
            
            if(list.size()>1){
                answer.add(list.get(1)[1]);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
