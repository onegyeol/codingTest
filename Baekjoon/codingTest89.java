package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 15903번 카드 합체 놀이
 * 
 * x번 카드와 y번 카드를 골라 그 두 장에 쓰여진 수를 더한 값을 계산한다. (x ≠ y)
 * 계산한 값을 x번 카드와 y번 카드 두 장 모두에 덮어 쓴다.
 * 
 * 이 카드 합체를 총 m번 하면 놀이가 끝난다. m번의 합체를 모두 끝낸 뒤, n장의 카드에 쓰여있는 수를 모두 더한 값이 이 놀이의 점수가 된다. 이 점수를 가장 작게 만드는 것이 놀이의 목표이다.
 * 만들 수 있는 가장 작은 점수를 계산하는 프로그램을 만들어보자.
 */

public class codingTest89 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            pq.add(Long.parseLong(st.nextToken()));
        }

        for(int i=0; i<m; i++){
            Long tmp1 = pq.poll();
            Long tmp2 = pq.poll();

            pq.add(tmp1+tmp2);
            pq.add(tmp1+tmp2);
        }

        long answer = 0;
        while(!pq.isEmpty()){
            answer += pq.poll();
        }
        System.out.println(answer);
    }
}
