package Baekjoon;

import java.util.*;
import java.io.*;

/*
 * 백준 11403번 경로 찾기
 * 
 * 가중치 없는 방향 그래프 G가 주어졌을 때, 모든 정점 (i, j)에 대해서, i에서 j로 가는 길이가 양수인 경로가 있는지 없는지 구하는 프로그램을 작성하시오.
 */

public class codingTest72 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        int[][] answer = new int[n][n];
        
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Floyd-Warshall
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                if(graph[i][k] == 0) continue;
                answer[i][k] = 1;
                for(int j=0; j<n; j++){
                    if(graph[k][j] == 0) continue;
                    graph[i][j] = 1;
                    answer[i][j] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(graph[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

/**
 * 파이썬 코드
 * 
 * def solve():
 *  n = int(input())
 *  graph = [list(map(int, input().split())) for _ in range(n)]
 * 
 *  for k in range(n):
 *      for i in range(n):
 *          if graph[i][k] == 0 :
 *              continue
 *          for j in range(n):
 *              if graph[k][j] == 0:
 *                  continue;
 *              graph[i][j] = 1
 * 
 *  for row in graph :
 *      print(*row)
 * 
 * if __name__ == "__main__":
 *      solve()
 */