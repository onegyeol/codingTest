package progammers;

import java.util.HashMap;

/** 프로그래머스 Lv.2 할인 행사
 * 
 * XYZ 마트는 일정한 금액을 지불하면 10일 동안 회원 자격을 부여합니다. 
 * XYZ 마트에서는 회원을 대상으로 매일 한 가지 제품을 할인하는 행사를 합니다. 
 * 할인하는 제품은 하루에 하나씩만 구매할 수 있습니다. 
 * 알뜰한 정현이는 자신이 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우에 맞춰서 회원가입을 하려 합니다.
 * 
 * XYZ 마트는 일정한 금액을 지불하면 10일 동안 회원 자격을 부여합니다. 
 * XYZ 마트에서는 회원을 대상으로 매일 한 가지 제품을 할인하는 행사를 합니다. 
 * 할인하는 제품은 하루에 하나씩만 구매할 수 있습니다. 
 * 알뜰한 정현이는 자신이 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우에 맞춰서 회원가입을 하려 합니다.
 */

public class codingTest55 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>(); //Hashmap 통해 원하는 제품과 수량 동시 저장
        
        for(int i=0; i<=discount.length-10; i++){
            for(int k=0; k<want.length; k++){
                map.put(want[k], number[k]);
            }
        
            for(int j=i; j<i+10; j++){
                if(map.containsKey(discount[j])){ 
                    int n = map.get(discount[j]);
                    if(n-1 == 0) map.remove(discount[j]);
                    else map.put(discount[j], n-1);
                }
            }
            if(map.isEmpty()) answer++; //map이 비어있다면 원하는 품목을 다 샀단 의미
        }
        return answer;
    }
}
