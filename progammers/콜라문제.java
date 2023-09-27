package progammers;

class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n >= a){
            int cnt = n/a;
            answer += cnt*b;
            n = cnt*b + (n%a);
        }
        
        return answer;
    }
}