package Baekjoon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * 백준 1302번 베스트셀러 
 * 
 * 첫째 줄에 가장 많이 팔린 책의 제목을 출력한다. 만약 가장 많이 팔린 책이 여러 개일 경우에는 사전 순으로 가장 앞서는 제목을 출력한다.
 */
public class codingTest116 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();
        Map<String, Integer> book = new HashMap<>();

        for(int i=0; i<n; i++){
            String name = in.nextLine();
            book.put(name, book.getOrDefault(name, 0) + 1);
        }

        // 정렬: 판매량 내림차순, 동률이면 사전순 오름차순
        List<Map.Entry<String, Integer>> list = new ArrayList<>(book.entrySet());
        list.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) { // 판매량 높은 순
                return b.getValue() - a.getValue(); 
            }
            return a.getKey().compareTo(b.getKey()); // 사전순
        });

        // 1등 책 출력
        System.out.println(list.get(0).getKey());

    }
}
