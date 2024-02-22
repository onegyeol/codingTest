package progammers;

/**프로그래머스 Lv.2 N개의 최소공배수
 * 
 * 두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다. 
 * 예를 들어 2와 7의 최소공배수는 14가 됩니다. 
 * 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다. 
 * n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.
 * 
 * 유클리드 호제법 사용
 * (A*B) / A와 B의 최대공배수
 * 
 */

public class codingTest48 {
    public int solution(int[] arr) {
        return getLCM(arr);
    }
    
    public int getLCM(int[] arr){ //최소 공배수 구하는 메서드
        if(arr.length == 1) return arr[0];
        
        int gcd = getGCD(arr[0], arr[1]);
        int lcm = (arr[0] * arr[1]) / gcd;
        
        for(int i=2; i<arr.length; i++){
            gcd = getGCD(lcm, arr[i]);
            lcm = (lcm * arr[i]) / gcd;
        }
        
        return lcm;
    }
    
    public int getGCD(int a, int b){ //최대공약수 구하는 메서드
        if(a % b == 0) return b;
        return getGCD(b, a%b);
    }

}
