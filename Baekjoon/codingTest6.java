package Baekjoon;

import java.util.*;
import java.io.*;

/**
 * 2580번 스도쿠
 * 
 * 스도쿠는 18세기 스위스 수학자가 만든 '라틴 사각형'이랑 퍼즐에서 유래한 것으로 현재 많은 인기를 누리고 있다. 
 * 이 게임은 아래 그림과 같이 가로, 세로 각각 9개씩 총 81개의 작은 칸으로 이루어진 정사각형 판 위에서 이뤄지는데, 게임 시작 전 일부 칸에는 1부터 9까지의 숫자 중 하나가 쓰여 있다.
 * 
 * 나머지 빈 칸을 채우는 방식은 다음과 같다.
- 각각의 가로줄과 세로줄에는 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
- 굵은 선으로 구분되어 있는 3x3 정사각형 안에도 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.

게임 시작 전 스도쿠 판에 쓰여 있는 숫자들의 정보가 주어질 때 모든 빈 칸이 채워진 최종 모습을 출력하는 프로그램을 작성하시오.
 */

class Pair{
    public int x, y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class codingTest6 {
    static int[][] sudoku = new int[9][9]; //스도쿠 숫자 저장
    static ArrayList<Pair> req = new ArrayList<>(); //스도쿠에서 채워야하는 숫자의 위치 저장

    //완성된 스도쿠 출력
    static void printSudoku(){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                sb.append(sudoku[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    //스도쿠에 들어갈 숫자가 조건을 만족하는지 검사
    static boolean isPossibleNum(int x, int y, int num){
        int x_start = (x/3)*3;
        int y_start = (y/3)*3;        

        for(int i=0; i<9; i++){
            //가로 기준 탐색
            if(sudoku[x][i] == num) return false;

            //세로 기준 탐색
            if(sudoku[i][y] == num) return false;

            //사각형 기준 탐색
            if(sudoku[x_start+i%3][y_start+i/3]==num) return false;
        }

        return true;
    }

    static void backtracking(int cnt){
        if(cnt == req.size()){ //채워넣어야 할 수 다 넣었으면 출력해야함
            printSudoku();
            System.exit(0);
        }

        int x = req.get(cnt).x;
        int y = req.get(cnt).y;
        
        for(int j=1; j<=9; j++){ //1~9까지 숫자 넣어봄
            if(isPossibleNum(x, y, j)){
                sudoku[x][y] = j;
                backtracking(cnt+1);
                sudoku[x][y] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<9;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0;j<9;j++){
                sudoku[i][j] = Integer.parseInt(st.nextToken());
                if(sudoku[i][j] == 0) req.add(new Pair(i,j));
            }
        }
        backtracking(0);

    }
}
