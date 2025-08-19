package progammers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 프로그래머스 [PCCE 기출문제] 9번 / 이웃한 칸
 *
 */

public class codingTest90 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        String[][] board = new String[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = st.nextToken();
            }
        }

        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        System.out.println(solution(board, h, w));
        
    }

    static int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        
        for(int i=0; i<4; i++){
            int nx = h+dh[i];
            int ny = w+dw[i];
            
            if(nx>=0 && nx<board[0].length && ny>=0 && ny<board.length){
                if(board[nx][ny].equals(board[h][w])) answer++;
            }
        }
        return answer;
    }
}
