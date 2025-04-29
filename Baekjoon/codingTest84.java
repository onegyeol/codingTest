package Baekjoon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * 백준 11286번 절댓값 힙
 * 
 * 첫째 줄에 연산의 개수 N(1≤N≤100,000)이 주어진다. 다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다. 
 * 만약 x가 0이 아니라면 배열에 x라는 값을 넣는(추가하는) 연산이고, x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다.
 */

public class codingTest84 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = in.nextInt();

        PriorityQueue<Integer> que = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                if(Math.abs(o1)>Math.abs(o2)){
                    return Math.abs(o1)-Math.abs(o2);
                } else if(Math.abs(o1) == Math.abs(o2)){
                    return o1-o2;
                } else{
                    return -1;
                }
            }
        });
        
        for(int i=0; i<n; i++){
            int tmp = in.nextInt();

            if(tmp == 0){
                if(que.isEmpty()) sb.append("0\n");
                else sb.append((que.poll()).toString() + "\n");
            }
            else{
                que.offer(tmp);
            }
        }

        System.out.println(sb);
    }
}
