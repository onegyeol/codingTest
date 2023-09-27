package progammers;

class Solution {
    public int solution(String s) {
        String answer = "";
        String[] str = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String n = "";
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            n += ch;
            
            if(Character.isDigit(ch)){
                answer += ch;
                n = "";
            } 
            
            for(int j=0; j<10; j++){
                if(n.equals(str[j])){
                    answer += Integer.toString(j);
                    n = "";
                }
            }
            
        }
        
        int result = Integer.parseInt(answer);
        
        return result;
    }
}