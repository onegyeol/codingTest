package progammers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 프로그래머스 Lv.1 PCCP 기출문제 [PCCP 기출문제] 1번 / 동영상 재생기
 */

public class codingTest103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String video_len = br.readLine();
        String pos = br.readLine();
        String op_start = br.readLine();
        String op_end = br.readLine();

        int n = Integer.parseInt(br.readLine());
        String[] commands = new String[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            commands[i] = st.nextToken();
        }

        System.out.println(solution(video_len, pos, op_start, op_end, commands));
    }

    static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int videoSec = toSeconds(video_len);
        int curSec   = toSeconds(pos);
        int opStart  = toSeconds(op_start);
        int opEnd    = toSeconds(op_end);
        
        for(int i=0; i<commands.length; i++){
            if(opStart <= curSec && curSec <= opEnd) curSec = opEnd;
            
            if(commands[i].equals("next")){
                curSec = Math.min(videoSec, curSec+10);
            }
            else{
                curSec = Math.max(0, curSec-10);
            }
            
            if(opStart <= curSec && curSec <= opEnd) curSec = opEnd;
        }
        return toTime(curSec);
    }
    
    static int toSeconds(String str){
        String[] time = str.split(":");
        
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
    
    static String toTime(int str){
        int m = str / 60;
        int s = str % 60;
        return String.format("%02d:%02d", m, s);
    }
}
