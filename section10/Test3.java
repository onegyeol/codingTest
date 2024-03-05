package section10;

import java.util.*;

/**
 * 코테 강의 10-3. 최대 부분 증가 수열
 * 
 * N개의 자연수로 이루어진 수열이 주어졌을 때, 그 중에서 가장 길게 증가하는(작은 수에서 큰 수로) 원소들의 집합을 찾는 프로그램을 작성하라.

예를 들어, 원소가 2, 7, 5, 8, 6, 4, 7, 12, 3 이면 가장 길게 증가하도록 원소들을 차례대로 뽑아내면 2, 5, 6, 7, 12를 뽑아내어

길이가 5인 최대 부분 증가수열을 만들 수 있다.
 */

public class Test3 {
    static int n;
    static int[] arr, len; 
    public int solution(){

        for(int i=0; i<n; i++){
            len[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j]){
                    len[i] = Math.max(len[i], len[j]+1); //길이 갱신
                }
            }
        }

        return Arrays.stream(len).max().getAsInt(); //len 배열 중 최대값 반환
    }
    public static void main(String[] args) {
        Test3 t = new Test3();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        arr = new int[n];
        len = new int[n]; //각각의 증가수열 길이 저장
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }

        System.out.println(t.solution());
    }
}
