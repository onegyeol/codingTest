package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 2212번 센서
 * 
 * 한국도로공사는 고속도로의 유비쿼터스화를 위해 고속도로 위에 N개의 센서를 설치하였다. 
 * 문제는 이 센서들이 수집한 자료들을 모으고 분석할 몇 개의 집중국을 세우는 일인데, 예산상의 문제로, 고속도로 위에 최대 K개의 집중국을 세울 수 있다고 한다.

 * 각 집중국은 센서의 수신 가능 영역을 조절할 수 있다. 집중국의 수신 가능 영역은 고속도로 상에서 연결된 구간으로 나타나게 된다. 
 * N개의 센서가 적어도 하나의 집중국과는 통신이 가능해야 하며, 집중국의 유지비 문제로 인해 각 집중국의 수신 가능 영역의 길이의 합을 최소화해야 한다.

 * 편의를 위해 고속도로는 평면상의 직선이라고 가정하고, 센서들은 이 직선 위의 한 기점인 원점으로부터의 정수 거리의 위치에 놓여 있다고 하자. 
 * 따라서, 각 센서의 좌표는 정수 하나로 표현된다. 이 상황에서 각 집중국의 수신 가능영역의 거리의 합의 최솟값을 구하는 프로그램을 작성하시오. 
 * 단, 집중국의 수신 가능영역의 길이는 0 이상이며 모든 센서의 좌표가 다를 필요는 없다.
 */

public class codingTest76{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int[] diff = new int[n-1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        if(k>=n){
            System.out.println(0);
            return;
        }

        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        for(int i=0; i<n-1; i++){
            diff[i] = num[i+1] - num[i];
        }
        
        Arrays.sort(diff);

        int sum = 0;

        for(int i=0; i<n-k; i++){
            sum += diff[i];
        }

        System.out.println(sum);
    }
}

/*
 * 파이썬 코드
 * 
 import sys

def main():
    # 입력 처리
    n = int(sys.stdin.readline().strip())
    k = int(sys.stdin.readline().strip())
    
    # k가 n보다 크거나 같으면 0 출력 후 종료
    if k >= n:
        print(0)
        return

    # 숫자 입력 및 정렬
    num = list(map(int, sys.stdin.readline().split()))
    num.sort()

    # 차이 계산 및 정렬
    diff = [num[i+1] - num[i] for i in range(n-1)]
    diff.sort()

    # 합계 계산
    sum_diff = sum(diff[:n-k])

    print(sum_diff)

if __name__ == "__main__":
    main()

 */