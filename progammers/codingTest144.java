package progammers;

/*
프로그래머스 Lv.2 숫자 카드 나누기

철수와 영희는 선생님으로부터 숫자가 하나씩 적힌 카드들을 절반씩 나눠서 가진 후, 다음 두 조건 중 하나를 만족하는 가장 큰 양의 정수 a의 값을 구하려고 합니다.

- 철수가 가진 카드들에 적힌 모든 숫자를 나눌 수 있고 영희가 가진 카드들에 적힌 모든 숫자들 중 하나도 나눌 수 없는 양의 정수 a
- 영희가 가진 카드들에 적힌 모든 숫자를 나눌 수 있고, 철수가 가진 카드들에 적힌 모든 숫자들 중 하나도 나눌 수 없는 양의 정수 a

철 수가 가진 카드에 적힌 숫자들을 나타내는 정수 배열 arrayA와 영희가 가진 카드에 적힌 숫자들을 나타내는 정수 배열 arrayB가 주어졌을 때, 
주어진 조건을 만족하는 가장 큰 양의 정수 a를 return하도록 solution 함수를 완성해 주세요. 만약, 조건을 만족하는 a가 없다면, 0을 return 해 주세요.
*/

public class codingTest144 {
    public static void main(String[] args) {
        // arrayA, arrayB 입력받음
    }

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }
        for (int i = 1; i < arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        int resultA = valid(gcdA, arrayB);
        int resultB = valid(gcdB, arrayA);
        
        answer = Math.max(resultA, resultB);

        return answer;
    }
    
   private int valid(int target, int[] otherArray) {
        for (int n : otherArray) {
            if (n % target == 0) return 0;
        }
        return target;
    }
    
    
    // 최대 공약수 구함
    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}   
