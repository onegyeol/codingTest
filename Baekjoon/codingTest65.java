package Baekjoon;

import java.io.*;
import java.util.*;

/*
 * 백준 1918번 후위 표기식
 * 
 * 중위 표기식이 주어졌을 때 후위 표기식으로 고치는 프로그램을 작성하시오.
 * 첫째 줄에 중위 표기식이 주어진다. 단 이 수식의 피연산자는 알파벳 대문자로 이루어지며 수식에서 한 번씩만 등장한다. 
 * 그리고 -A+B와 같이 -가 가장 앞에 오거나 AB와 같이 *가 생략되는 등의 수식은 주어지지 않는다. 
 * 표기식은 알파벳 대문자와 +, -, *, /, (, )로만 이루어져 있으며, 길이는 100을 넘지 않는다. 
 */

public class codingTest65 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            StringBuilder sb = new StringBuilder();

            String s = in.next();
            Stack<Character> stack = new Stack<>(); 

            for(int i=0; i<s.length(); i++){
                char tmp = s.charAt(i);

                switch(tmp){
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                        while(!stack.isEmpty() && priority(stack.peek()) >= priority(tmp)){ // 우선순위가 높을수록
                            sb.append(stack.pop());
                        }
                        stack.add(tmp);
                        break;
                    case '(': 
                        stack.add(tmp);
                        break;
                    case ')':
                        while(!stack.isEmpty() && stack.peek() != '('){
                            sb.append(stack.pop());
                        }
                        stack.pop(); // ( 제거
                        break;
                    default: 
                        sb.append(tmp);
                }
            }

            while(!stack.isEmpty()) sb.append(stack.pop());

            System.out.println(sb);
            
            
        }

        static int priority(char c){
            if(c==')' || c=='(') return 0;
            else if(c=='+' || c=='-') return 1;
            else if(c=='*' || c=='/') return 2;

            return -1;
        }
}
