package progammers;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] str1 = new String[n];
        String[] str2 = new String[n];
        
        
        for(int i=0; i<n; i++){
            str1[i] = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr1[i])))
                .substring(0, n).replace('0', ' ').replace('1', '#');
            
            str2[i] = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr2[i])))
                .substring(0, n).replace('0', ' ').replace('1', '#');;
        }
        
        for(int i=0; i<n; i++){
            char[] ch1 = str1[i].toCharArray();
            char[] ch2 = str2[i].toCharArray();
            StringBuilder sb = new StringBuilder();
            
            for(int j=0; j<n; j++){
                if(ch1[j] == '#' || ch2[j] == '#'){
                    sb.append("#");
                }
                else{
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        
        }
       
        
        return answer;
    }
}