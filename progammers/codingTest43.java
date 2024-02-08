package progammers;

import java.util.*;

/**
 * 프로그래머스 Lv.1 숫자 짝꿍
 * 
 * 두 정수 X, Y의 임의의 자리에서 공통으로 나타나는 정수 k(0 ≤ k ≤ 9)들을 이용하여 만들 수 있는 가장 큰 정수를 두 수의 짝꿍이라 합니다
 * (단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다). 
 * X, Y의 짝꿍이 존재하지 않으면, 짝꿍은 -1입니다. 
 * X, Y의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.

예를 들어, X = 3403이고 Y = 13203이라면, X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 3, 0, 3으로 만들 수 있는 가장 큰 정수인 330입니다. 
다른 예시로 X = 5525이고 Y = 1255이면 X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 2, 5, 5로 만들 수 있는 가장 큰 정수인 552입니다
(X에는 5가 3개, Y에는 5가 2개 나타나므로 남는 5 한 개는 짝 지을 수 없습니다.)
두 정수 X, Y가 주어졌을 때, X, Y의 짝꿍을 return하는 solution 함수를 완성해주세요.
 */

public class codingTest43 {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder(); //answer을 stringBuilder 타입으로 바꾸니 런타임 에러 해결됨

        //주어진 X와 Y를 내림차순으로 정렬해서 제일 큰 수 만들도록
        char[] tmp1 = X.toCharArray();
        Arrays.sort(tmp1);
        StringBuilder x = new StringBuilder(new String(tmp1)).reverse();
        
        char[] tmp2 = Y.toCharArray();
        Arrays.sort(tmp2);
        StringBuilder y = new StringBuilder(new String(tmp2)).reverse();
        
        int i = 0, j = 0;
        while (i < x.length() && j < y.length()) {
            if (x.charAt(i) == y.charAt(j)) {
                answer.append(x.charAt(i));
                i++;
                j++;
            } else if (x.charAt(i) < y.charAt(j)) j++;
            else i++;
            
        }
        
        if (answer.toString().equals("")) return "-1"; //짝꿍 없으면 -1 리턴
        else if (answer.toString().startsWith("0")) return "0"; //0으로 시작되면 0이기에 0 리턴
        else return answer.toString();
    }

}
