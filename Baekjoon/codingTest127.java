package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

/*

백준 1036번 36진수

36진법의 숫자는 0부터 9까지의 수와 알파벳 A에서 Z로 나타낸다. A부터 Z까지 알파벳은 10부터 35에 차례대로 대응한다.
36진법의 수 N개가 주어진다. 36진법 숫자(0-9, A-Z) 중에서 K개의 숫자를 고른다. 그러고 나서 N개의 수 모두에서 나타난 그 숫자를 Z로 바꾼다. 그 이후에 N개의 수를 모두 더한다.
이때 가능한 합의 최댓값을 구하는 프로그램을 작성하시오. 합의 최댓값도 36진수로 출력한다.


A는 10인데 Z로 바꾸기 위해 25증가
만약 그 자리의 자릿수 값이 36^자리라면
25X35^자리가 증가량임
예를 들어 
1245에서 두번째 자리 4를 8로 바꾸게 되면 단순히 4 -> 8로 생각할 수 있지만,

실제 값 비교: 1245 → 1285  증가량 = 40
증가한 숫자(4) × 해당 자리의 값(10^1 = 10)
→ 4 × 10 = 40

그렇기에 36진수도 이렇게 푸는 것 !
*/

public class codingTest127 {
    static int charToVal(char c) {
        return c <= '9' ? c - '0' : c - 'A' + 10;
    }

    static char valToChar(int v) {
        return v < 10 ? (char) ('0' + v) : (char) ('A' + (v - 10));
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // 입력받는 문자열 중 최대 길이 알아내기 위함
        int maxLen = 0;

        String[] word = new String[n];
        
        for (int i = 0; i < n; i++) {
            word[i] = br.readLine();
            maxLen = Math.max(maxLen, word[i].length());
        }

        int k = Integer.parseInt(br.readLine());

        // 총 합 0으로 초기화
        BigInteger total = BigInteger.ZERO;
        // 각 숫자를 Z로 바꿨을 시 얼마나 증가되는지 알기 뒤함
        BigInteger[] gain = new BigInteger[36];
        for(int i=0; i<36; i++) gain[i] = BigInteger.ZERO;

        // 36 거듭제곱 계산
        BigInteger[] pow36 = new BigInteger[maxLen];
        pow36[0] = BigInteger.ONE; // 0은 마지막 자리, 1은 마지막에서 두번째 자리 ...

        for(int i=1; i<maxLen; i++) pow36[i] = pow36[i-1].multiply(BigInteger.valueOf(36));

        for(String s: word){
            int len = s.length();

            for(int i=0; i<len; i++){
                char c = s.charAt(len-1-i); // 뒤에서부터 자리 계산
                int v = charToVal(c);       // 문자 -> 숫자 변환
                BigInteger place = pow36[i];// 자릿수 값 36^i 계산

                total = total.add(place.multiply(BigInteger.valueOf(v))); 

                // z로 바꿨을 때 증가량 계산
                int diff = 35 - v;
                if(diff>0)
                    gain[v] = gain[v].add(place.multiply(BigInteger.valueOf(diff)));
            }
        }

        // 증가량이 가장 큰 문자 K개 선택하기 위해 내림차순 정렬
        Arrays.sort(gain, Collections.reverseOrder());
        for(int i=0; i<k; i++) 
            total = total.add(gain[i]);

        if(total.equals(BigInteger.ZERO)){
            System.out.println("0");
            return;
        }

        StringBuilder sb = new StringBuilder();
        BigInteger base = BigInteger.valueOf(36);

        while(total.compareTo(BigInteger.ZERO) > 0){
            BigInteger[] qr = total.divideAndRemainder(base);
            sb.append(valToChar(qr[1].intValue())); // 나눈 후 나머지는 문자로 변경함
            total = qr[0];                          // 몫으로 갱신함
        }

        System.out.println(sb.reverse());
    }


}
