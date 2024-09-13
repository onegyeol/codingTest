package Baekjoon;

import java.util.*;
import java.io.*;

/**
 * 백준 2096번 내려가기
 * 
 * N줄에 0 이상 9 이하의 숫자가 세 개씩 적혀 있다. 내려가기 게임을 하고 있는데, 이 게임은 첫 줄에서 시작해서 마지막 줄에서 끝나게 되는 놀이이다.
먼저 처음에 적혀 있는 세 개의 숫자 중에서 하나를 골라서 시작하게 된다. 그리고 다음 줄로 내려가는데, 다음 줄로 내려갈 때에는 다음과 같은 제약 조건이 있다. 
바로 아래의 수로 넘어가거나, 아니면 바로 아래의 수와 붙어 있는 수로만 이동할 수 있다는 것이다. 이 제약 조건을 그림으로 나타내어 보면 다음과 같다.
 숫자표가 주어져 있을 때, 얻을 수 있는 최대 점수, 최소 점수를 구하는 프로그램을 작성하시오. 점수는 원룡이가 위치한 곳의 수의 합이다.
 */
public class codingTest30 {
    static int[] dx = {-1, 1, 0}; //  바로 아래 수의 좌우에 접근하기 위함
    static int n;
    static int[][] arr;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        arr = new int[n][3];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 최대, 최소 점수 저장할 배열
        int[] dpMax = new int[3];
        int[] dpMin = new int[3];
        int[] tempMax = new int[3]; // 해당 행 max 값
        int[] tempMin = new int[3];

        // 첫번째 줄로 값 초기화
        for(int i=0; i<3; i++){
            dpMax[i] = arr[0][i];
            dpMin[i] = arr[0][i];
        }

        for(int i=1; i<n; i++){
            tempMax[0] = arr[i][0] + Math.max(dpMax[0], dpMax[1]); //바로 아래의 수와 붙어있는 수로만 이동할 수 있기에 dpMax[2]는 접근 X
            tempMax[1] = arr[i][1] + Math.max(Math.max(dpMax[0], dpMax[1]), dpMax[2]);
            tempMax[2] = arr[i][2] + Math.max(dpMax[1], dpMax[2]);

            tempMin[0] = arr[i][0] + Math.min(dpMin[0], dpMin[1]);
            tempMin[1] = arr[i][1] + Math.min(Math.min(dpMin[0], dpMin[1]), dpMin[2]);
            tempMin[2] = arr[i][2] + Math.min(dpMin[1], dpMin[2]);

            for(int j=0; j<3; j++){
                dpMax[j] = tempMax[j];
                dpMin[j] = tempMin[j];
            }
        }

        int max = Math.max(Math.max(dpMax[0], dpMax[1]), dpMax[2]);
        int min = Math.min(Math.min(dpMin[0], dpMin[1]), dpMin[2]);

        System.out.println(max + " " + min);
    }

 
}
