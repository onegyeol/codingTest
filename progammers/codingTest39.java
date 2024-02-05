package progammers;

import java.util.*;

/**
 * Lv.1 [1차] 다트게임
 * 
 * 1. 다트 게임은 총 3번의 기회로 구성된다.
 * 2. 각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
 * 3. 점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
 * 4. 옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다.
 * 5. 스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
 * 6. 스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
 * 7. 스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
 * 8. Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
 * 9. 스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
 * 
 * 0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.
 */

public class codingTest39 {

    public int solution(String dartResult) {
        int answer = 0;
        char[] dart = dartResult.toCharArray();
        int[] score = new int[3];
        int cnt=0;
        String s = "";
        
        for(int i=0; i<dart.length; i++){
            
            if(Character.isDigit(dart[i])){ //숫자라면
                s += Character.toString(dart[i]);
            }
            else if(dart[i] == '#'){
                score[cnt-1] *= -1;
            }
            else if(dart[i] == '*'){
                if(cnt == 1) score[cnt-1] *= 2;
                else{
                    score[cnt-2] *= 2;
                    score[cnt-1] *= 2;
                }
            }
            else { //숫자 아닐 때
                if(dart[i] == 'S'){
                    score[cnt] = (int) Math.pow(Integer.parseInt(s), 1); //거듭제곱 구할 수 있는 메소드
                }
                else if(dart[i] == 'D'){
                    score[cnt] = (int) Math.pow(Integer.parseInt(s), 2);
                }
                else if(dart[i] == 'T'){
                    score[cnt] = (int) Math.pow(Integer.parseInt(s), 3);
                }
                cnt++;  
                s= "";
            }

        }
        
        for(int k : score){
            answer += k;
        }
        
        return answer;
    }

    /**다른 사람 풀이
     * 
     * public int solution(String dartResult) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < dartResult.length(); ++i) {
            char c = dartResult.charAt(i);
            if (Character.isDigit(c)) {
                sum = (c - '0'); //char to int
                if (sum == 1 && i < dartResult.length() - 1 && dartResult.charAt(i + 1) == '0') { //10일때 따로 처리
                    sum = 10;
                    i++;
                }
                stack.push(sum);
            } else {
                int prev = stack.pop(); //숫자 꺼냄
                if (c == 'D') {
                    prev *= prev;
                } else if (c == 'T') {
                    prev = prev * prev * prev;
                } else if (c == '*') {
                    if (!stack.isEmpty()) { //제일 처음에 *가 있는게 아니라면
                        int val = stack.pop() * 2;
                        stack.push(val);
                    }
                    prev *= 2;
                } else if (c == '#') {
                    prev *= (-1);
                }
                // System.out.println(prev);
                stack.push(prev);
            }
        }
        int totalScore = 0;
        while (!stack.isEmpty()) {
            totalScore += stack.pop();
        }
        return totalScore;
    }
     */
}
