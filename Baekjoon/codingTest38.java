package Baekjoon;

import java.util.*;
import java.io.*;

/**
 * 백준 2357번 최솟값과 최댓값
 * 
 * N(1 ≤ N ≤ 100,000)개의 정수들이 있을 때, a번째 정수부터 b번째 정수까지 중에서 제일 작은 정수, 또는 제일 큰 정수를 찾는 것은 어려운 일이 아니다. 
 * 하지만 이와 같은 a, b의 쌍이 M(1 ≤ M ≤ 100,000)개 주어졌을 때는 어려운 문제가 된다. 이 문제를 해결해 보자.

여기서 a번째라는 것은 입력되는 순서로 a번째라는 이야기이다. 
예를 들어 a=1, b=3이라면 입력된 순서대로 1번, 2번, 3번 정수 중에서 최소, 최댓값을 찾아야 한다. 
각각의 정수들은 1이상 1,000,000,000이하의 값을 갖는다.
 * 
 */
public class codingTest38 {
    static int n, m;
    static int[] num, minTree, maxTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new int[n+1];
        minTree = new int[n*4];
        maxTree = new int[n*4];

        for(int i=1; i<=n; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        initMinTree(1, n, 1);
        initMaxTree(1, n, 1);
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(findMin(1, n, 1, a, b) + " " + findMax(1, n, 1, a, b) + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static int initMinTree(int start, int end, int node){
        if(start == end) return minTree[node] = num[start];

        int mid = (start+end)/2;
        return minTree[node] = Math.min(initMinTree(start, mid, node*2), initMinTree(mid+1, end, node*2+1));
    }

    static int initMaxTree(int start, int end, int node){
        if(start == end) return maxTree[node] = num[start];

        int mid = (start+end)/2;
        return maxTree[node] = Math.max(initMaxTree(start, mid, node*2), initMaxTree(mid+1, end, node*2+1));
    }

    static int findMin(int start, int end, int node, int left, int right){
        if(right < start || left > end) return Integer.MAX_VALUE; // 범위 밖에 있을 때

        if(left <= start && right >= end) return minTree[node]; //범위 안에 있을 때

        int mid = (start+end)/2;
        return Math.min(findMin(start, mid, node*2, left, right), findMin(mid+1, end, node*2+1, left, right));

    }

    static int findMax(int start, int end, int node, int left, int right){
        if(right < start || left > end) return Integer.MIN_VALUE; // 범위 밖에 있을 때
        
        if(left <= start && right >= end) return maxTree[node]; // 범위 안에 있을 때

        int mid = (start+end)/2;
        return Math.max(findMax(start, mid, node*2, left, right), findMax(mid+1, end, node*2+1, left, right));
    }

}
