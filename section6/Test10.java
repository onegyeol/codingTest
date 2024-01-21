package section6;

import java.util.*;

/**
 * N개의 마구간이 수직선상에 있습니다. 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며, 마구간간에 좌표가 중복되는 일은 없습니다.

현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다. 각 마구간에는 한 마리의 말만 넣을 수 있고,

가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶습니다.

C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력하는 프로그램을 작성하세요
 */

public class Test10 {
    public int count(int[] a, int dist){
        int cnt=1;
        int ep = a[0];
        for(int i=1; i<a.length; i++){
            if(a[i]-ep >= dist){
                cnt++;
                ep = a[i];
            }
        }

        return cnt;

    }

    public int solution(int n, int c, int[] a){
        int answer=0;
        Arrays.sort(a);
        int lt=1;
        int rt=a[n-1];

        while(lt<=rt){
            int mid = (lt+rt)/2;
            if(count(a, mid) >= c){
                answer = mid;
                lt = mid+1;
            }
            else rt = mid-1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Test10 t = new Test10();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int c = in.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }

        System.out.println(t.solution(n, c, arr));
    }
}
