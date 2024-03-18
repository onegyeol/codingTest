package progammers;

/**
 * 프로그래머스 Lv.3 정수 삼각형
 * 
 * 위와 같은 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 합니다. 
 * 아래 칸으로 이동할 때는 대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로만 이동 가능합니다. 
 * 예를 들어 3에서는 그 아래칸의 8 또는 1로만 이동이 가능합니다.

삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어질 때, 거쳐간 숫자의 최댓값을 return 하도록 solution 함수를 완성하세요.
 */

public class codingTest69 {
    public int solution(int[][] triangle){        
        for(int i=triangle.length-1; i>=1; i--){ //위에서 아래로 구현하는 것보다 아래에서 위로 구현하는 것이 더 간결함
            for(int j=0; j<triangle[i].length-1; j++){
                triangle[i-1][j] += Math.max(triangle[i][j], triangle[i][j+1]); //두 값중 더 큰 값을 더해줌
            }
        }
        return triangle[0][0];
    }

    /**
     * 다른사람 코드
     * public int solution(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i-1][0];
            triangle[i][i] += triangle[i-1][i-1];
            for (int j = 1; j < i; j++) 
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
        }

        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    }
     */
}
