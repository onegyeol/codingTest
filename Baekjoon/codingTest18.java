package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 25178번 두라무리 휴지
 * 
 * 기령이는 어느 날 캠릿브지 대학의 연결구과에 대해 알게 되었다. 
 * 캠릿브지 대학의 연결구과란, 단어를 이해함에 있어 한 단어 안에서 글자들이 어떤 순서로 배열되어 있는지는 중요하지 않고, 
 * 양 끝의 글자가 올바른지만 중요하다는 이론이다. 
 * 즉 단어의 글자가 섞이더라도 양 끝의 글자만 그대로라면 원래의 단어를 쉽게 유추하여 이해할 수 있다는 것이다.

그러나 기령이는 "durumari"와 같은 단어를 "daumurri"로 바꾸게 된다면 원래의 단어를 유추하기 매우 어려워진다는 사실을 발견했다. 
몇 날 며칠의 고민을 거듭한 끝에 위의 이론이 잘 작동할 수 있는 조건을 새롭게 찾아냈다.

한 단어를 재배열해 다른 단어를 만들 수 있어야 한다.
두 단어의 첫 글자와 마지막 글자는 서로 동일해야 한다.
각 단어에서 모음(a, e, i, o, u)을 제거한 문자열은 동일해야 한다.
기령이는 새로운 조건을 발견하게 해준 단어를 기려 이를 두라무리 효과라 부르기로 했다.

기령이는 이제 어떤 두 단어가 두라무리 효과를 발생시키는지 판별하고 싶다. 하지만 오랜 고민으로 지쳐 이를 판단할 기력이 남아있지 않다. 
지친 기령이를 대신하여 이를 판별하는 프로그램을 작성해보자
 */
public class codingTest18 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int n;
    private String s1, s2;

    public static void main(String[] args) throws Exception {
        new codingTest18().solution();
    }

    public void solution() throws IOException {
        n = Integer.parseInt(br.readLine());
        s1 = br.readLine();
        s2 = br.readLine();

        System.out.println((stringResort() && charMatch() && removeVowel()) ? "YES" : "NO");
    }

    // 한 단어를 재배열해 다른 단어를 만들 수 있어야 함
    public boolean stringResort() {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        return Arrays.equals(ch1, ch2); 
    }

    // 두 단어의 첫글자와 마지막 글자는 서로 동일해야 함
    public boolean charMatch() {
        return s1.charAt(0) == s2.charAt(0) && s1.charAt(n - 1) == s2.charAt(n - 1);
    }

    // 모음을 제거한 문자열은 동일해야 함
    public boolean removeVowel() {
        String replacS1 = s1.replaceAll("[aeiou]", ""); 
        String replacS2 = s2.replaceAll("[aeiou]", "");

        return replacS1.equals(replacS2);
    }

}
