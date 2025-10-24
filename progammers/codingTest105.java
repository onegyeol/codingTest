package progammers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 프로그래머스 Lv.2 2019 KAKAO BLIND RECRUITMENT 오픈채팅방
 */

public class codingTest105 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] record = new String[n];

        for(int i=0; i<n; i++){
            record[i] = br.readLine();
        }

        System.out.println(solution(record));
    }

    static String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>(); 
        List<String> logs = new ArrayList<>();  

        for (String rec : record) {
            String[] input = rec.split(" ");
            String command = input[0];
            String userid = input[1];

            // Enter와 Change만 신경쓰면 됨
            if (command.equals("Enter") || command.equals("Change")) {
                String nickname = input[2];
                map.put(userid, nickname); // 최신 닉네임 저장
            }
        }

        for (String rec : record) {
            String[] input = rec.split(" ");
            String command = input[0];
            String userid = input[1];

            if (command.equals("Enter")) {
                logs.add(map.get(userid) + "님이 들어왔습니다.");
            } else if (command.equals("Leave")) {
                logs.add(map.get(userid) + "님이 나갔습니다.");
            }
        }

        return logs.toArray(new String[0]);
    }
}
