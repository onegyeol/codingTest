package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 14889번 스타트와 링크
 * 오늘은 스타트링크에 다니는 사람들이 모여서 축구를 해보려고 한다. 축구는 평일 오후에 하고 의무 참석도 아니다. 축구를 하기 위해 모인 사람은 총 N명이고 신기하게도 N은 짝수이다. 
 * 이제 N/2명으로 이루어진 스타트 팀과 링크 팀으로 사람들을 나눠야 한다.

BOJ를 운영하는 회사 답게 사람에게 번호를 1부터 N까지로 배정했고, 아래와 같은 능력치를 조사했다. 
능력치 Sij는 i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치이다. 팀의 능력치는 팀에 속한 모든 쌍의 능력치 Sij의 합이다.
 Sij는 Sji와 다를 수도 있으며, i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치는 Sij와 Sji이다.

 예를 들어, 1, 2번이 스타트 팀, 3, 4번이 링크 팀에 속한 경우에 두 팀의 능력치는 아래와 같다.

스타트 팀: S12 + S21 = 1 + 4 = 5
링크 팀: S34 + S43 = 2 + 5 = 7
1, 3번이 스타트 팀, 2, 4번이 링크 팀에 속하면, 두 팀의 능력치는 아래와 같다.

스타트 팀: S13 + S31 = 2 + 7 = 9
링크 팀: S24 + S42 = 6 + 4 = 10
축구를 재미있게 하기 위해서 스타트 팀의 능력치와 링크 팀의 능력치의 차이를 최소로 하려고 한다. 
위의 예제와 같은 경우에는 1, 4번이 스타트 팀, 2, 3번 팀이 링크 팀에 속하면 스타트 팀의 능력치는 6, 링크 팀의 능력치는 6이 되어서 차이가 0이 되고 이 값이 최소이다.
 */

public class codingTest7 {
    static int n, answer = Integer.MAX_VALUE;
    static int[][] board;
    static boolean[] visited;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new boolean[n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(answer);

    }

    static void dfs(int idx, int cnt){
        if(cnt == n/2){
            int startTeam=0, linkTeam=0;

            for(int i=0; i<n-1; i++){
                for(int j=i+1; j<n; j++){ //중복방지위해
                    if(visited[i] && visited[j]){ //방문한 애들을 스타트팀에 넣어줌
                        startTeam += board[i][j];
                        startTeam += board[j][i];
                    }
                    else if(!visited[i] && !visited[j]){
                        linkTeam += board[i][j];
                        linkTeam += board[j][i];
                    }
                }
            }

            int val = Math.abs(startTeam-linkTeam); //절대값을 넣어줌

            if(val == 0){
                System.out.println(val);
                System.exit(0);
            }

            answer = Math.min(val, answer);
            return;
        }
        for(int i=idx; i<n; i++){
            if(!visited[i]){ //방문하지 않았다면
                visited[i] = true;
                dfs(i+1, cnt+1);
                visited[i] = false;
            }
        }
    }
}
