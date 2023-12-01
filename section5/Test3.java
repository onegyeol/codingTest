package section5;

import java.util.*;

public class Test3 {
    public int solution(int n, int[][] board, int m, int[] moves){
        int answer=0;
        Stack<Integer> sta = new Stack<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[j][moves[i]-1] != 0 ){
                    if(sta.isEmpty()) {
                        sta.push(board[j][moves[i]-1]); 
                    }
                    else if(sta.peek() == board[j][moves[i]-1]) {
                        answer += 2;
                        sta.pop();
                    } 
                    else {
                        sta.push(board[j][moves[i]-1]);
                    }
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Test3 t = new Test3();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] board = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = in.nextInt();
            }
        }

        int m = in.nextInt();
        int[] moves = new int[m];

        for(int i=0; i<m; i++) moves[i] = in.nextInt();

        System.out.println(t.solution(n, board, m, moves));


    }
}
