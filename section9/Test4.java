package section9;

import java.util.*;

/** 코테 강의 9-4
 * 
 * 현수는 유명한 강연자이다. N개이 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.

각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.

단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.
 */

class lecture implements Comparable<lecture>{
    int money, during;

    public lecture(int money, int during){
        this.money = money;
        this.during = during;
    }

    @Override
    public int compareTo(lecture o) {
        return o.during-this.during;
    }


}
public class Test4 {
    static int n, max = Integer.MIN_VALUE;
    public int solution(ArrayList<lecture> a){
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(a);

        int j=0;
        for(int i=max; i>=1; i--){
            for( ; j<n; j++){
                if(a.get(j).during < i) break;
                queue.offer(a.get(j).money); //PriorityQueue 내부에서 오름차순으로 정렬 중
            }
            if(!queue.isEmpty()) answer += queue.poll();//앞에 값은 항상 큰 값임
        }

        return answer;
    }
    public static void main(String[] args) {
        Test4 t = new Test4();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        ArrayList<lecture> arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            int m = kb.nextInt();
            int d = kb.nextInt();
            arr.add(new lecture(m, d));
            if(d > max) max=d;
        }

       System.out.println(t.solution(arr));
       
    }
}
