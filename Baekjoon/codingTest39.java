package Baekjoon;

import java.util.*;
import java.io.*; 

/**
 * 백준 1043번 거짓말
 * 
 * 지민이는 파티에 가서 이야기 하는 것을 좋아한다. 
 * 파티에 갈 때마다, 지민이는 지민이가 가장 좋아하는 이야기를 한다. 지민이는 그 이야기를 말할 때, 있는 그대로 진실로 말하거나 엄청나게 과장해서 말한다. 
 * 당연히 과장해서 이야기하는 것이 훨씬 더 재미있기 때문에, 되도록이면 과장해서 이야기하려고 한다. 
 * 하지만, 지민이는 거짓말쟁이로 알려지기는 싫어한다. 문제는 몇몇 사람들은 그 이야기의 진실을 안다는 것이다.
 *  따라서 이런 사람들이 파티에 왔을 때는, 지민이는 진실을 이야기할 수 밖에 없다.
 *  당연히, 어떤 사람이 어떤 파티에서는 진실을 듣고, 또다른 파티에서는 과장된 이야기를 들었을 때도 지민이는 거짓말쟁이로 알려지게 된다. 
 * 지민이는 이런 일을 모두 피해야 한다.

사람의 수 N이 주어진다. 그리고 그 이야기의 진실을 아는 사람이 주어진다. 
그리고 각 파티에 오는 사람들의 번호가 주어진다. 지민이는 모든 파티에 참가해야 한다. 
이때, 지민이가 거짓말쟁이로 알려지지 않으면서, 과장된 이야기를 할 수 있는 파티 개수의 최댓값을 구하는 프로그램을 작성하시오.
 */

public class codingTest39 {
    static int n, m;
    static int[] truth, parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 사람 수
        m = Integer.parseInt(st.nextToken()); // 파티 수

        boolean[] people_know = new boolean[n+1]; // 진실을 아는 사람 구분 위해 (진실을 앎 = TRUE)
        HashSet<Integer>[] party = new HashSet[m+1]; // 파티안에서 진실을 아는 사람을 찾기 위해

        for(int i=1; i<=m; i++){
            party[i] = new HashSet<>();
        }

        st = new StringTokenizer(br.readLine());
        int tr = Integer.parseInt(st.nextToken()); // 진실을 아는 사람 수
        for(int i=1; i<=tr; i++){
            int tmp = Integer.parseInt(st.nextToken());
            people_know[tmp] = true; // 해당 번호의 사람들은 진실을 알기에 TRUE로 
        }

        parent = new int[n+1]; // Union-find 위한 배열
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        for(int i=1; i<=m; i++){
            String[] inputs = br.readLine().split(" ");
            int num = Integer.parseInt(inputs[0]);
            
            if(num<=1){
                party[i].add(Integer.parseInt(inputs[1]));
                continue;
            }

            for(int j=1; j<num; j++){
                int a = Integer.parseInt(inputs[j]);
                int b = Integer.parseInt(inputs[j+1]);

                if(find(a) != find(b)){ // 연결되어 있지 안ㅎ으면
                    union(a, b);
                }

                party[i].add(a);
                party[i].add(b);
            }
        }

        boolean[] visited = new boolean[n+1];
        for(int i=1; i<=n; i++){
            if(people_know[i] && !visited[i]){ // 진실을 알고 있고 아직 방문하지 않았다면
                int root = find(i); // 해당 사람의 루트 노드 찾음
                for(int j=1; j<=n; j++){
                    if(find(j) == root){ // 진실을 알고있는 사람이 존재한다면
                        people_know[j] = true;
                        visited[j] = true;
                    }
                }
            }
        }

        int result = 0;
        for(int i=1; i<=m; i++){
            boolean flag = false;
            for(int p : party[i]){
                if(people_know[p]){ // 해당 파티에 진실을 알고 있는 사람이 있다면
                    flag = true;
                    break;
                }
            }
            if(!flag) result++;
        }

        System.out.println(result);

    }

    static int find(int x){
        if(parent[x] == x) return x;
        return find(parent[x]);
    }

    static void union(int a, int b){
        int parent_b = find(b);
        parent[parent_b] = a; 
    }
    
}
