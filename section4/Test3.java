package section4;

import java.util.*;

public class Test3 {
    public ArrayList<Integer> solution(int n, int k, int[] arr){
        int lt=0;
        ArrayList<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<k-1; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        
        for(int rt=k-1; rt<n; rt++){
            map.put(arr[rt], map.getOrDefault(arr[rt], 0)+1);
            answer.add(map.size());
            map.put(arr[lt], map.get(arr[lt])-1);
            if(map.get(arr[lt]) == 0) map.remove(arr[lt]);
            lt++;
        }

        /**
         * 배열의 길이를 알 수 없으니 arraylist로 사용
         * 0~k-2 까지 map에 넣어줌
         * k-1부터는 값 넣어주고 크기를 배열에 넣어준 뒤
         * 가장 앞 값인 arr[lt] 값을 -1 해줌
         */

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

        for(int a : t.solution(n, k, arr)){
            System.out.print(a + " ");
        }
    }
}
