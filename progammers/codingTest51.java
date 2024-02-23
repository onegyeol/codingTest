package progammers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

/** 프로그래머스 Lv.2 귤 고르기
 * 
 * 예를 들어, 경화가 수확한 귤 8개의 크기가 [1, 3, 2, 5, 4, 5, 2, 3] 이라고 합시다. 
 * 경화가 귤 6개를 판매하고 싶다면, 크기가 1, 4인 귤을 제외한 여섯 개의 귤을 상자에 담으면, 
 * 귤의 크기의 종류가 2, 3, 5로 총 3가지가 되며 이때가 서로 다른 종류가 최소일 때입니다.

경화가 한 상자에 담으려는 귤의 개수 k와 귤의 크기를 담은 배열 tangerine이 매개변수로 주어집니다. 
경화가 귤 k개를 고를 때 크기가 서로 다른 종류의 수의 최솟값을 return 하도록 solution 함수를 작성해주세요.
 */

public class codingTest51 {
     public int solution(int[] elements) {
        TreeSet<Integer> tree = new TreeSet<>(); //중복 방지 위해 TreeSet 자료형 사용
        
        int cnt=1; //길이
        while(cnt <= elements.length){
            for(int i=0; i<elements.length; i++){
                int sum=0;
                for(int j=i; j<cnt+i; j++){
                    sum += elements[j % elements.length]; //처음과 끝이 이어져있는 것을 고려
                }
                tree.add(sum);
            }
            cnt++;
        }

        return tree.size();
    }

}
