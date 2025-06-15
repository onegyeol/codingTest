package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 1275번 커피숍2
 * 
 * 첫째 줄에 수의 개수 N과 턴의 개수 Q가 주어진다.(1 ≤ N, Q ≤ 100,000) 둘째 줄에는 처음 배열에 들어가 있는 정수 N개가 주어진다. 세 번째 줄에서 Q+2번째 줄까지는 x y a b의 형식으로 x~y까지의 합을 구하여라, a번째 수를 b로 바꾸어라 라는 뜻의 데이터가 주어진다.
 */

public class codingTest98 {
    static long[] arr;
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        arr = new long[n+1];
        tree = new long[4*n];

        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        init(1, n, 1);

        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(sum(1, n, 1, Math.min(x, y), Math.max(x, y)) + "\n");

            update(1, n, 1, a, b);
        }

        System.out.println(sb);
    }

    // 트리 초기화
    static long init(int start, int end, int node){
        if(start==end){
            return tree[node] = arr[start];
        }

        int mid = (start+end)/2;

        return tree[node]=init(start, mid, node*2)+init(mid+1, end, node*2 +1);
    }

    // 합 
    static long sum(int start, int end, int node, int left, int right){
        if(left>end ||  right<start) return 0;
        if(left<=start && end<= right) return tree[node];

        int mid=(start+end)/2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    // 업데이트
    static void update(int start, int end, int node, int idx, long val){
        if (idx < start || idx > end) return;
    
        if (start == end) { // idx 노드 값 변경
            tree[node] = val;
            arr[idx] = val;
            return;
        }
    
        int mid = (start + end) / 2;
        update(start, mid, node * 2, idx, val);
        update(mid + 1, end, node * 2 + 1, idx, val);
    
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
    
}
