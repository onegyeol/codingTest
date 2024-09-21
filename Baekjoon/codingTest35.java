package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 백준 1516번 게임 개발
 * 
 * 숌 회사에서 이번에 새로운 전략 시뮬레이션 게임 세준 크래프트를 개발하기로 하였다. 
 * 핵심적인 부분은 개발이 끝난 상태고, 종족별 균형과 전체 게임 시간 등을 조절하는 부분만 남아 있었다.

게임 플레이에 들어가는 시간은 상황에 따라 다를 수 있기 때문에, 모든 건물을 짓는데 걸리는 최소의 시간을 이용하여 근사하기로 하였다. 
물론, 어떤 건물을 짓기 위해서 다른 건물을 먼저 지어야 할 수도 있기 때문에 문제가 단순하지만은 않을 수도 있다. 
예를 들면 스타크래프트에서 벙커를 짓기 위해서는 배럭을 먼저 지어야 하기 때문에, 배럭을 먼저 지은 뒤 벙커를 지어야 한다. 여러 개의 건물을 동시에 지을 수 있다.

편의상 자원은 무한히 많이 가지고 있고, 건물을 짓는 명령을 내리기까지는 시간이 걸리지 않는다고 가정하자.
 */

public class codingTest35 {
    static int n;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] time, parentNum, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        time = new int[n+1]; // 수행시간
        parentNum = new int[n+1]; // 선행 작업
        answer = new int[n+1]; // 정답 배열

        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken()); // 처음 입력되는 숫자는 수행 시간
            
            while(st.hasMoreTokens()){ // 그 다음 토큰이 존재할동안
                int num = Integer.parseInt(st.nextToken());

                if(num == -1) break;

                list.get(num).add(i); // ex) 작업1을 우선순위로 갖는 작업 번호들 list에 추가
                parentNum[i]++; // 해당 작업을 수행하기 위한 선행 작업의 갯수 count
            }
        }

        logicalSort();

        for(int i=1; i<=n; i++){
            System.out.println(answer[i]);
        }
    }

    static void logicalSort(){
        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=n; i++){
            if(parentNum[i] == 0) q.offer(i); // 선행 작업이 없으면 큐에 넣음
        }

        while(!q.isEmpty()){ 
            int vertex = q.poll();
            answer[vertex] += time[vertex];
            
            for(int j=0; j<list.get(vertex).size(); j++){
                int next = list.get(vertex).get(j); // 해당 작업을 선행 작업에 넣는 작업의 번호 수
                parentNum[next]--;  // 해당 작업을 선행 작업으로 갖는 수 감소
                if(parentNum[next] == 0) q.offer(next); // 선행작업 모두 수행 시 큐에 넣음

                answer[next] = Math.max(answer[next], answer[vertex]); 
            }
        }
    }
}
