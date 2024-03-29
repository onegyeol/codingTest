package section4;

import  java.util.*;

public class Test4 {
    public int solution(String s, String t){
        int answer=0, lt=0;
        Map<Character, Integer> sm=  new HashMap<>();
        Map<Character, Integer> tm = new HashMap<>();

        for(int i=0; i<t.length(); i++)
            tm.put(t.charAt(i), tm.getOrDefault(t.charAt(i), 0)+1);

        for(int i=0; i<t.length()-1; i++)
            sm.put(s.charAt(i), sm.getOrDefault(s.charAt(i), 0)+1);

        for(int rt = t.length()-1; rt<s.length(); rt++){
            sm.put(s.charAt(rt), sm.getOrDefault(s.charAt(rt), 0)+1);
            if(sm.equals(tm)) answer++; //해쉬맵 비교시 equals 메서드 사용
            sm.put(s.charAt(lt), sm.get(s.charAt(lt))-1); //일단 해당 키 값을 삭제하는게 아닌 -1 해주고
            if(sm.get(s.charAt(lt))==0) sm.remove(s.charAt(lt)); //해당 키의 값이 0이면 완전히 없애줌.
            lt++;
        }

        return answer;
    }
    public static void main(String[] args) {
        Test4 k = new Test4();
        Scanner in = new Scanner(System.in);

        String s = in.next();
        String t = in.next();

        System.out.println(k.solution(s, t));

    }
}
