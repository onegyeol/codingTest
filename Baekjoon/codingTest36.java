package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 20040번 사이클 게임
 * 
 * 사이클 게임은 두 명의 플레이어가 차례대로 돌아가며 진행하는 게임으로, 선 플레이어가 홀수 번째 차례를, 후 플레이어가 짝수 번째 차례를 진행한다. 
 * 게임 시작 시 0 부터 n − 1 까지 고유한 번호가 부여된 평면 상의 점 n 개가 주어지며, 이 중 어느 세 점도 일직선 위에 놓이지 않는다. 
 * 매 차례 마다 플레이어는 두 점을 선택해서 이를 연결하는 선분을 긋는데, 이전에 그린 선분을 다시 그을 수는 없지만 이미 그린 다른 선분과 교차하는 것은 가능하다. 
 * 게임을 진행하다가 처음으로 사이클을 완성하는 순간 게임이 종료된다. 사이클 C는 플레이어가 그린 선분들의 부분집합으로, 다음 조건을 만족한다.

C에 속한 임의의 선분의 한 끝점에서 출발하여 모든 선분을 한 번씩만 지나서 출발점으로 되돌아올 수 있다.

문제는 선분을 여러 개 그리다 보면 사이클이 완성 되었는지의 여부를 판단하기 어려워 이미 사이클이 완성되었음에도 불구하고 게임을 계속 진행하게 될 수 있다는 것이다. 
이 문제를 해결하기 위해서 게임의 진행 상황이 주어지면 몇 번째 차례에서 사이클이 완성되었는지, 혹은 아직 게임이 진행 중인지를 판단하는 프로그램을 작성하려 한다.

입력으로 점의 개수 n과 m 번째 차례까지의 게임 진행 상황이 주어지면 사이클이 완성 되었는지를 판단하고,
 완성되었다면 몇 번째 차례에서 처음으로 사이클이 완성된 것인지를 출력하는 프로그램을 작성하시오.
 */

public class codingTest36 {
    static int[] arr; 
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];

        for(int i=1; i<=n; i++) arr[i] = i; // 배열 초기화. 각 노드들이 자기 자신을 갖도록

        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());

            int a = find(Integer.parseInt(st.nextToken()));
            int b = find(Integer.parseInt(st.nextToken()));

            if(a == b){ // 처음으로 사이클이 완성된 경우
                System.out.println(i);
                return ;
            }

            if(a>=b) arr[a] = b;
            else arr[b] = a;
        }

        System.out.println(0); // 사이클이 없으면 0 출력

        
    }

    static int find(int x){ // 사이클을 찾기 위해 특정 노드가 속한 집합의 대표 노드를 찾음
        if(arr[x] == x) return x;
        return arr[x] = find(arr[x]); // 만나는 모든 노드를 해당 집합의 대표 노드와 연결함
    }
}
