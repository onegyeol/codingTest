package progammers;

import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] arr = s.toCharArray();
        answer += String.valueOf(Character.toUpperCase(arr[0])); //첫번째 친구 대문자로 바꿔서 바로 answer에 넣어주기. 
        
        for(int i=1; i<arr.length; i++){
            if(arr[i-1] == ' ' && Character.isLetterOrDigit(arr[i])){ //앞에 공백이고 영문자/숫자일때 대문자로 바꿔줌. 첫글자란 소리니까
                 answer += String.valueOf(Character.toUpperCase(arr[i]));
            }
            else{
                answer += String.valueOf(Character.toLowerCase(arr[i])); //나머지의 경우에는 다 소문자로 바꿔주기
            }
        }
        return answer;
    }
}

/** 다른 사람의 풀이 
 * class Solution {
  public String solution(String s) {
        String answer = "";
        String[] sp = s.toLowerCase().split(""); 모든 문자열 일단 소문자로 바꿔준 뒤 문자단위로 쪼개기
        boolean flag = true;

        for(String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss; flag가 true일 때 answer에 ss넣어줌
            flag = ss.equals(" ") ? true : false; ss가 공백이면 flag true로 해줌, 아니면 false로
        }

        return answer;
  }
}
 */