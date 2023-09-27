package progammers;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        StringBuffer str = new StringBuffer(Integer.toString(n, 3));
        String s = str.reverse().toString();
        answer = Integer.parseInt(s, 3);
        
        return answer;
    }
}
