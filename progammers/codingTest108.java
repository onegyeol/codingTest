package progammers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 프로그래머스 Lv.1 햄버거 만들기

 */

public class codingTest108 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] ingredient = new int[n];

        for(int i=0; i<n; i++){
            ingredient[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(ingredient));
    }

    static int solution(int[] ingredient) {
        int answer = 0;
        
        Stack<Integer> sta = new Stack<>();
        
        for(int i : ingredient){
            sta.push(i);
            
            if(sta.size()>=4){
                int size = sta.size();
                if (sta.get(size-4) == 1 &&
                    sta.get(size-3) == 2 &&
                    sta.get(size-2) == 3 &&
                    sta.get(size-1) == 1) {
                    
                    answer++;
                    sta.pop();
                    sta.pop();
                    sta.pop();
                    sta.pop();
                }
            }
        }
        return answer;
        
    }
}
