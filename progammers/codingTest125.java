package progammers;

import java.util.ArrayList;
import java.util.List;

/*
 * 프로그래머스 Lv.2 행렬 테두리 회전하기
 * 
 * 행렬의 세로 길이(행 개수) rows, 가로 길이(열 개수) columns, 그리고 회전들의 목록 queries가 주어질 때, 
 * 각 회전들을 배열에 적용한 뒤, 그 회전에 의해 위치가 바뀐 숫자들 중 가장 작은 숫자들을 순서대로 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 */

public class codingTest125 {
    static int matrix[][];

    public static void main(String[] args) {
        
    }

    // 배열 초기화
    static void initializeMatrix(int rows, int columns) {
        matrix = new int[rows][columns];
        int value = 1;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = value++;
            }
        }
    }
    
    public int[] solution(int rows, int columns, int[][] queries) {
        initializeMatrix(rows, columns);
        List<Integer> arr = new ArrayList<>();
        
        for(int i=0; i<queries.length; i++){
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];
            
            arr.add(rotate(x1, y1, x2, y2));
        }
        return arr.stream().mapToInt(i -> i).toArray();
    }

    // 회전
    static int rotate(int r1, int c1, int r2, int c2){
        int x1 = r1-1;
        int y1 = c1-1;
        int x2 = r2-1;
        int y2 = c2-1;
        
        // 첫번째 값 저장 
        int tmp = matrix[x1][y1];
        int min = tmp;
        
        // 왼쪽 아래 -> 위 (row 변경, column 동일)
        for(int i=x1; i<x2; i++){
            matrix[i][y1] = matrix[i+1][y1];
            min = Math.min(matrix[i][y1], min); 
        }
        
        // 아랫변 오른쪽 -> 왼쪽 (row 동일, column 변경)
        for(int j=y1; j<y2; j++){
            // 오른쪽의 값이 대입되는 중
            matrix[x2][j] = matrix[x2][j+1];
            min = Math.min(matrix[x2][j], min);
        }
        
        // 오른쪽 위 -> 아래
        for(int i=x2; i>x1; i--){
            matrix[i][y2] = matrix[i-1][y2];
            min = Math.min(matrix[i][y2], min);
        }
        
        // 윗변 왼쪽 -> 오른쪽
        for(int j=y2; j>y1; j--){
            matrix[x1][j] = matrix[x1][j-1];
            min = Math.min(matrix[x1][j], min);
        }
        
        matrix[x1][y1+1] = tmp;
        
        return min;
    }


}
