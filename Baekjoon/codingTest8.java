package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class codingTest8 {
    static int t;
    static String[][] board;
    static String[] answer, register;

    static void BFS(int index, int cnt){
        if((board[index][0]).equals(board[index][1])){
            if(answer[index].length() > cnt) answer[index] = register[index];
        }
        else{
            
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = br.read();
        board = new String[t][2];
        answer = new String[t];
        register = new String[t];
        
        for(int i=0; i<t; i++){
            String[] str = br.readLine().split(" ");

            board[i][0] = str[0];
            board[i][1] = str[1];
            BFS(0, 0);
        }



        for(int i=0; i<t; i++){
            System.out.println(answer[i]);
        }

    }
}
