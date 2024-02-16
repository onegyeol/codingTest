package section9;

import java.util.*;

/**
 * 코테 강의 9-1. 씨름 선수 (그리디 알고리즘)
 * 현수는 씨름 감독입니다. 현수는 씨름 선수를 선발공고를 냈고, N명의 지원자가 지원을 했습니다.

현수는 각 지원자의 키와 몸무게 정보를 알고 있습니다.

현수는 씨름 선수 선발 원칙을 다음과 같이 정했습니다.

“A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자 보다 높은(크고, 무겁다) 지원자가

존재하면 A지원자는 탈락하고, 그렇지 않으면 선발된다.”

 */

class Body implements Comparable<Body> { //비교를 위해 클래스를 하나 더 만들어줌. Comparable 인터페이스 구현
    public int h, w;
    Body(int h, int w){
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Body o) { //키를 기준으로 정렬
        return o.h-this.h;
    }
}

public class Test1 {
    public int solution(ArrayList<Body> a, int n){
        int cnt=0;
        Collections.sort(a); //일단 키를 기준으로 정렬
        int max = Integer.MIN_VALUE;
        for(Body b : a){ 
            if(b.w > max){ //키로 정렬했기에 몸무게로만 비교하면 됨.
                max = b.w;
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Test1 t = new Test1();
        Scanner kb = new Scanner(System.in);
        
        int n = kb.nextInt();
        ArrayList<Body> arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            int h = kb.nextInt();
            int w = kb.nextInt();
            arr.add(new Body(h, w));
        }

        System.out.println(t.solution(arr, n));


    }
}
