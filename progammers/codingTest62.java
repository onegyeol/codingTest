package progammers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 프로그래머스 Lv.2 튜플
 * 
 * 예를 들어 튜플이 (2, 1, 3, 4)인 경우 이는

{{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
와 같이 표현할 수 있습니다. 이때, 집합은 원소의 순서가 바뀌어도 상관없으므로

{{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
{{2, 1, 3, 4}, {2}, {2, 1, 3}, {2, 1}}
{{1, 2, 3}, {2, 1}, {1, 2, 4, 3}, {2}}
는 모두 같은 튜플 (2, 1, 3, 4)를 나타냅니다.

특정 튜플을 표현하는 집합이 담긴 문자열 s가 매개변수로 주어질 때, s가 표현하는 튜플을 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 */

public class codingTest62 {

    public int[] solution(String s) {
        ArrayList<Integer> arr = new ArrayList<>();
        String[] str = s.split("\\},\\{"); //},{ 기준으로 나눔
        
        str[0] = str[0].replace("{{", ""); //처음과 마지막 애들은 {{ 이랑 }}를 지워줘야 함.
        str[str.length-1] = str[str.length-1].replace("}}", "");
        
        Arrays.sort(str, Comparator.comparingInt(String::length)); //길이 짧은 애들이 제일 앞에 오도록
        
        for(int i=0; i<str.length; i++){
            String[] str2 = str[i].split(","); //각 배열 안에서도 ,로 나눠줌
            for(int j=0; j<str2.length; j++){
                int n = Integer.parseInt(str2[j]);
                if(!arr.contains(n)) arr.add(n);
            }
        }

        return arr.stream().mapToInt(i -> i).toArray();
    }

    /**
     * public int[] solution(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b)->{return a.length() - b.length();}); //각 배열의 길이를 비교해 오름차순으로
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }
     */

}
