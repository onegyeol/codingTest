package Baekjoon;

import java.io.*;
import java.util.*;

/**
 * 백준 13164번 행복 유치원
 * 
 * 행복 유치원 원장인 태양이는 어느 날 N명의 원생들을 키 순서대로 일렬로 줄 세우고, 총 K개의 조로 나누려고 한다. 
 * 각 조에는 원생이 적어도 한 명 있어야 하며, 같은 조에 속한 원생들은 서로 인접해 있어야 한다. 조별로 인원수가 같을 필요는 없다.

이렇게 나뉘어진 조들은 각자 단체 티셔츠를 맞추려고 한다. 
조마다 티셔츠를 맞추는 비용은 조에서 가장 키가 큰 원생과 가장 키가 작은 원생의 키 차이만큼 든다. 
최대한 비용을 아끼고 싶어 하는 태양이는 K개의 조에 대해 티셔츠 만드는 비용의 합을 최소로 하고 싶어한다. 
태양이를 도와 최소의 비용을 구하자.
 */

public class codingTest29 {
    static int n, k;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 유치원 원생 수
        k = Integer.parseInt(st.nextToken()); // 조의 개수

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve());


    }

    static int solve(){
        int result = 0;

        for(int i=1; i<n; i++){
            list.add(arr[i] - arr[i-1]);
        }

        Collections.sort(list);

        for(int i=0; i<n-k; i++){
            result += list.get(i);
        }

        return result;
    }
}
