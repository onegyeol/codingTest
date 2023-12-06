package section5;

import java.util.*;

/**
 * 첫 줄에 한 줄에 필수과목의 순서가 주어집니다. 모든 과목은 영문 대문자입니다.
 * 두 번 째 줄부터 현수가 짠 수업설계가 주어집니다.
 * 필수과목 순서대로 수업 설계가 이루어져야함.
 */

public class Test7 {
    public String solution(String es, String s){
        String answer ="NO";
        Queue<Character> q = new LinkedList<>();

        for(char i : es.toCharArray()) q.offer(i);
        for(char i : s.toCharArray()){
            if(q.isEmpty()) break; //큐가 피어있으면 peek()할 때 null 값이 나와서 오류가 나오기에 먼저 비어있는지 확인하기.
            if(i == q.peek()) q.remove(); // 순차적으로 강의를 들어야함. 
        }

        if(q.isEmpty()) answer="YES";

        return answer;
    }
    public static void main(String[] args) {
        Test7 t = new Test7();
        Scanner in = new Scanner(System.in);

        String essential_subject = in.next();
        String s = in.next();

        System.out.println(t.solution(essential_subject, s));
    }
}
