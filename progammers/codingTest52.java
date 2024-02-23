package progammers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

/** 프로그래머스 Lv.2 연속 부분 수열 합의 개수
 * 
 * 철호는 수열을 가지고 놀기 좋아합니다. 
 * 어느 날 철호는 어떤 자연수로 이루어진 원형 수열의 연속하는 부분 수열의 합으로 만들 수 있는 수가 모두 몇 가지인지 알아보고 싶어졌습니다. 
 * 원형 수열이란 일반적인 수열에서 처음과 끝이 연결된 형태의 수열을 말합니다. 
 * 예를 들어 수열 [7, 9, 1, 1, 4] 로 원형 수열을 만들면 다음과 같습니다.
 * 
 * 원형 수열의 모든 원소 elements가 순서대로 주어질 때, 원형 수열의 연속 부분 수열 합으로 만들 수 있는 수의 개수를 return 하도록 solution 함수를 완성해주세요.
 */
class codingTest52{
    public int solution(int[] elements) {
        Queue<Integer> q = new LinkedList<>();
        TreeSet<Integer> tree = new TreeSet<>();
        int sum = 0, cnt=0;
        
        for(int i : elements){
            q.offer(i);
            tree.add(i); //길이가 1인 애들은 바로 넣어줌
        }
        
        for(int i=2; i<=elements.length; i++){
            while(true){
                if(cnt == i){
                    tree.add(sum);
                    sum=0; 
                    cnt=0;
                }
                int n = q.poll();
                q.offer(n);
                sum += n;
                cnt++;
            
            }
            
        }
        System.out.println(tree);
        return tree.size();
    }
}