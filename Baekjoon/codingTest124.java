package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
 * 백준 2668번 숫자고르기
 * 세로 두 줄, 가로로 N개의 칸으로 이루어진 표가 있다. 
 * 첫째 줄의 각 칸에는 정수 1, 2, …, N이 차례대로 들어 있고 둘째 줄의 각 칸에는 1이상 N이하인 정수가 들어 있다. 
 * 첫째 줄에서 숫자를 적절히 뽑으면, 그 뽑힌 정수들이 이루는 집합과, 뽑힌 정수들의 바로 밑의 둘째 줄에 들어있는 정수들이 이루는 집합이 일치한다. 
 * 이러한 조건을 만족시키도록 정수들을 뽑되, 최대로 많이 뽑는 방법을 찾는 프로그램을 작성하시오.
 * 
 * 입력
 * 첫째 줄에는 N(1≤N≤100)을 나타내는 정수 하나가 주어진다. 그 다음 줄부터는 표의 둘째 줄에 들어가는 정수들이 순서대로 한 줄에 하나씩 입력된다.
 * 
 * 출력
 * 첫째 줄에 뽑힌 정수들의 개수를 출력하고, 그 다음 줄부터는 뽑힌 정수들을 작은 수부터 큰 수의 순서로 한 줄에 하나씩 출력한다.
 */

public class codingTest124 {
    static ArrayList<Integer> arr = new ArrayList<>();
    static int n;
    static boolean[] visited;
    static int[] input;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        input = new int[n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++){
            input[i] = Integer.parseInt(br.readLine());
        }

        // 각 노드에 연결된 값 확인
        for(int i=1; i<=n; i++){
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(arr);
        System.out.println(arr.size());
        
        for(int i=0; i<arr.size(); i++){
            System.out.println(arr.get(i));
        }
    }

    public static void dfs(int start, int target){
        // 입력값의 노드를 방문하지 않았다면
        if(visited[input[start]] == false){
            visited[input[start]] = true;
            // 방문
            dfs(input[start], target);
            visited[input[start]] = false;
        }
        // 다시 자기 자신으로 돌아왔다면 그래프 완성
        if(input[start]==target) arr.add(target);
    }
}
