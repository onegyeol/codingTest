package section5;

import java.util.*;

public class Test6 {
    public int solution(int n, int k){
        int answer=0;
        Queue<Integer> qu = new LinkedList<>();

        for(int i=1; i<=n; i++) qu.offer(i);

        while(!qu.isEmpty()){
            for(int i=1; i<k; i++){
                qu.offer(qu.poll());
            }
            qu.poll();
            if(qu.size() == 1) answer = qu.poll();
        }

        return answer;
    }
    public static void main(String[] args) {
        Test6 t = new Test6();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        System.out.println(t.solution(n, k));
    }
}
