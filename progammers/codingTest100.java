package progammers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 프로그래머스 2025 프로그래머스 코드챌린지 2차 예선 택배 상자 꺼내기
 * 
 * 창고에 있는 택배 상자의 개수를 나타내는 정수 n, 가로로 놓는 상자의 개수를 나타내는 정수 w와 꺼내려는 택배 상자의 번호를 나타내는 정수 num이 매개변수로 주어집니다. 이때, 꺼내야 하는 상자의 총개수를 return 하도록 solution 함수를 완성해 주세요.
 */

public class codingTest100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        System.out.println(solution(n, w, num));
        
    }

    static int solution(int n, int w, int num) {
        int cols = w;
        int rows = (n + w - 1) / w;
        int[][] arr = new int[rows][cols];

        int k = 1;
        boolean leftToRight = true;

        for (int i = rows - 1; i >= 0; i--) {
            if (leftToRight) {
                for (int j = 0; j < cols && k <= n; j++) arr[i][j] = k++;
            } else {
                for (int j = cols - 1; j >= 0 && k <= n; j--) arr[i][j] = k++;
            }
            leftToRight = !leftToRight;
        }

        // num의 위치(행, 열) 찾기
        int numRow = -1;
        int numCol = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == num) {
                    numRow = i;
                    numCol = j;
                    break;
                }
            }
            if (numRow != -1) break;
        }

        int answer = 0;
        for (int i = numRow; i >= 0; i--) {
            if (arr[i][numCol] != 0) answer++;
        }

        return answer;
    }
}
