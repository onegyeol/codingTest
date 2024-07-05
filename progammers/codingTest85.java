package progammers;

/**
 * 프로그래머스 Lv.3 등굣길 
 * 
 * 가장 왼쪽 위, 즉 집이 있는 곳의 좌표는 (1, 1)로 나타내고 가장 오른쪽 아래, 즉 학교가 있는 곳의 좌표는 (m, n)으로 나타냅니다.

격자의 크기 m, n과 물이 잠긴 지역의 좌표를 담은 2차원 배열 puddles이 매개변수로 주어집니다. 
오른쪽과 아래쪽으로만 움직여 집에서 학교까지 갈 수 있는 최단경로의 개수를 1,000,000,007로 나눈 나머지를 return 하도록 solution 함수를 작성해주세요.

최단 경로를 구하기 위한 점화식  board[i][j] += board[i-1][j] + board[i][j-1] 사용하기
왜냐면 오른쪽과 아래쪽으로만 움직일 수 있기 때문
 */
public class codingTest85 {
    public int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;

        int[][] board = new int[m+1][n+1];

        for(int i=0; i<puddles.length; i++){
            board[puddles[i][1]][puddles[i][0]] = -1;
        }

        board[1][1] = 1;

        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(board[i][j] == -1) continue;
                if(board[i-1][j] > 0) board[i][j] += board[i-1][j] % mod;
                if(board[i][j-1] > 0) board[i][j] += board[i][j-1] % mod;
            }
        }

        return board[n][m] % mod;
    }

}
