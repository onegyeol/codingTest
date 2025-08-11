package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 1100번 하얀 칸
 * 
 * 체스판은 8×8크기이고, 검정 칸과 하얀 칸이 번갈아가면서 색칠되어 있다. 
 * 가장 왼쪽 위칸 (0,0)은 하얀색이다. 체스판의 상태가 주어졌을 때, 하얀 칸 위에 말이 몇 개 있는지 출력하는 프로그램을 작성하시오.
 */

public class coidngTest114 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] board = new char[8][8];
        int answer=0;

        for(int i=0; i<8; i++){
            String str = br.readLine();
            for(int j=0; j<8; j++){
                board[i][j] = str.charAt(j);

                if((j%2==0 && i%2==0) || (j%2!=0 && i%2!=0)) {
                    if(board[i][j]=='F') answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
