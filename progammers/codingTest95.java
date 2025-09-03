package progammers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 프로그래머스 2019 카카오 개발자 겨울 인턴십 크레인 인형뽑기 게임
 */

public class codingTest95 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int m = Integer.parseInt(br.readLine());
        int[] moves = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            moves[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(board, moves));
    }

    static int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> sta = new Stack<>();
        
        for(int move:moves){
            int col = move-1;
            for(int row=0; row<board.length; row++){
                int tmp = board[row][col];
                if(tmp == 0)continue;
                
                board[row][col]=0;
                
                if(!sta.isEmpty() && sta.peek() == tmp){
                    sta.pop();
                    answer+=2;
                }
                else{
                    sta.push(tmp);
                }
                break;
            }
        }
        return answer;
    }
}
