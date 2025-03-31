package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/* 
 * 백준 9012번 괄호
 * 
 * 괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는 문자열이다. 
 * 그 중에서 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다. 한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS 이라고 부른다. 
 * 만일 x 가 VPS 라면 이것을 하나의 괄호에 넣은 새로운 문자열 “(x)”도 VPS 가 된다. 그리고 두 VPS x 와 y를 접합(concatenation)시킨 새로운 문자열 xy도 VPS 가 된다. 
 * 예를 들어 “(())()”와 “((()))” 는 VPS 이지만 “(()(”, “(())()))” , 그리고 “(()” 는 모두 VPS 가 아닌 문자열이다. 
 * 여러분은 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다. 
 */

public class codingTest79 {
    static boolean isVPS(char[] arr){
        Stack<Character> sta = new Stack<>();

        if(arr[0] == ')') return false;

        sta.add(arr[0]);

        for(int i=1; i<arr.length; i++){
            if(arr[i] == '(') sta.add(arr[i]);
            else{
                if(sta.isEmpty()) return false;
                sta.pop();
            }
        }

        if(!sta.isEmpty()) return false;
        return true;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            char[] arr = br.readLine().toCharArray();
            if(isVPS(arr)) sb.append("YES"+"\n");
            else sb.append("NO"+"\n");
        }

        System.out.println(sb);
    }
}


/*
 * 
 * def isVPS(arr):
 *      if not arr :
 *          return False
 *      stack = []
 *      if s[0] ==')' return False
 *      stack.append(s[0])
 * 
 *      for c in arr[1:]:
 *          if c =='(': stack.append(c)
 *          else:
 *              if not stack:
 *                  return False
 *              stack.pop()
 *      return not stack
 * 
 * t = int(sys.stdin.readLind())
 * 
 * for _ in range(t):
 *   parens = sys.stdin.readline().rstrip('\n')
 *   print("YES" if isVPS(parens) else "NO")
 */