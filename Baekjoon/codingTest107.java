package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 백준 1021번 회전하는 큐
 * 
 * 지민이는 N개의 원소를 포함하고 있는 양방향 순환 큐를 가지고 있다. 지민이는 이 큐에서 몇 개의 원소를 뽑아내려고 한다.
 * 지민이는 이 큐에서 다음과 같은 3가지 연산을 수행할 수 있다.

첫 번째 원소를 뽑아낸다. 이 연산을 수행하면, 원래 큐의 원소가 a1, ..., ak이었던 것이 a2, ..., ak와 같이 된다.
왼쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 a2, ..., ak, a1이 된다.
오른쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 ak, a1, ..., ak-1이 된다.

 * 큐에 처음에 포함되어 있던 수 N이 주어진다. 그리고 지민이가 뽑아내려고 하는 원소의 위치가 주어진다. (이 위치는 가장 처음 큐에서의 위치이다.) 이때, 그 원소를 주어진 순서대로 뽑아내는데 드는 2번, 3번 연산의 최솟값을 출력하는 프로그램을 작성하시오.
 */

public class codingTest107 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m];
        Deque<Integer> de = new LinkedList();
        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++){
            de.add(i);
        }

        
        for(int i=0; i<m; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer=0;
        for(int target:arr){
            int idx=0;

            for(int num:de){
                if(num==target) break;
                idx++;  // 찾아야할 숫자의 인덱스 위치부터 구함
            }

            // 인덱스 기준 중간 값보다 작으면 2번 연산
            if(idx <= de.size()/2){
                while(de.peekFirst() != target){
                    de.addLast(de.removeFirst());
                    answer++;
                }
            }
            // 인덱스 기준 중간 값보다 크면 3번 연산
            else{
                while(de.peekFirst() != target){
                    de.addFirst(de.removeLast());
                    answer++;
                }
            }

            de.pollFirst();
        }

        System.out.println(answer);

        
    }
}
