package section3;

import java.util.*;

public class Test3 {
    public int solution(int n, int k, int[] a){
        int answer=0; 

        for(int i=0; i<k; i++) answer += a[i]; //슬라이딩 창문 식으로 k칸 짜리 창문을 만들어서 옆으로 계속 밀고 나감
        int sum = answer;

        for(int i=k; i<n; i++){
            sum += a[i] - a[i-k]; 
            answer = Math.max(answer, sum);
            
        }

        return answer;
    }
    public static void main(String[] args) {
        Test3 t = new Test3();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }

        System.out.println(t.solution(n, k, arr));
        
    }
}
