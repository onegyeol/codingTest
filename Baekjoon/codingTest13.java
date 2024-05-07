package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 백준 2210번 숫자판 점프
 * 
 * 5×5 크기의 숫자판이 있다. 
 * 각각의 칸에는 숫자(digit, 0부터 9까지)가 적혀 있다. 
 * 이 숫자판의 임의의 위치에서 시작해서, 인접해 있는 네 방향으로 다섯 번 이동하면서, 
 * 각 칸에 적혀있는 숫자를 차례로 붙이면 6자리의 수가 된다. 
 * 이동을 할 때에는 한 번 거쳤던 칸을 다시 거쳐도 되며, 0으로 시작하는 000123과 같은 수로 만들 수 있다.

숫자판이 주어졌을 때, 만들 수 있는 서로 다른 여섯 자리의 수들의 개수를 구하는 프로그램을 작성하시오.
 */


public class codingTest13 {
    static int[] dx = {-1, 0, 1, 0}; //네 방향 이동 위한 배열
    static int[] dy = {0, 1, 0, -1};
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String[][] board = new String[5][5]; //숫자판

        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                board[i][j] = st.nextToken();
            }
        }

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                DFS(i, j, 0, board, board[i][j]);
            }
        }

        System.out.println(list.size());

    }
    public static void DFS(int x, int y, int cnt, String[][] m, String s){
        if(cnt == 5){ //0부터 카운트하기에
            if(!list.contains(s)) list.add(s); //없는 숫자라면 리스트에 추가
            return;
        }
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<5 && ny>=0 && ny<5){
                DFS(nx, ny, cnt+1, m, s+m[nx][ny]);
            }
        }
        
    }
}

