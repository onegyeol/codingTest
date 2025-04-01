package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 백준 2493번 탑
 * 
 * KOI 통신연구소는 레이저를 이용한 새로운 비밀 통신 시스템 개발을 위한 실험을 하고 있다. 
 * 실험을 위하여 일직선 위에 N개의 높이가 서로 다른 탑을 수평 직선의 왼쪽부터 오른쪽 방향으로 차례로 세우고, 각 탑의 꼭대기에 레이저 송신기를 설치하였다. 
 * 모든 탑의 레이저 송신기는 레이저 신호를 지표면과 평행하게 수평 직선의 왼쪽 방향으로 발사하고, 탑의 기둥 모두에는 레이저 신호를 수신하는 장치가 설치되어 있다. 
 * 하나의 탑에서 발사된 레이저 신호는 가장 먼저 만나는 단 하나의 탑에서만 수신이 가능하다.
 * 예를 들어 높이가 6, 9, 5, 7, 4인 다섯 개의 탑이 수평 직선에 일렬로 서 있고, 모든 탑에서는 주어진 탑 순서의 반대 방향(왼쪽 방향)으로 동시에 레이저 신호를 발사한다고 하자. 
 * 그러면, 높이가 4인 다섯 번째 탑에서 발사한 레이저 신호는 높이가 7인 네 번째 탑이 수신을 하고, 높이가 7인 네 번째 탑의 신호는 높이가 9인 두 번째 탑이, 높이가 5인 세 번째 탑의 신호도 높이가 9인 두 번째 탑이 수신을 한다. 
 * 높이가 9인 두 번째 탑과 높이가 6인 첫 번째 탑이 보낸 레이저 신호는 어떤 탑에서도 수신을 하지 못한다.
 * 탑들의 개수 N과 탑들의 높이가 주어질 때, 각각의 탑에서 발사한 레이저 신호를 어느 탑에서 수신하는지를 알아내는 프로그램을 작성하라.
 */

class Laser{
    int idx;
    int h;

    public Laser(int i, int h){
        this.idx = i;
        this.h = h;
    }
}

public class codingTest80 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n];
        Stack<Laser> sta = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int height = Integer.parseInt(st.nextToken());
            Laser current = new Laser(i+1, height);

            while(!sta.isEmpty() && sta.peek().h <= current.h){ // 현재 레이저 탑 높이가 더 높으면 기존에 스택에 있던 거 지움
                sta.pop();
            }

            answer[i] = sta.isEmpty() ? 0: sta.peek().idx; 

            sta.push(current);
        }

        for(int i : answer)
            System.out.print(i+" ");
    }
}

/*
 * 
 * def laswer(buildings):
 *      n=len(buildings)
 *      answer = [0] * n
 *      stack = []
 * 
 *      for i in range(n):
 *          current_height = buildings[i]
 *          
 *          // -1은 리스트의 마지막 요소 의미 (파이썬은 스택이 따로 없기에 마지막 리스트의 첫번째 요소인 (높이) 반환)
 *          while stack[-1][1] < =current_height and stack:
 *              stack.pop()
 *      
 *          answer[i] = stack[-1][0] if stack else 0
 *  
 *          stack.append(i+1, current_height)
 *      return answer
 * 
 * if __name__ == "__main__":
 *      n = int(input())
 *      buildings = list(map(int, niput().split()))
 *      
 *      result = laswer(buildings)
 *      print(" ".join(map(str, result)))
 */