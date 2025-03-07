package Baekjoon;

import java.util.*;

/*
 * 백준 1744번 수 묶기
 * 
 *  길이가 N인 수열이 주어졌을 때, 그 수열의 합을 구하려고 한다. 하지만, 그냥 그 수열의 합을 모두 더해서 구하는 것이 아니라, 수열의 두 수를 묶으려고 한다. 
 * 어떤 수를 묶으려고 할 때, 위치에 상관없이 묶을 수 있다. 하지만, 같은 위치에 있는 수(자기 자신)를 묶는 것은 불가능하다. 그리고 어떤 수를 묶게 되면, 수열의 합을 구할 때 묶은 수는 서로 곱한 후에 더한다.
 * 예를 들면, 어떤 수열이 {0, 1, 2, 4, 3, 5}일 때, 그냥 이 수열의 합을 구하면 0+1+2+4+3+5 = 15이다. 하지만, 2와 3을 묶고, 4와 5를 묶게 되면, 0+1+(2*3)+(4*5) = 27이 되어 최대가 된다.
 * 수열의 모든 수는 단 한번만 묶거나, 아니면 묶지 않아야한다.
 * 수열이 주어졌을 때, 수열의 각 수를 적절히 묶었을 때, 그 합이 최대가 되게 하는 프로그램을 작성하시오.
 */

public class codingTest69 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        
        List<Integer> positive = new ArrayList<>(); // 양수
        List<Integer> negative = new ArrayList<>(); // 음수
        int zeroCount = 0;

        for(int i=0; i<n; i++){
            int tmp = in.nextInt();
            if(tmp>0) positive.add(tmp);
            else if(tmp<0) negative.add(tmp);
            else zeroCount++;
        }

        Collections.sort(positive, Collections.reverseOrder());
        Collections.sort(negative);

        int answer = 0;

        for(int i=0; i<positive.size(); i+=2){
            if(i+1<positive.size()){
                if(positive.get(i)==1 || positive.get(i+1)==1){
                    answer += positive.get(i)+positive.get(i+1);
                } 
                else{
                    answer += positive.get(i)*positive.get(i+1);
                }
            }
            else{
                answer += positive.get(i);
            }
        }

        for(int i=0; i<negative.size(); i+=2){
            if(i+1<negative.size()){
                answer += negative.get(i)*negative.get(i+1);
            }
            else{
                // 0이 존재한다면 0을 곱해 소멸할 수 있기에 
                // 0이 존재하지 않는다면 마지막 양수 값을 더해줘야 함
                if(zeroCount==0){ 
                    answer += negative.get(i);
                }
            }
        }

        System.out.println(answer);
        
    }
}
