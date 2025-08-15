package progammers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 프로그래머스 Lv.1 [PCCE 기출문제] 9번 / 지폐 접기
 * 
 * 지폐를 접을 때는 항상 길이가 긴 쪽을 반으로 접습니다.
 * 접기 전 길이가 홀수였다면 접은 후 소수점 이하는 버립니다.
 * 접힌 지폐를 그대로 또는 90도 돌려서 지갑에 넣을 수 있다면 그만 접습니다.
 * 
 * 지갑의 가로, 세로 크기를 담은 정수 리스트 wallet과 지폐의 가로, 세로 크기를 담은 정수 리스트 bill가 주어질 때, 지갑에 넣기 위해서 지폐를 최소 몇 번 접어야 하는지 return하도록 solution함수를 완성해 주세요.
 * 지폐를 지갑에 넣기 위해 접어야 하는 최소 횟수를 구하는 과정은 다음과 같습니다.
 */

public class codingTest89 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] wallet = new int[2];
        int[] bill = new int[2];

        for(int i=0; i<2; i++){
            wallet[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<2; i++){
            bill[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wallet);
        Arrays.sort(bill);

        System.out.println(solution(wallet, bill));
    }

    static int solution(int[] wallet, int[] bill){
        int answer=0;

        while(wallet[0]<bill[0] || wallet[1]<bill[1]){
            bill[1]/=2;
            answer++;

            Arrays.sort(bill);
        }

        return answer;
    }
}
