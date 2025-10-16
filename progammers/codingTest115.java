package progammers;

import java.util.ArrayList;

/*
 * 프로그래머스 Lv.2 전력망을 둘로 나누기
 * 
 * 송전탑의 개수 n, 그리고 전선 정보 wires가 매개변수로 주어집니다. 
 * 전선들 중 하나를 끊어서 송전탑 개수가 가능한 비슷하도록 두 전력망으로 나누었을 때, 
 * 두 전력망이 가지고 있는 송전탑 개수의 차이(절대값)를 return 하도록 solution 함수를 완성해주세요.
 */

public class codingTest115 {
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) {
        // n, wires 입력 받음
    }

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        arr = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
        }
        
        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            arr[a].add(b);
            arr[b].add(a);
        }
        
        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            boolean[] isConnected = new boolean[n+1];
            
            arr[a].remove(Integer.valueOf(b));
            arr[b].remove(Integer.valueOf(a));
            
            // 1번에서부터 방문할 수 있는 노드의 수
            int cnt = dfs(1, isConnected);
            
            // n-cnt -> 다른 쪽에서 방문할 수 있는 노드
            // cnt - (n-cnt) -> 노드의 차
            int diff = Math.abs(cnt - (n - cnt));
            answer = Math.min(answer, diff);
            
            arr[a].add(b);
            arr[b].add(a);
        }
        
        
        return answer;
    }
    
    static int dfs(int v, boolean[] visited){
        visited[v] = true;
        int cnt=1;
        
        for (int tmp : arr[v]){
            if(!visited[tmp]){
                cnt += dfs(tmp, visited);
            }
        }
        
        return cnt;
    }
}
