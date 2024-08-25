package Baekjoon;

import java.util.*;
import java.io.*;

/* 
백준 2042 번 구간 합 구하기
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)과 M(1 ≤ M ≤ 10,000), K(1 ≤ K ≤ 10,000) 가 주어진다. M은 수의 변경이 일어나는 횟수이고, 
 * K는 구간의 합을 구하는 횟수이다. 그리고 둘째 줄부터 N+1번째 줄까지 N개의 수가 주어진다. 
 * 그리고 N+2번째 줄부터 N+M+K+1번째 줄까지 세 개의 정수 a, b, c가 주어지는데, 
 * a가 1인 경우 b(1 ≤ b ≤ N)번째 수를 c로 바꾸고 a가 2인 경우에는 b(1 ≤ b ≤ N)번째 수부터 c(b ≤ c ≤ N)번째 수까지의 합을 구하여 출력하면 된다.

입력으로 주어지는 모든 수는 -263보다 크거나 같고, 263-1보다 작거나 같은 정수이다.
 */

public class codingTest24 {

    static long[] arr; // 원본 배열
    static long[] tree; // 세그먼트 트리 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Long> answer = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new long[n + 1]; // 입력된 배열 (1-based index)
        tree = new long[4 * n]; // 세그먼트 트리 배열

        // 입력 값 저장
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        // 세그먼트 트리 생성
        init(1, n, 1);

        // m + k개의 쿼리 처리
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (type == 1) { // 값 변경
                long diff = c - arr[b];
                arr[b] = c;
                update(1, n, 1, b, diff);
            } else if (type == 2) { // 구간 합 계산
                answer.add(sum(1, n, 1, b, (int) c));
            }
        }

        for(long i : answer){
            System.out.println(i);
        }
    }

    // 세그먼트 트리 초기화
    static long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    // 특정 범위의 합 구하기
    static long sum(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    // 세그먼트 트리 업데이트
    static void update(int start, int end, int node, int idx, long diff) {
        if (idx < start || idx > end) {
            return;
        }

        tree[node] += diff;

        if (start != end) {
            int mid = (start + end) / 2;
            update(start, mid, node * 2, idx, diff);
            update(mid + 1, end, node * 2 + 1, idx, diff);
        }
    }
}
