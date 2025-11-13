package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * 문자열 2개가 주어진다.
 * 각 문자열은 "a=1;b=3;c=10" 같은 형식으로 여러 개의 key=value 쌍이 ; 로 구분되어 있다.
 * 첫 번째 집합(old)와 두 번째 집합(new)의 변화량을 다음 기준으로 계산하라.
 * 
 * 추가(Add): old에는 없고, new에만 있는 key
 * 삭제(Delete): old에는 있고, new에는 없는 key
 * 변경(Change): 두 집합 모두 key는 존재하지만 value가 다른 경우
 */

public class test7 {
    static Map<String, Integer> oldMap = new HashMap();
    static Map<String, Integer> newMap = new HashMap();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String oldStr = br.readLine();
        String newStr = br.readLine();

        makeMap(oldStr, oldMap);
        makeMap(newStr, newMap);
        
        int add=0, delete=0, change=0;
        for(String tmp : oldMap.keySet()){
            if(newMap.containsKey(tmp)){
                if(newMap.get(tmp) != oldMap.get(tmp)){
                    change++;
                }
            }
            else{
                delete++;
            }
        }

        for(String key : newMap.keySet()){
            if(!oldMap.containsKey(key)){
                add++;
            }
        }

        System.out.println("Add: " + add + " Delete: " + delete + " Chanage: " + change);
    }

    static void makeMap(String s, Map<String, Integer> map){
        if(s.trim().isEmpty()) return;
        
        String[] arr = s.split(";");
        for(String item : arr){
            String[] tmp = item.split("=");
            map.put(tmp[0], Integer.parseInt(tmp[1]));
        }
    }
}   
