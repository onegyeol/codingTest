package progammers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

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
