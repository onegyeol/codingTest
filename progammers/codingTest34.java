package progammers;


/**Lv.1 소수 만들기
 * 
 * 주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다.
 * 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 
 * 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
 */

public class codingTest34 {

    public int solution(int[] nums) {
        int answer = 0;

        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    int cnt = 0;
                    for(int n=1; n<=sum; n++){
                        if(sum % n == 0) cnt++;
                    }
                    if(cnt == 2) answer++;
                }
            }
        }

        return answer;
    }

    /**다른사람 풀이
     * 
     * public int solution(int[] nums) {
        int ans = 0;

        for(int i = 0; i < nums.length - 2; i ++){
            for(int j = i + 1; j < nums.length - 1; j ++){
                for(int k = j + 1; k < nums.length; k ++ ){
                    if(isPrime(nums[i] + nums[j] + nums[k])){ //로직이 비슷하지만 소수를 구하는 함수를 따로 만듦
                        ans += 1;  
                    } 
                }
            }
        }
        return ans;
    }
    public Boolean isPrime(int num){ //소수 구하는 함수
        int cnt = 0;
        for(int i = 1; i <= (int)Math.sqrt(num); i ++){ // 루트사용. 즉 1인 경우에만 카운트. 1만 있을 경우 소수 보장됨.
            if(num % i == 0) cnt += 1;  
        }
        return cnt == 1; //cnt가 1일때 true 반환. 아니면 false 반환
    }
     */

}

