package progammers;

import java.util.Arrays;
/*
프로그래머스 Lv.3 섬 연결하기

n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때, 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용을 return 하도록 solution을 완성하세요.
다리를 여러 번 건너더라도, 도달할 수만 있으면 통행 가능하다고 봅니다. 예를 들어 A 섬과 B 섬 사이에 다리가 있고, B 섬과 C 섬 사이에 다리가 있으면 A 섬과 C 섬은 서로 통행 가능합니다.
임의의 i에 대해, costs[i][0] 와 costs[i] [1]에는 다리가 연결되는 두 섬의 번호가 들어있고, costs[i] [2]에는 이 두 섬을 연결하는 다리를 건설할 때 드는 비용입니다.
*/

public class codingTest142 {
    static int[] parent;
    public static void main(String[] args) {
        
    }
    
    public int find(int a){
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
    
    public void union(int a, int b){
        a = find(a);
        b = find(b);
        
        if(a != b){
            parent[b] = a;
        }
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        // 가중치 기준 오름차순 정렬
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        for(int i=0; i<costs.length; i++){
            // 연결되어 있지 않다면 (크루스칼 알고리즘 사용)
            if(find(costs[i][0]) != find(costs[i][1])){
                // 연결시킴
                union(costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }
        return answer;
    }
}
