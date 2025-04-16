package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 백준 2504번
 * 
 * 예를 들어 ‘(()[[]])’나 ‘(())[][]’ 는 올바른 괄호열이지만 ‘([)]’ 나 ‘(()()[]’ 은 모두 올바른 괄호열이 아니다. 우리는 어떤 올바른 괄호열 X에 대하여 그 괄호열의 값(괄호값)을 아래와 같이 정의하고 값(X)로 표시한다.

‘()’ 인 괄호열의 값은 2이다.
‘[]’ 인 괄호열의 값은 3이다.
‘(X)’ 의 괄호값은 2×값(X) 으로 계산된다.
‘[X]’ 의 괄호값은 3×값(X) 으로 계산된다.
올바른 괄호열 X와 Y가 결합된 XY의 괄호값은 값(XY)= 값(X)+값(Y) 로 계산된다.

 * 예를 들어 ‘(()[[]])([])’ 의 괄호값을 구해보자. ‘()[[]]’ 의 괄호값이 2 + 3×3=11 이므로 ‘(()[[]])’의 괄호값은 2×11=22 이다. 그리고 ‘([])’의 값은 2×3=6 이므로 전체 괄호열의 값은 22 + 6 = 28 이다.
 * 여러분이 풀어야 할 문제는 주어진 괄호열을 읽고 그 괄호값을 앞에서 정의한대로 계산하여 출력하는 것이다.
 * 
 */
public class codingTest83 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        Stack<Character> sta = new Stack<>();

        int answer=0;
        int tmp=1;

        L1: for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);

            switch(c){
                case '(' :
                    sta.push('(');
                    tmp *= 2;
                    break;
                case '[':
                    sta.push('[');
                    tmp *= 3;
                    break;
                case ')':
                    if(sta.isEmpty() || sta.peek()!='('){
                        answer=0;
                        break L1;
                    }
                    else {
                        if(str.charAt(i-1) == '(') answer += tmp;
                        sta.pop();
                        tmp/=2;
                    }
                    break;
                case ']':
                    if(sta.isEmpty() || sta.peek()!='['){
                        answer=0;
                        break L1;
                    }
                    else {
                        if(str.charAt(i-1) == '[') answer += tmp;
                        sta.pop();
                        tmp/=3;
                    }
                    break;
            }

        }

        
        if(!sta.isEmpty()) System.out.println(0);
        else System.out.println(answer);

    }
}

/*
 * def solve(exp:str) -> int:
 *  stack=[]
 *  answer=0
 *  tmp=1
 * 
 *  for i in range(len(expr)):
 *      char = expr[i]
 *  
 *      if char == '(':
 *          stack.append('(')
 *          tmp*=2
 *      elif char == '[':
 *          stack.append('[')
 *          tmp*=3
 *      elif char == ')':
 *          if not stack or expr[-1] != '(':
 *              return 0
 *          elif i>0 and expr[-1] == '(':
 *              answer += tmp
 *          stack.pop()
 *          tmp //= 2
 *      elif char == ']':
 *          if not stack or expr[-1] != ']':
 *              return 0
 *          elif i>0 and expr[-1] == ']':
 *              answer += tmp
 *          stack.pop()
 *          tmp //= 3
 * 
 *  if stack:
 *      return 0
 *  return answer
 * 
 * if __name__ == "__main__":
 *  expression = input().strip()
 *  print(solve(expression))
 */