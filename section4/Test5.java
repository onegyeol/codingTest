package section4;

import java.util.*;

public class Test5 {
    public int solution(int n, int k, int[] a){
        int answer=-1;
        //값을 찾지 못하면 -1 리턴해야하기에 초기값 -1로 지정
        TreeSet<Integer> tree = new TreeSet<>(Collections.reverseOrder()); 
        //디폴트가 오름차순이니까 reverseOrder 사용해서 내림차순으로

        for(int lt=0; lt<n-2; lt++){
            for(int i=lt+1; i<n-1; i++){
                for(int j=i+1; j<n; j++){
                    tree.add(a[lt]+a[i]+a[j]);
                }
            }
        }

        int cnt = 1; //set은 인덱스로 접근 못해서 cnt로 따로 카운트 필요함.
        for(int i : tree){
            if(cnt == k){
                answer = i;
                break;
            }
            cnt++;
        }

        return answer;
    }
    public static void main(String[] args) {
        Test5 t = new Test5();
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
