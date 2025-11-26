package progammers;

import java.util.Arrays;

/*
 * 프로그래머스 Lv.3 단속카메라
 * 
 * 고속도로를 이동하는 모든 차량이 고속도로를 이용하면서 단속용 카메라를 한 번은 만나도록 카메라를 설치하려고 합니다.
 * 고속도로를 이동하는 차량의 경로 routes가 매개변수로 주어질 때, 모든 차량이 한 번은 단속용 카메라를 만나도록 하려면 최소 몇 대의 카메라를 설치해야 하는지를 return 하도록 solution 함수를 완성하세요.
 */

public class codingTest129 {
    public static void main(String[] args) {
        // routes 입력 받음
    }

    public int solution(int[][] routes) {
        // 진입지점 기준 오름차순 정렬
        Arrays.sort(routes, (a, b) -> a[0] - b[0]);

        int answer = 1;
        int camera = routes[0][1];  // 첫 차량의 end 지점을 기준으로 카메라 위치 설정

        for (int i = 1; i < routes.length; i++) {
            // 현재 카메라 위치보다 진입 지점이 더 크면 
            if (routes[i][0] > camera) {
                answer++;             
                camera = routes[i][1];  
            } else {
                // 겹치는 경우 → 더 작은 end 지점으로 겹치는 구간 유지
                camera = Math.min(camera, routes[i][1]);
            }
        }
        
        return answer;
    }
}
