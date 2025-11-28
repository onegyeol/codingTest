package progammers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 프로그래머스 Lv.3 N으로 표현
 * 
 * 이처럼 숫자 N과 number가 주어질 때, N과 사칙연산만 사용해서 표현 할 수 있는 방법 중 N 사용횟수의 최솟값을 return 하도록 solution 함수를 작성하세요.
 */

public class codingTest131 {
    public static void main(String[] args) {
        // n, number 입력받음
    }

    public int solution(int N, int number) {
        List<Set<Integer>> countList = new ArrayList<>();

        for(int i=0; i<9; i++)
            countList.add(new HashSet<>());
        
        // 하나만 이용할 때는 자기 자신 숫자 뿐
        countList.get(1).add(N);
        
        for(int i=2; i<9; i++){
            Set<Integer> countSet = countList.get(i);
            
            for(int j=1; j<=i; j++){
                // 이전 결과들을 통해 사칙연산 수행
                Set<Integer> preSet = countList.get(j);
                Set<Integer> postSet = countList.get(i-j);
                
                for(int pre : preSet){
                    for(int post : postSet){
                        countSet.add(pre-post);
                        countSet.add(pre+post);
                        countSet.add(pre*post);
                        
                        if(pre!=0 && post!=0){
                            countSet.add(pre/post);
                        }
                    }
                }
            }
            // n만큼 반복되는 숫자 ex) 55, 555 ...
            countSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }
        
        for(Set<Integer> tmp : countList){
            if(tmp.contains(number)){
                return countList.indexOf(tmp);
            }
        }
        return -1;
    }
}
