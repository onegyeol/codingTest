package progammers;

/*
 * 프로그래머스 Lv.2 쿼드 압축 후 개수 세기
 * 
 * 0과 1로 이루어진 2n x 2n 크기의 2차원 정수 배열 arr이 있습니다. 당신은 이 arr을 쿼드 트리와 같은 방식으로 압축하고자 합니다. 구체적인 방식은 다음과 같습니다.

당신이 압축하고자 하는 특정 영역을 S라고 정의합니다.
만약 S 내부에 있는 모든 수가 같은 값이라면, S를 해당 수 하나로 압축시킵니다.
그렇지 않다면, S를 정확히 4개의 균일한 정사각형 영역(입출력 예를 참고해주시기 바랍니다.)으로 쪼갠 뒤, 각 정사각형 영역에 대해 같은 방식의 압축을 시도합니다.

 * arr이 매개변수로 주어집니다. 위와 같은 방식으로 arr을 압축했을 때, 
 * 배열에 최종적으로 남는 0의 개수와 1의 개수를 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
 */

public class codingTest119 {
    public static void main(String[] args) {
        // arr 입력 받음
    }

    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        quardtree(arr, 0, 0, arr.length, answer);
        return answer;
    }
    
    // 균일한 4개의 사각형 만듦
    public void quardtree(int[][] arr, int x, int y, int len, int[] answer){
        if(isSame(arr, x, y, len)){
            if(arr[x][y] == 0) answer[0]++;
            else answer[1] ++;
            return ;
        }
        
        int half = len/2;
        quardtree(arr, x, y, half, answer);
        quardtree(arr, x+half, y, half, answer);
        quardtree(arr, x, y+half, half, answer);
        quardtree(arr, x+half, y+half, half, answer);
    }
    
    // 각각의 사각형이 동일한 값인지 ?
    private boolean isSame(int[][] arr, int x, int y, int len){
        int tmp = arr[x][y];
        
        for(int i=x; i<x+len; i++){
            for(int j=y; j<y+len; j++){
                if(tmp != arr[i][j]) return false;
            }
        }
        
        return true;
    }
}
