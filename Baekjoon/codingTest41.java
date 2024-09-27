package Baekjoon;

import java.io.*;
import java.util.*;

/**
 * 백준 2056번 작업
 * 
 * 수행해야 할 작업 N개 (3 ≤ N ≤ 10000)가 있다. 각각의 작업마다 걸리는 시간(1 ≤ 시간 ≤ 100)이 정수로 주어진다.

몇몇 작업들 사이에는 선행 관계라는 게 있어서, 어떤 작업을 수행하기 위해 반드시 먼저 완료되어야 할 작업들이 있다.
이 작업들은 번호가 아주 예쁘게 매겨져 있어서, K번 작업에 대해 선행 관계에 있는(즉, K번 작업을 시작하기 전에 반드시 먼저 완료되어야 하는) 작업들의 번호는 모두 1 이상 (K-1) 이하이다. 
작업들 중에는, 그것에 대해 선행 관계에 있는 작업이 하나도 없는 작업이 반드시 하나 이상 존재한다. (1번 작업이 항상 그러하다)

모든 작업을 완료하기 위해 필요한 최소 시간을 구하여라. 물론, 서로 선행 관계가 없는 작업들은 동시에 수행 가능하다.
 */

public class codingTest41 {
    static int n;
    static int[] degree, time, answer;
    static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 작업 개수
        time = new int[n+1]; // 작업 시간
        degree = new int[n+1]; // 진입차수 0으로 초기화
        answer = new int[n+1]; // 최대 시간구하기 위한 배열

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            
            int works = Integer.parseInt(st.nextToken());

            for(int j=0; j<works; j++){
                int priorWork = Integer.parseInt(st.nextToken()); // 선행 작업 번호
                graph.get(priorWork).add(i);
                degree[i]++;
            }
        }

        toplogySort();

        int result = 0;
        for(int i=1; i<=n; i++){
            result = Math.max(result, answer[i]);
        }

        System.out.println(result);
    }


    static void toplogySort(){
        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=n; i++){
            if(degree[i] == 0) {
                q.offer(i);
                answer[i] = time[i]; // 시간 초기화
            }
        }

        while(!q.isEmpty()){
            int tmp = q.poll();

            for(int nextNode : graph.get(tmp)){
                degree[nextNode]--; // 간선 삭제
                answer[nextNode] = Math.max(answer[nextNode], answer[tmp] + time[nextNode]);
                if(degree[nextNode] == 0)  q.offer(nextNode);
            }

        }
    }
}
