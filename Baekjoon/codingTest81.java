package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 백준 17298번 오큰수
 * 
 * 크기가 N인 수열 A = A1, A2, ..., AN이 있다. 수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구하려고 한다. Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다. 그러한 수가 없는 경우에 오큰수는 -1이다.

예를 들어, A = [3, 5, 2, 7]인 경우 NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1이다. A = [9, 5, 4, 8]인 경우에는 NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1이다.
 */

public class codingTest81 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> sta = new Stack<>();

        for(int i=0; i<n; i++){
            while(!sta.isEmpty() && arr[sta.peek()]<arr[i]){
                arr[sta.pop()] = arr[i];
            }

            sta.add(i); // 인덱스 값을 스택에 넣음
        }

        while(!sta.isEmpty()){
            arr[sta.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();

        for(int i: arr)
            sb.append(i + " ");

        System.out.println(sb);

        
    }
}

/*
 *
 * import sys
 *  
 * def main():
 *   n = int(sys.stdin.readline())    
 *   arr = list(map(int, sys.stdin.readline().split()))
 * 
 *   stack = []
 * 
 *   for i in range(n):
 *      while stack and arr[stack[-1]] < arr[i]:
 *          idx = stack.pop()
 *          arr[idx] = arr[i]
 *      stack.append(i)
 * 
 *   while stack:
 *      idx = staac.pop()
 *      arr[idx] = -1
 * 
 *   print(' '.join(map(str, arr)))
 *   
 * 
 * if __name__ == "__main__" :
 *    main()
 */