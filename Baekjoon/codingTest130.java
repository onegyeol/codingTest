package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
백준 1269번 대칭 차집합

자연수를 원소로 갖는 공집합이 아닌 두 집합 A와 B가 있다. 
이때, 두 집합의 대칭 차집합의 원소의 개수를 출력하는 프로그램을 작성하시오. 
두 집합 A와 B가 있을 때, (A-B)와 (B-A)의 합집합을 A와 B의 대칭 차집합이라고 한다.

예를 들어, A = { 1, 2, 4 } 이고, B = { 2, 3, 4, 5, 6 } 라고 할 때,  
A-B = { 1 } 이고, B-A = { 3, 5, 6 } 이므로, 대칭 차집합의 원소의 개수는 1 + 3 = 4개이다.

*/

public class codingTest130 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 집합 A, B 개수 
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();

        // 집합 A, B 값
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<a; i++){
            A.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<b; i++){
            B.add(Integer.parseInt(st.nextToken()));
        }

        // 차집합
        int diff = 0;

        for(int tmp : A){
            if(B.contains(tmp)) diff++;
        }
        
        // 각 집합에 들어있기에 차집합 수 * 2
        int answer = A.size()+B.size() - (2*diff);

        System.out.println(answer);


    }
}
