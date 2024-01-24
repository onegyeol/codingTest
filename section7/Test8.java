package section7;

import java.util.*;

public class Test8 {
    int[] dis ={-1, 1, 5};
    int[] ch;
    Queue<Integer> q = new LinkedList<>();
    public int BFS(int s, int e){
        ch = new int[10001]; //이미 접근한 숫자인지 아닌지
        ch[s] = 1; //s번째 숫자는 1로 변경
        q.offer(s); //s값을 큐에 넣어줌
        int cnt=0;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; i++){
                int x = q.poll();
                if(x==e) return cnt;
                for(int j=0; j<3; j++){ //-1, +1, +5 위해 반복문
                    int n = dis[j]+x; //큐에서 꺼낸 값에 -1, +1, +5 해줌
                    if(n>=1 && n<10000 && ch[n]==0){
                        ch[n]=1; //이미 나온 값으로 처리하기 위해 1로 바꿔줌
                        q.offer(n); //계산해서 나온 값 큐에 넣어줌
                    }
                }
            }
            cnt++;
        }
        return 0;
    }
    public static void main(String[] args) {
        Test8 t = new Test8();
        Scanner in = new Scanner(System.in);

        int s = in.nextInt();
        int e = in.nextInt();

        System.out.println(t.BFS(s, e));
    }
}
