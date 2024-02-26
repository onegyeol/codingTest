package section9;

import java.util.*;

/**코테 강의 8-6. 친구인가?
 * 
 * 오늘은 새 학기 새로운 반에서 처음 시작하는 날이다. 현수네 반 학생은 N명이다. 현수는 각 학생들의 친구관계를 알고 싶다.

모든 학생은 1부터 N까지 번호가 부여되어 있고, 현수에게는 각각 두 명의 학생은 친구 관계가 번호로 표현된 숫자쌍이 주어진다.

만약 (1, 2), (2, 3), (3, 4)의 숫자쌍이 주어지면 1번 학생과 2번 학생이 친구이고, 2번 학생과 3번 학생이 친구, 3번 학생과 4번 학생이 친구이다.

그리고 1번 학생과 4번 학생은 2번과 3번을 통해서 친구관계가 된다.

학생의 친구관계를 나타내는 숫자쌍이 주어지면 특정 두 명이 친구인지를 판별하는 프로그램을 작성하세요.


 */

public class Test6 {
    static int[] unf;

    static int Find(int v){
        if(v==unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }
    
    public static void Union(int a, int b){ //한다리 건너서 친구인 애들 찾기 위함
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) unf[fa] = fb;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        unf = new int[n+1];

        for(int i=1; i<=n; i++) unf[i] = i; //각 인덱스 번호로 초기화
        for(int i=1; i<=m; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            Union(a, b);
        }

        int a = in.nextInt();
        int b = in.nextInt();
        int fa = Find(a);
        int fb = Find(b);
        
        if(fa == fb) System.out.println("YES");
        else System.out.println("NO");
    }
}
