package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/*
 * 백준 5430번 AC
 * 
 * 선영이는 주말에 할 일이 없어서 새로운 언어 AC를 만들었다. AC는 정수 배열에 연산을 하기 위해 만든 언어이다. 이 언어에는 두 가지 함수 R(뒤집기)과 D(버리기)가 있다.
 * 함수 R은 배열에 있는 수의 순서를 뒤집는 함수이고, D는 첫 번째 수를 버리는 함수이다. 배열이 비어있는데 D를 사용한 경우에는 에러가 발생한다.
 * 함수는 조합해서 한 번에 사용할 수 있다. 예를 들어, "AB"는 A를 수행한 다음에 바로 이어서 B를 수행하는 함수이다. 예를 들어, "RDD"는 배열을 뒤집은 다음 처음 두 수를 버리는 함수이다.
 * 배열의 초기값과 수행할 함수가 주어졌을 때, 최종 결과를 구하는 프로그램을 작성하시오.
 * 
 */

public class codingTest62 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            String func = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();

            Deque<Integer> deque = new LinkedList<>();
            if(n>0){
                arr = arr.substring(1, arr.length()-1); // [] 없애기 위함
                String[] elements = arr.split(",");
                for(String element : elements){
                    deque.add(Integer.parseInt(element.trim())); // 앞 뒤 공백제거
                }
            }

            boolean reverse = false;
            boolean error = false;
            
            for(int j=0; j<func.length(); j++){
                if(func.charAt(j) == 'R'){
                    reverse = !reverse;
                }
                else{
                    if(deque.isEmpty()) {
                        sb.append("error\n");
                        error = true;
                        break;
                    }
                    if(reverse) deque.pollLast();
                    else deque.pollFirst();
                }
            }

            if(!error){
                sb.append(formatDeque(deque, reverse)+("\n"));
            }


        }
        System.out.println(sb);
    }

    static String formatDeque(Deque<Integer> deque, boolean reverse){ // 출력 형태로 변환
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        if(reverse){
            while(!deque.isEmpty()){
                sb.append(deque.pollLast());
                if(!deque.isEmpty()) sb.append(",");
            }
        }
        else{
            while(!deque.isEmpty()){
                sb.append(deque.pollFirst());
                if(!deque.isEmpty()) sb.append(",");
            }
        }

        sb.append("]");

        return sb.toString();
    }

    
}
