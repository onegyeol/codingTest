package progammers;

import java.util.*;
import java.util.stream.Stream;

class Solution {
    public String solution(String s) {
        String answer = "";
        int[] arr = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray(); //문자열을 공백 기준으로 나눔
        
        
        answer += Integer.toString(Arrays.stream(arr).min().getAsInt()); //스트림을 통해 최소값을 찾고 그 값을 문자형으로 바꿔줌
        answer += " ";
        answer += Integer.toString(Arrays.stream(arr).max().getAsInt());
        
        return answer;
    }
}
