package Baekjoon;

import java.util.*;
import java.io.*;

/**
 * 백준 1005번 ACM Craft
 * 
 * <문제>
이번 게임에서는 다음과 같이 건설 순서 규칙이 주어졌다. 1번 건물의 건설이 완료된다면 2번과 3번의 건설을 시작할수 있다. 
동시에 진행이 가능하다) 그리고 4번 건물을 짓기 위해서는 2번과 3번 건물이 모두 건설 완료되어야지만 4번건물의 건설을 시작할수 있다.

따라서 4번건물의 건설을 완료하기 위해서는 우선 처음 1번 건물을 건설하는데 10초가 소요된다. 
그리고 2번 건물과 3번 건물을 동시에 건설하기 시작하면 2번은 1초뒤에 건설이 완료되지만 아직 3번 건물이 완료되지 않았으므로 4번 건물을 건설할 수 없다. 
3번 건물이 완성되고 나면 그때 4번 건물을 지을수 있으므로 4번 건물이 완성되기까지는 총 120초가 소요된다.

프로게이머 최백준은 애인과의 데이트 비용을 마련하기 위해 서강대학교배 ACM크래프트 대회에 참가했다! 
최백준은 화려한 컨트롤 실력을 가지고 있기 때문에 모든 경기에서 특정 건물만 짓는다면 무조건 게임에서 이길 수 있다. 
그러나 매 게임마다 특정건물을 짓기 위한 순서가 달라지므로 최백준은 좌절하고 있었다. 
백준이를 위해 특정건물을 가장 빨리 지을 때까지 걸리는 최소시간을 알아내는 프로그램을 작성해주자.
 * 
 * <입력>
첫째 줄에는 테스트케이스의 개수 T가 주어진다. 각 테스트 케이스는 다음과 같이 주어진다. 
첫째 줄에 건물의 개수 N과 건물간의 건설순서 규칙의 총 개수 K이 주어진다. (건물의 번호는 1번부터 N번까지 존재한다) 

둘째 줄에는 각 건물당 건설에 걸리는 시간 D1, D2, ..., DN이 공백을 사이로 주어진다. 셋째 줄부터 K+2줄까지 건설순서 X Y가 주어진다. 
(이는 건물 X를 지은 다음에 건물 Y를 짓는 것이 가능하다는 의미이다) 

마지막 줄에는 백준이가 승리하기 위해 건설해야 할 건물의 번호 W가 주어진다.
 */
public class codingTest37 {
    static int t, n, k, w;
    static int[] time, indegree, result;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken()); // 테스트케이스의 개수

        for (int test = 0; test < t; test++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 건물의 개수
            k = Integer.parseInt(st.nextToken()); // 건설 규칙의 개수

            time = new int[n + 1];       // 각 건물의 건설 시간
            indegree = new int[n + 1];   // 진입차수
            result = new int[n + 1];     // 결과 시간
            graph = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>()); // 초기화
            }

            // 건물당 건설 시간 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            // 건설 순서 입력
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b); // a -> b (a를 짓고 b를 지을 수 있음)
                indegree[b]++;        // b로 들어오는 간선 증가
            }

            // 승리 조건으로 건설해야 할 건물
            w = Integer.parseInt(br.readLine());

            // 위상 정렬 및 결과 출력
            System.out.println(topologySort());
        }
    }

    // 위상 정렬 함수
    static int topologySort() {
        Queue<Integer> q = new LinkedList<>();

        // 진입차수가 0인 건물을 큐에 삽입
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                result[i] = time[i]; // 건설 시간이 그대로 필요
            }
        }

        // 위상 정렬 수행
        while (!q.isEmpty()) {
            int current = q.poll();

            // 현재 건물에서 이어지는 건물들 확인
            for (int next : graph.get(current)) {
                indegree[next]--;

                // 건설 시간을 갱신 (더 큰 시간을 선택해야 함)
                result[next] = Math.max(result[next], result[current] + time[next]);

                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        // 원하는 건물의 건설 시간을 반환
        return result[w];
    }
}
