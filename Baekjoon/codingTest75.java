package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 *  백준 2812번 크게 만들기
 * 
 *  N자리 숫자가 주어졌을 때, 여기서 숫자 K개를 지워서 얻을 수 있는 가장 큰 수를 구하는 프로그램을 작성하시오.
 * 
 */
public class codingTest75 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String s = br.readLine();
        char[] arr = s.toCharArray();
        Stack<Integer> sta = new Stack<>(); // 작은 숫자를 찾아서 스택에서 지움
        int count=0;

        for(int i=0; i<n; i++){
            while(!sta.isEmpty() && sta.peek()<arr[i]-'0' && count<k){
                sta.pop();
                count++;
            }
            sta.push(arr[i]-'0');
        }

        /*
         * 7 3

         * 3222222

         * ans) 3222
         */
        while(count < k){
            sta.pop();
            count++;
        }

        StringBuilder sb = new StringBuilder();

        for(int val : sta){
            sb.append(val);
        }

        System.out.println(sb);
    }
}

/*
 파이썬 코드

    def solve():
        n, k = map(int, input().split())
        s = input()
        stack = []

        for char in s:
            while stack and stack[-1] < int(char) and k > 0:
                stack.pop()
                k -= 1
            stack.append(int(char))

        while k > 0:
            stack.pop()
            k -= 1

        result = ''.join(map(str, stack))
        print(result)

    if __name__ == "__main__":
        solve()

 */