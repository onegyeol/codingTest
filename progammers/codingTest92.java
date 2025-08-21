package progammers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * 프로그래머스 2023 KAKAO BLIND RECRUITMENT-개인정보 수집 유효기간

 */

public class codingTest92 {
    public static void main(String[] args) {
        System.out.println();
    }

    static ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        // 현재 날짜 매핑
        int todayYear = Integer.parseInt(today.substring(0, 4));
        int todayMonth = Integer.parseInt(today.substring(5, 7));
        int todayDay = Integer.parseInt(today.substring(8, 10));

        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] parts = term.split(" ");
            termMap.put(parts[0], Integer.parseInt(parts[1]));
        }

        // privacies 처리
        for (int i = 0; i < privacies.length; i++) {
            String[] parts = privacies[i].split(" ");
            
            // 약관
            String date = parts[0];
            String termType = parts[1];

            int year = Integer.parseInt(date.substring(0, 4));
            int month = Integer.parseInt(date.substring(5, 7));
            int day = Integer.parseInt(date.substring(8, 10));

            // 약관 개월 수 더하기
            int termMonths = termMap.get(termType);
            month += termMonths;

            // month가 12 넘어갈 경우 보정
            year += (month - 1) / 12;
            month = (month - 1) % 12 + 1;

            // 만료일 = 계산된 날짜 - 1일
            day -= 1;
            if (day == 0) {
                month -= 1;
                if (month == 0) {
                    year -= 1;
                    month = 12;
                }
                day = 28; 
            }

            // 오늘 날짜와 비교
            if (compare(todayYear, todayMonth, todayDay, year, month, day)) {
                answer.add(i + 1);
            }
        }

        return answer;
    }

    static boolean compare(int tY, int tM, int tD, int y, int m, int d) {
        if (tY > y) return true;
        if (tY == y && tM > m) return true;
        if (tY == y && tM == m && tD > d) return true;
        return false;
    }
}
