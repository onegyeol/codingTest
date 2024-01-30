package section7;

import java.util.*;

public class Test13 {
    static int n, m, answer=0;
    static ArrayList<ArrayList<Integer>> graph; //선언만 해줌
    static int[]ch;

    public void DFS(int v){
        if(v==n) answer++;
        else {
            for(int nv : graph.get(v)){
                if(ch[nv] == 0){
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Test13 t = new Test13();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        graph = new ArrayList<ArrayList<Integer>>(); //객체 생성 따로 해줘야 함.
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>()); //n번방까지 만듦. 실제 접근할 땐 1~n까지 사용
        }

        ch = new int[n+1];
        for(int i=0; i<m; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            graph.get(a).add(b);
        }

        ch[1]=1;
        t.DFS(1);
        System.out.println(answer);
    }

}
