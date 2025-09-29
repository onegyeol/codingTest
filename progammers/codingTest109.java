package progammers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 프로그래머스 Lv.2 2018 KAKAO BLIND RECRUITMENT [1차] 프렌즈4블록
 */

public class codingTest109 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        String[] board = new String[m];
        
        for(int i=0; i<m; i++){
            board[i] = br.readLine();
        }

        System.out.println(solution(m, n, board));
    }

    static int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] word = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                word[i][j] = board[i].charAt(j);
            }
        }
        
        while (true) {
            boolean[][] removed = new boolean[m][n];
            int count = markRemovableBlocks(word, removed); // 삭제할 블록 갯수
            if (count == 0) break; // 터뜨릴게 없다면 멈춤
            answer += count;
            dropBlocks(word, removed); //  블록 삭제
        }
        return answer;
    }

    // 2x2 블록 탐색 후 제거할 위치 표시
    static int markRemovableBlocks(char[][] word, boolean[][] removed) {
        int m = word.length;
        int n = word[0].length;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char c = word[i][j];
                // 제거할 위치 찾음
                if (c != '-' &&
                    c == word[i][j + 1] &&
                    c == word[i + 1][j] &&
                    c == word[i + 1][j + 1]) {
                    removed[i][j] = removed[i][j + 1] =
                    removed[i + 1][j] = removed[i + 1][j + 1] = true;
                }
            }
        }

        // true 개수 세기
        int cnt = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (removed[i][j]) cnt++;
        return cnt;
    }

    // 밑으로 떨어트림
    static void dropBlocks(char[][] word, boolean[][] removed) {
        int m = word.length;
        int n = word[0].length;

        for (int col = 0; col < n; col++) {
            int write = m - 1;
            for (int row = m - 1; row >= 0; row--) {
                if (!removed[row][col]) {
                    word[write--][col] = word[row][col];
                }
            }
            while (write >= 0) {
                word[write--][col] = '-'; // 빈칸 채우기
            }
        }
    }
}
