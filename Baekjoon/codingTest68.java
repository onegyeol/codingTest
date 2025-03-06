package Baekjoon;

import java.util.*;
import java.io.*;

/*
 * 백준 11000번 강의실 배정
 * 
 * 김종혜 선생님한테는 Si에 시작해서 Ti에 끝나는 N개의 수업이 주어지는데, 최소의 강의실을 사용해서 모든 수업을 가능하게 해야 한다. 
 * 참고로, 수업이 끝난 직후에 다음 수업을 시작할 수 있다. (즉, Ti ≤ Sj 일 경우 i 수업과 j 수업은 같이 들을 수 있다.
 */

class Time{
    int start;
    int end;

    public Time(int s, int e){
        this.start = s;
        this.end = e;
    }
}

public class codingTest68 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Time[] arr = new Time[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i] = new Time(a, b);
        }

        // 시작 시간으로 정렬 
        Arrays.sort(arr, (o1, o2) -> o1.start - o2.start);

        // 종료 시간 기준
        PriorityQueue<Integer> q = new PriorityQueue<>();

        // 먼저 시작하는 강의의 종료 시간
        q.add(arr[0].end);

        for(int i=1; i<n; i++){
            // 큐 peek의 강의 종료 시간보다 더 늦게 강의가 시작 -> 같은 강의실 사용 가능
            if(arr[i].start >= q.peek()){
                q.poll();
            }
            q.add(arr[i].end);
        }

        System.out.println(q.size());
    }
}
