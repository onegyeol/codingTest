package progammers;


/**
 * Lv.2 주식가격
 * 
 * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
 */

public class codingTest73 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> sta = new Stack<>(); //인덱스를 스택의 값으로 사용함
        
        for(int i=0; i<prices.length; i++){
            while(!sta.isEmpty() && prices[sta.peek()] > prices[i]){
                answer[sta.peek()] = i - sta.peek();
                sta.pop();
            }
            sta.push(i); 
        }
        
        while(!sta.isEmpty()){
            answer[sta.peek()] = prices.length - sta.pop() - 1; //배열의 길이는 인덱스 값 -1 이기때문
        }
        return answer;
    }

   
    
}
