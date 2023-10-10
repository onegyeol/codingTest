package section3;

import java.util.*;

public class Test4 {
    public int solution(int n, int m, int[] a){
        int answer=0, sum = 0, lt = 0;

        for(int rt=0; rt<n; rt++){
            sum+=a[rt];
            if(sum == m) answer++;
            while(sum >= m){ //m보다 큰데 더해줄 필요 없기에 
                sum -= a[lt++]; //a[lt]만큼 빼주기
                if(sum == m) answer++; //이때도 m이랑 같은지 검사필요
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Test4 t = new Test4();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }

        System.out.println(t.solution(n, m, arr));
    }
}
