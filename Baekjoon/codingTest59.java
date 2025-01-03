package Baekjoon;

import java.util.*;
import java.io.*;

/*
 * 백준 1931번 회의실 배정
 * 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 
 * 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자. 
 * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 
 * 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
 * 
 */

class Time implements Comparable<Time> {
    public int start;
    public int end;

    Time(int s, int e) {
        this.start = s;
        this.end = e;
    }

    @Override
    public int compareTo(Time o) { // 종료 시간이 빠른 순서대로 정렬. 이때 종료 시간 동일 시, 빨리 시작하는 애가 먼저
        if (this.end == o.end) return this.start - o.start; 
        return this.end - o.end;
    }
}

public class codingTest59 {
    public int solution(int n, ArrayList<Time> arr) {
        Collections.sort(arr); // 정렬
        int cnt = 0; // 선택된 회의 수
        int e = 0;   // 이전 회의 종료 시간

        for (Time t : arr) {
            if (t.start >= e) { // 회의 시작 시간이 이전 종료 시간 이후라면
                cnt++;
                e = t.end;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        codingTest59 t = new codingTest59();

        int n = Integer.parseInt(br.readLine()); // 회의 개수 입력
        ArrayList<Time> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr.add(new Time(start, end));
        }

        System.out.println(t.solution(n, arr)); // 결과 출력
    }
}
