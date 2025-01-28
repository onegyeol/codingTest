package Baekjoon;

import java.util.*;

/*
 * 백준 1655번 가운데를 말해요
 * 백준이는 동생에게 "가운데를 말해요" 게임을 가르쳐주고 있다. 
 * 백준이가 정수를 하나씩 외칠때마다 동생은 지금까지 백준이가 말한 수 중에서 중간값을 말해야 한다. 
 * 만약, 그동안 백준이가 외친 수의 개수가 짝수개라면 중간에 있는 두 수 중에서 작은 수를 말해야 한다.

예를 들어 백준이가 동생에게 1, 5, 2, 10, -99, 7, 5를 순서대로 외쳤다고 하면, 동생은 1, 1, 2, 2, 2, 2, 5를 차례대로 말해야 한다. 
백준이가 외치는 수가 주어졌을 때, 동생이 말해야 하는 수를 구하는 프로그램을 작성하시오.
 */

public class codingTest64 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();// 중간값보다 큰 애들
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder()); //중간값보다 작은 애들 + 중간값

        int n = in.nextInt();

        for(int i=0; i<n; i++){
            int x = in.nextInt();

            // 중간값보다 작으면 maxHeap에 넣음
            if (maxHeap.isEmpty() || x <= maxHeap.peek()) {  
                maxHeap.offer(x);  
            } else { // 중간값보다 크면 minHeap에 넣음
                minHeap.offer(x);  
            }  
  
            // 두수 중 작은 수를 출력하기에 최소 힙 크기 +1 로 설정함
            // 최대 힙의 크기가 최소 힙의 크기 + 1보다 클 경우, 최대 힙의 루트를 최소 힙으로 이동  
            if (maxHeap.size() > minHeap.size() + 1) {  
                minHeap.offer(maxHeap.poll());  
            } else if (minHeap.size() > maxHeap.size()) {  
                maxHeap.offer(minHeap.poll());  
            }  
            sb.append(String.valueOf(maxHeap.peek()) + "\n");
        }

        System.out.println(sb);
    }
}
