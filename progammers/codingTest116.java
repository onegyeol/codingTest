package progammers;

/*
 * 프로그래머스 Lv.2 연속된 부분 수열의 합
 * 
 * 수열을 나타내는 정수 배열 sequence와 부분 수열의 합을 나타내는 정수 k가 매개변수로 주어질 때, 
 * 위 조건을 만족하는 부분 수열의 시작 인덱스와 마지막 인덱스를 배열에 담아 return 하는 solution 함수를 완성해주세요. 
 * 이때 수열의 인덱스는 0부터 시작합니다.
 */

public class codingTest116 {
    public static void main(String[] args) {
        // sequence, k 입력 받음
    }
    public int[] solution(int[] sequence, int k) {
        int left = 0, right = 0;
        int sum = sequence[0];
        int[] answer = {0, 0};
        int len = Integer.MAX_VALUE;

        while (left <= right && right < sequence.length) {
            if (sum == k) {
                int currentLen = right - left;
                if (currentLen < len) { // 길이 비교
                    len = currentLen;
                    answer[0] = left;
                    answer[1] = right;
                }
                sum -= sequence[left++];
            } else if (sum < k) {
                right++;
                if (right < sequence.length) sum += sequence[right];
            } else { // sum > k
                sum -= sequence[left++];
            }
        }
        return answer;
    }
}
