package progammers;

import java.util.*;

/**Lv.1 소수 찾기
 * 
 * 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.

소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
(1은 소수가 아닙니다.)
 */

public class codingTest35 {
    public int solution(int n) {
        int answer = 1; //2는 무조건 소수이기 때문
        
        for(int i=3; i<=n; i++){
            if(isPrime(i)) answer++;
        }
        return answer;
    }
    
    public boolean isPrime(int n){
        for(int i=2; i<=(int)Math.sqrt(n); i++){
            if(n % i == 0) return false; //1제외하고 나눠지는 수가 있으면 소수 아님
        }
        
        return true;
    }
}
