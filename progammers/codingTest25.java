package progammers;

import java.util.*;

public class codingTest25 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] flag = new boolean[n]; //false 디폴트 값
        
        for(int i=0; i<n; i++){
            if(!flag[i]) { //무조건 처음에는 false이기에 걸림
                DFS(computers, flag, i);
                answer++;
            }
        }
        
        
        return answer;
    }
    
    boolean[] DFS(int[][] c, boolean[] flag, int i){
        flag[i] = true; //이 함수 실행되면 i번째 flag는 true로 바꿔줌
        
        for(int k=0; k<c.length; k++){
            if(c[k][i] == 1 && flag[k]==false && c[i][k] == 1){ //flag[k]는 이전에 연결되어있는지의 여부 확인
                flag = DFS(c, flag, k);
            }
        }
        return flag;
    }
}
