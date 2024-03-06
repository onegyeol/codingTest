package progammers;

import java.util.Arrays;

/**
 * 프로그래머스 Lv.2 전화번호 목록
 * 
 * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.

구조대 : 119
박준영 : 97 674 223
지영석 : 11 9552 4421
전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 
어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 */

public class codingTest66 {

     public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book); //정렬안하고 이중 반복문 돌리면 시간복잡도가  o(n^2)가 되버려서 효율성이 떨어짐. 꼭 정렬해주기

        for(int i=0; i<phone_book.length-1; i++){
            String str = phone_book[i];
            if(phone_book[i+1].startsWith(str)) return false; //접두사이기 때문에 startsWith 메서드를 사용해줌.
            
        }
        
        return true;
    }

    /**
     * 다른 사람 코드
     * 
     * public boolean solution(String[] phoneBook) {
        boolean answer = true;

            Map<String, Integer> map = new HashMap<>();

            for(int i = 0; i < phoneBook.length; i++) {
                map.put(phoneBook[i], i);
            }


            for(int i = 0; i < phoneBook.length; i++) {
                for(int j = 0; j < phoneBook[i].length(); j++) {
                    if(map.containsKey(phoneBook[i].substring(0,j))) { //자기 자신을 제외하기 위해 substring(0, j)를 사용함
                        answer = false;
                        return answer;
                    }
                }
            }




            return answer;
    }
     */
    
}
