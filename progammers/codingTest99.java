package progammers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 프로그래머스 2021 KAKAO BLIND RECRUITMENT 신규 아이디 추천
 * 
 * 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
 * 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
 * 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
 * 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
 * 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
 * 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
 * 단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
 */

public class codingTest99 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String id = br.readLine();

        System.out.println(solution(id));
    }

    static String solution(String new_id) {
        String s = new_id.toLowerCase();
        
        // 소문자, 숫자, -, _, . 빼고 제거
        s = s.replaceAll("[^a-z0-9-_.]", "");
        
        // .이 2개 연속이면 하나로
        s = s.replaceAll("[.]{2,}", ".");
        
        // .이 처음(^)이나 끝($)에 있다면 제거
        s = s.replaceAll("^[.]|[.]$", "");
        
        if(s.isEmpty()) s = "a";
        
        // 길이 16 이상
        if(s.length() >= 16){
            s = s.substring(0, 15);
            s = s.replaceAll("[.]$", "");
        }
        
        while(s.length()<3){
            s+= s.charAt(s.length()-1);
        }
        
        return s;
    }
}
