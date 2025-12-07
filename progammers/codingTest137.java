package progammers;

import java.util.Arrays;

/*
 * 프로그래머스 Lv.2 가장 큰 수
예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
*/

public class codingTest137 {
    public static void main(String[] args) {
        // numbers 입력 받음
    }

    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        
        // "6"+"10" → "610"
        // "10"+"6" → "106"
        // "610"이 "106"보다 크므로 → 6을 10 앞에 배치해야 함.
        Arrays.sort(arr, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        
        if(arr[0].equals("0")){
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(String s : arr){
            sb.append(s);
        }
        
        return sb.toString();
    }
}
