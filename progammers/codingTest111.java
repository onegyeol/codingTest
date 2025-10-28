package progammers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/* 
 * 프로그래머스 Lv.2 소수찾기
 * 
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.ㄴ
 * 
 */

public class codingTest111 {
    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String numbers = br.readLine();

        System.out.println(solution(numbers));
    }
    
    static int solution(String numbers) {
        int answer = 0;
        permute("", numbers, set);
        
        for(int i : set){
            if(isPrime(i)) answer++;
        }
        
        return answer;
    }
    
    static void permute(String prefix, String remaining, HashSet<Integer> set) {
        if (!prefix.equals("")) {
            set.add(Integer.parseInt(prefix));
        }
        for (int i = 0; i < remaining.length(); i++) {
            permute(prefix + remaining.charAt(i), 
                    remaining.substring(0, i) + remaining.substring(i + 1),
                    set);
        }
    }
    
    static boolean isPrime(int n){
        if(n<2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
    
}   
