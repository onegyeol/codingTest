package section4;

import java.util.*;

public class Test1 {
    public char solution(int n, String s){
        char answer=' ';
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);

        int max = Integer.MIN_VALUE;
        for(char key : map.keySet()){
            if(max < map.get(key)){
                max = map.get(key);
                answer = key;
            }
        }
        return answer;

    }
    public static void main(String[] args) {
        Test1 t = new Test1();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        String s = in.next();

        System.out.println(t.solution(n, s));

    }
}
