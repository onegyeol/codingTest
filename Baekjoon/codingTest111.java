package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 1027번 고층 건물
 * 
 * 세준시에는 고층 빌딩이 많다. 세준시의 서민 김지민은 가장 많은 고층 빌딩이 보이는 고층 빌딩을 찾으려고 한다. 
 * 빌딩은 총 N개가 있는데, 빌딩은 선분으로 나타낸다. i번째 빌딩 (1부터 시작)은 (i,0)부터 (i,높이)의 선분으로 나타낼 수 있다. 
 * 고층 빌딩 A에서 다른 고층 빌딩 B가 볼 수 있는 빌딩이 되려면, 두 지붕을 잇는 선분이 A와 B를 제외한 다른 고층 빌딩을 지나거나 접하지 않아야 한다. 
 * 가장 많은 고층 빌딩이 보이는 빌딩을 구하고, 거기서 보이는 빌딩의 수를 출력하는 프로그램을 작성하시오.
 */


public class codingTest111 {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer=0;
        for(int i=0; i<n; i++){
            answer = Math.max(answer, Count(i));
        }

        System.out.println(answer);
    }

    /*
     * 한 건물을 기준으로 왼/오 다르게 봐야함
     * 왼쪽은 갈수록 기울기가 감소해야 보임
     * 오른쪽은 갈수록 기울기가 증가해야 보임 (음수 기울기이기 때문)
     */
    static int Count(int idx){
        int cnt=0;
        double tmp=0;

        for(int i=idx-1; i>=0; i--){
            double lean = (arr[idx]-arr[i])/(idx-i);

            if(lean<tmp || i==idx-1){ // 기울기가 작아야 보임
                cnt++;
                tmp=lean;
            }
        }

        for(int i=idx+1; i<n; i++){
            double lean = (arr[idx]-arr[i])/(idx-i);

            if(lean>tmp || i==idx+1){ // 기울기가 커야 보임 (방향이 다르기에)
                cnt++;
                tmp=lean;
            }
        }

        return cnt;
    }


}
