package progammers;

/*
 * 프로그래머스 Lv.2 삼각 달팽이
 * 
 * 정수 n이 매개변수로 주어집니다. 
 * 다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후,
 *  첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.
 */

public class codingTest114 {
    public static void main(String[] args) {
        // n 입력 받음
    }

    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] arr = new int[n][n];
        
        int x=-1;
        int y=0;
        int num=1;
        
        
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(i%3==0){
                    x++;
                }
                else if(i%3==1){
                    y++;
                }
                else if(i%3==2){
                    x--;
                    y--;
                }
                arr[x][y] = num++;
            }
        }
        
        int idx=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 0 ) break;
                answer[idx++] = arr[i][j];
            }
        }
        
        
        return answer;
    }
}
