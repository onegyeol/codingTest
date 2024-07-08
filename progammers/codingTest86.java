package progammers;

/**
 * 프로그래머스 Lv.2 n진수 게임
 * 
 * 이진수로 진행하는 게임에 익숙해져 질려가던 사람들은 좀 더 난이도를 높이기 위해 이진법에서 십육진법까지 모든 진법으로 게임을 진행해보기로 했다. 
 * 숫자 게임이 익숙하지 않은 튜브는 게임에 져서 벌칙을 받는 굴욕을 피하기 위해, 
 * 자신이 말해야 하는 숫자를 스마트폰에 미리 출력해주는 프로그램을 만들려고 한다. 
 * 튜브의 프로그램을 구현하라.
 * 
 * 진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p 가 주어진다.
 */

public class codingTest86 {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        for(int i=0; i<t; i++){
            String s = Integer.toString(i, n);
            System.out.println(s);
            answer += s;
        }
        return answer;
    }

}
