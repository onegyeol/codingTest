package section6;

import java.util.*;



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
