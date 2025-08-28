package progammers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 프로그래머스 2020 카카오 인턴십 키패드 누르기
 */

public class codingTest94 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i>n; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        String hand = br.readLine();
        
        System.out.println(solution(numbers, hand));
    }

    private static StringBuilder solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int left = 10;
        int right = 12;
        
        for (int num : numbers) {
            // 왼쪽 열
            if (num == 1 || num == 4 || num == 7) {
                sb.append('L');
                left = num;
                continue;
            }
            // 오른쪽 열
            if (num == 3 || num == 6 || num == 9) {
                sb.append('R');
                right = num;
                continue;
            }
            
            int target = (num==0)?11:num;
            int[] t = pos(target); // 눌러야 할 숫자의 위치
            int[] lp = pos(left); // 왼쪽 손의 위치
            int[] rp = pos(right); // 오른쪽 손의 위치
            
            int dL = Math.abs(lp[0] - t[0]) + Math.abs(lp[1] - t[1]);
            int dR = Math.abs(rp[0] - t[0]) + Math.abs(rp[1] - t[1]);
            
            if(dL<dR){
                sb.append("L");
                left = target;
            }
            else if(dL>dR){
                sb.append("R");
                right = target;
            }
            else{
                if(hand.equals("left")){
                    sb.append("L");
                    left = target;
                }
                else{
                    sb.append("R");
                    right = target;
                }
            }
        }
        return sb;
    }
    
    private static int[] pos(int key) {
        if (key == 0) key = 11;     // 0을 11로 매핑
        int x = (key - 1) % 3;      // 0:왼, 1:중앙, 2:오른
        int y = (key - 1) / 3;      // 0~3 행
        return new int[]{x, y};
    }
}
