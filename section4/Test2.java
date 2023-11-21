package section4;

import java.util.*;

public class Test2 {
    public String solution(String t1, String t2){
        String answer="YES";
        // 내 풀이
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(int i=0; i<t1.length(); i++){
            map1.put(t1.charAt(i), map1.getOrDefault(t1.charAt(i), 0)+1);
            map2.put(t2.charAt(i), map2.getOrDefault(t2.charAt(i), 0)+1);
        }

        for(char key : map1.keySet()){
            if(!map2.containsKey(key))
                answer = "NO";
            else{
                if(map1.get(key) != map2.get(key))
                    answer = "NO";
            }
        }

        /**
         * 강사님 풀이
         * 
         * HashMap<Character, Integer> map = new HashMap<>();
         * 
         * for(char x : s1.toCharArray()){
         *      map.put(x, map.getOrDefault(x, 0)+1);
         * }
         * for(char x : s2.toCharArray()){
         *      if(!map.containsKey(x) || map.get(x)==0) answer="NO";
         *      map.put(x, map.get(x)-1);
         * }
         * 
         */

        return answer;
    }
    public static void main(String[] args) {
        Test2 t = new Test2();
        Scanner in = new Scanner(System.in);

        String t1 = in.next();
        String t2 = in.next();

        System.out.println(t.solution(t1, t2));

    }
}
