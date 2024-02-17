package section9;

import java.util.*;
/**
 * 코테 강의 9-2. 회의실 배정
 * 
 * 한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들려고 한다.

각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라.

단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
 */

class Time implements Comparable<Time>{
    public int start, end;

    Time(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o) { //끝나는 시간을 기준으로 정렬. 가장 사용 시간이 적은 순서대로 정렬함
        if(o.end == this.end) return this.start-o.start;
        else return this.end-o.end;
    }

}

public class Test2 {
    public int solution(ArrayList<Time> a, int n){
        Collections.sort(a); //꼭 정렬하기

        int e = 0, cnt = 0;

        for(Time t : a){
            if(t.start >= e){
                cnt++;
                e = t.end;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Test2 t = new Test2();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        ArrayList<Time> arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            int start = kb.nextInt();
            int end = kb.nextInt();
            arr.add(new Time(start, end));
        }

        System.out.println(t.solution(arr, n));
        
    }
}
