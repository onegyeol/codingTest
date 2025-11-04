package progammers;

/*
 * 프로그래머스 Lv.2 마법의 엘리베이터
 * 
 * 민수와 마법의 엘리베이터가 있는 층을 나타내는 정수 storey 가 주어졌을 때, 0층으로 가기 위해 필요한 마법의 돌의 최소값을 return 하도록 solution 함수를 완성하세요.
 */

public class codingTesr123 {
    public static void main(String[] args) {
        // storey 입력 받음
    }

    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0){
            // 젤 뒷자릿수 구함
            int num = storey % 10;
            // 그 앞의 나머지 수
            storey /= 10;
            
            if(num > 5){
                // 5보다 크다면 올려서 다음 자리에서 처리하는게 이득
                answer += 10-num;
                // 다음 자릿수 증가
                storey++;
            }
            else if(num < 5){
                // 5보다 작으면 내려가는 것이 이득
                answer += num;
            }
            else if(storey%10 >= 5){
                // 다음 자리(앞자리)의 숫자가 5 이상이면 → 5를 올려서 처리 (storey++)
                answer += 5;
                storey++;
            }
            else{
                // 그렇지 않으면 → 그냥 내려서 처리
                answer += 5;
            }
            
        }
        return answer;
    }
}
