package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
 * 백준 1361번 두 스트링 마스크
 * 
 * 두 개의 문자열 S1과 S2가 주어진다. 각각의 문자열은 몇 개의 알파벳 대문자와 하나의 별표(*)가 있다.
 * 별표를 알파벳 대문자로 이루어진 문자열로 대체해서 (빈 문자열로 대체하는 것도 가능) 두 문자열을 같게 만들어야 한다.
 * 가능한 문자열 중 최소 길이인 문자열을 출력하는 프로그램을 작성하시오. 만약 불가능할 때는 -1을 출력한다.
 */

public class codingTest118 {
    // P의 접미사와 S의 접두사가 일치하는 모든 겹침 길이를 찾기 위해 pi 배열을 반환
    static int[] getPi(String P, String S) {
        if (P.isEmpty() || S.isEmpty()) {
            return new int[0];
        }
        String t = S + "#" + P; // S의 접두사와 P의 접미사를 비교하기 위해 P를 뒤에 둠
        int[] pi = new int[t.length()];
        for (int i = 1; i < t.length(); i++) {
            int j = pi[i - 1];
            while (j > 0 && t.charAt(i) != t.charAt(j)) {
                j = pi[j - 1];
            }
            if (t.charAt(i) == t.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        return pi;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        int i1 = s1.indexOf('*');
        int i2 = s2.indexOf('*');

        String pre1 = s1.substring(0, i1);
        String suf1 = s1.substring(i1 + 1);
        String pre2 = s2.substring(0, i2);
        String suf2 = s2.substring(i2 + 1);

        // 긴 쪽의 시작이 짧은 쪽 단어로 시작해야함
        if (pre1.length() <= pre2.length()) {
            if (!pre2.startsWith(pre1)) { System.out.println(-1); return; }
        } else {
            if (!pre1.startsWith(pre2)) { System.out.println(-1); return; }
        }

        // 긴 쪽의 끝이 짧은 쪽 단어로 끝나야함
        if (suf1.length() <= suf2.length()) {
            if (!suf2.endsWith(suf1)) { System.out.println(-1); return; }
        } else {
            if (!suf1.endsWith(suf2)) { System.out.println(-1); return; }
        }

        String P = (pre1.length() >= pre2.length()) ? pre1 : pre2;
        String S = (suf1.length() >= suf2.length()) ? suf1 : suf2;

        int[] pi = getPi(P, S);
        if (pi.length == 0) { // P 또는 S가 비어있는 경우
            System.out.println(P + S);
            return;
        }
        
        int minRequiredLen = Math.max(pre1.length() + suf1.length(), pre2.length() + suf2.length());

        int k = pi[pi.length - 1]; // 최대 겹침 길이부터 시작

        boolean found = false;
        while (true) {
            // 현재 겹침 길이 k로 만들었을 때의 총 길이
            int currentLen = P.length() + S.length() - k;
            if (currentLen >= minRequiredLen) {
                System.out.println(P + S.substring(k));
                found = true;
                break;
            }

            if (k <= 0) { // 더 이상 줄일 겹침이 없으면 종료
                break;
            }
            // pi 체인을 따라 다음으로 작은 겹침 길이로 이동
            k = pi[k - 1];
        }

        if (!found) {
            // 모든 가능한 겹침을 시도했지만 최소 길이를 만족시키지 못함
            System.out.println(-1);
        }
    }
}