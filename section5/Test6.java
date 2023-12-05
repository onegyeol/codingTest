package section5;

import java.util.*;

public class Test6 {
    public int solution(int n, int k){
        int answer=0;
        Queue<Integer> qu = new LinkedList<>(); //큐는 선입선출 구조(LIFO)

        for(int i=1; i<=n; i++) qu.offer(i);

        while(!qu.isEmpty()){ //공백이 아닐동안 반복문 돌아감 
            for(int i=1; i<k; i++){
                qu.offer(qu.poll()); //k 전까지 앞의 수를 삭제하고 뒤에 다시 삽입해줌
            }
            qu.poll(); //큐의 FRONT 가 K번째 수일때 삭제
            if(qu.size() == 1) answer = qu.poll(); //큐에 값이 하나만 남으면 ANSWER에 넣어줌 poll()은 반환값이 있기에 이런 형태 가능
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
