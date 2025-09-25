package progammers;

/*
 * 프로그래머스 Lv.2 2022 KAKAO TECH INTERNSHIP 두 큐 합 같게 만들기
 * 
 * 길이가 같은 두 개의 큐를 나타내는 정수 배열 queue1, queue2가 매개변수로 주어집니다. 
 * 각 큐의 원소 합을 같게 만들기 위해 필요한 작업의 최소 횟수를 return 하도록 solution 함수를 완성해주세요. 
 * 단, 어떤 방법으로도 각 큐의 원소 합을 같게 만들 수 없는 경우, -1을 return 해주세요.
 */

public class codingTest107 {
    public static void main(String[] args) {
        
    }

    static int solution(int[] queue1, int[] queue2) {
        int len = queue1.length;
        long sum1=0, sum2=0;
        long[] all = new long[len * 2];
        
        for(int i=0; i<len; i++){
            sum1+=queue1[i];
            all[i] = queue1[i];
        }
        
        for(int i=0; i<len; i++){
            sum2+=queue2[i];
            all[len+i] = queue2[i];
        }
        
        long total = sum1 + sum2;
        if ((total & 1) == 1) return -1; 
        long target = total / 2;
        
        int i = 0;          // q1의 head
        int j = len;          // q2의 head
        int limit = len * 3;  
        int ops = 0;
        
        while(ops<=limit){
            if(sum1==target) return ops;
            if (sum1 > target) {
                sum1 -= all[i % (2 * len)];
                i++;
            } else {
                sum1 += all[j % (2 * len)];
                j++;
            }
            ops++;
        }
        
        return -1;
    }
}
