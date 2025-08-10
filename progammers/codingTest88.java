package progammers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 프로그래머스 Lv.0 옹알이(1)
 * 
 * 머쓱이는 태어난 지 6개월 된 조카를 돌보고 있습니다. 
 * 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음을 최대 한 번씩 사용해 조합한(이어 붙인) 발음밖에 하지 못합니다. 
 * 문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
 */

public class codingTest88 {
    static String[] arr  = {"aya", "ye", "woo", "ma"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String[] babbling = new String[n];
        
        for(int i=0; i<n; i++){
            babbling[i] = br.readLine();
        }

        System.out.println(solution(babbling));
    }

    public static int solution(String[] babbling){
        int answer=0;

        for(int i=0; i<babbling.length; i++){
            String babble = babbling[i];
            int start=0;
            boolean valid=true;
            
            while(start < babble.length()){
                boolean found = false;

                for(int k=0; k<4; k++){
                    if(babble.startsWith(arr[k], start)){
                        start += arr[k].length(); // 해당 옹알이 길이만큼 이동
                        found = true;
                        break;
                    }
                }

                if(!found){ // 발음할 수 있는 옹알이 없으면 찾을 필요 없음
                    valid = false;
                    break;
                }
            }

            if(valid) answer++;
        }

        return answer;
    }
}
