package progammers;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 프로그래머스 Lv.2 [1차] 뉴스클러스터링
 * 
 * 자카드 유사도는 집합 간의 유사도를 검사하는 여러 방법 중의 하나로 알려져 있다. 
 * 두 집합 A, B 사이의 자카드 유사도 J(A, B)는 두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈 값으로 정의된다.

예를 들어 집합 A = {1, 2, 3}, 집합 B = {2, 3, 4}라고 할 때, 교집합 A ∩ B = {2, 3}, 합집합 A ∪ B = {1, 2, 3, 4}이 되므로, 집합 A, B 사이의 자카드 유사도 J(A, B) = 2/4 = 0.5가 된다. 
집합 A와 집합 B가 모두 공집합일 경우에는 나눗셈이 정의되지 않으니 따로 J(A, B) = 1로 정의한다.

자카드 유사도는 원소의 중복을 허용하는 다중집합에 대해서 확장할 수 있다. 다중집합 A는 원소 "1"을 3개 가지고 있고, 
다중집합 B는 원소 "1"을 5개 가지고 있다고 하자. 이 다중집합의 교집합 A ∩ B는 원소 "1"을 min(3, 5)인 3개, 합집합 A ∪ B는 원소 "1"을 max(3, 5)인 5개 가지게 된다. 
다중집합 A = {1, 1, 2, 2, 3}, 다중집합 B = {1, 2, 2, 4, 5}라고 하면, 교집합 A ∩ B = {1, 2, 2}, 합집합 A ∪ B = {1, 1, 2, 2, 3, 4, 5}가 되므로, 자카드 유사도 J(A, B) = 3/7, 약 0.42가 된다.

이를 이용하여 문자열 사이의 유사도를 계산하는데 이용할 수 있다. 문자열 "FRANCE"와 "FRENCH"가 주어졌을 때, 
이를 두 글자씩 끊어서 다중집합을 만들 수 있다.
 각각 {FR, RA, AN, NC, CE}, {FR, RE, EN, NC, CH}가 되며, 교집합은 {FR, NC}, 합집합은 {FR, RA, AN, NC, CE, RE, EN, CH}가 되므로,
  두 문자열 사이의 자카드 유사도 J("FRANCE", "FRENCH") = 2/8 = 0.25가 된다.
 */

public class codingTest67 {
    public int solution(String str1, String str2) {
        ArrayList<String> multi1 = new ArrayList<>(); //A집합
        ArrayList<String> multi2 = new ArrayList<>(); //B집합
        ArrayList<String> union = new ArrayList<>(); //합집합
        ArrayList<String> intersection = new ArrayList<>(); //교집합
 
        str1 = str1.toLowerCase(); //대소문자 상관없다고 했으니 일단 소문자로 다 바꿔줌
        str2 = str2.toLowerCase();
        
        for(int i=0; i<str1.length()-1; i++){
            char first = str1.charAt(i);
            char second = str1.charAt(i+1);
            
            if(first >= 'a' && first <= 'z' && 
                second >= 'a' && second <= 'z'){ // 각각의 글자가 알파벳이면 추가해줌
                multi1.add(first + "" + second);
            }
        }
        for(int i=0; i<str2.length()-1; i++){
            char first = str2.charAt(i);
            char second = str2.charAt(i+1);
            
            if(first >= 'a' && first <= 'z' &&
                second >= 'a' && second <= 'z'){
                multi2.add(first + "" + second);
            }
        }
        
        Collections.sort(multi1);
        Collections.sort(multi2);
        
        for(String s : multi1){
            if(multi2.remove(s)){ //겹치는 문자들 삭제해줌
                intersection.add(s); //그리고 교집합에 넣어줌
            }
            union.add(s);
        }
        
        for(String s : multi2) union.add(s); //교집합에 들어가지 않은 multi2의 단어들 합집합에 넣어줌

        double answer = 0;

        if(union.size() == 0) answer=1;
        else answer = (double)intersection.size()/(double)union.size();
        
        
        return (int)(answer*65536);
    }

    /**
     * 다른사람 풀이
     * 
     * private static final Integer MULTIPLIER = Character.MAX_VALUE + 1;

    public int solution(String str1, String str2) {
        String word1 = str1.toLowerCase();
        String word2 = str2.toLowerCase();

        Map<String, Long> words1 = group(word1);
        Map<String, Long> words2 = group(word2);

        Integer intersection = getIntersection(words1, words2);
        Integer union = getUnion(words1, words2);

        if (intersection.equals(union) && union.equals(0)) {
            return MULTIPLIER;
        }

        return (int) (intersection.doubleValue() / union.doubleValue() * MULTIPLIER);
    }

    private Map<String, Long> group(String word) {
        return IntStream.range(0, word.length() - 1)
                .mapToObj(index -> word.substring(index, index + 2))
                .filter(text -> text.chars().allMatch(character -> Character.isAlphabetic((char) character)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private Integer getIntersection(Map<String, Long> words1, Map<String, Long> words2) {
        return words1.entrySet().stream()
                .filter(entry -> words2.containsKey(entry.getKey()))
                .map(entry -> Math.min(entry.getValue(), words2.get(entry.getKey())))
                .mapToInt(Long::intValue)
                .sum();
    }

    private Integer getUnion(Map<String, Long> words1, Map<String, Long> words2) {
        Map<String, Long> copiedWords = new HashMap<>(words2);
        words1.forEach((key, value) -> copiedWords.put(key, Math.max(value, words2.getOrDefault(key, 0L))));

        return copiedWords.values().stream()
                .mapToInt(Long::intValue)
                .sum();

    }
     */
}
