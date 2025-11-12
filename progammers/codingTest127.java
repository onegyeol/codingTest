package progammers;

/*
 * 프로그래머스 Lv.2 124 나라의 숫자
 * 
 * 124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다,
 * 124 나라에는 자연수만 존재합니다.
 * 124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.
 * 예를 들어서 124 나라에서 사용하는 숫자는 다음과 같이 변환됩니다.
 * 
 * 10진법	124 나라	10진법	124 나라
    1	    1	        6	    14
    2	    2	        7	    21
    3	    4	        8	    22
    4	    11	        9	    24
    5	    12	        10	    41
 */

public class codingTest127 {
    public static void main(String[] args) {
        // n입력 받음
    }

    public String solution(int n) {
        String[] numbers = {"4", "1", "2"};
        String answer = "";
        
        while(n>0){
            // 3으로 나눈 나머지가 1, 2일때 각각 인덱스로 연결
            int remain = n%3;
            n /= 3;
            
            // 나눠떨어질 경우 -1을 해서 이전 숫자가 더해지도록 함
            /*
             * 6의 경우
             * 6%3 == 0 -> 맨 뒤에 4가 붙음
             * 6/3 = 2 -> 하지만 첫째자리는 2가 아닌 1이 되어야 함. 즉 -1을 해주면 됨
             */
            if(remain == 0) n--;
            
            answer = numbers[remain] + answer;
            
        }
        return answer;
    }
}
