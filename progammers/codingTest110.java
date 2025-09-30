package progammers;

/*
 * 프로그래머스 Lv.2 2개 이하로 다른 비트
 */

public class codingTest110 {
    public static void main(String[] args) {
        
    }

    static long[] solution(long[] numbers) {
        int len = numbers.length;
        long[] answer = new long[len];
        
        for(int i=0; i<len; i++){
            long num = numbers[i];
            
            // 짝수는 무조건 맨 오른쪽이 0이기에 -> +1
            if(num%2==0){
                answer[i] = num+1;
            } else{
                // 홀수 비트를 짝수 비트로 바꿔준 뒤 시프트 연산 (최대 2개만 다르도록 해줘야 하기엦)
                long bit = (num ^ (num+1)) >> 2;
                answer[i] = num+1+bit;
            }
        }
        return answer;
    }
}
