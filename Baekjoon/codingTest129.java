package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 1002번 터렛

조규현의 좌표 (x_1, y_1)와 백승환의 좌표 (x_2, y_2)가 주어지고, 조규현이 계산한 류재명과의 거리 r_1과 백승환이 계산한 류재명과의 거리 r_2가 주어졌을 때, 류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.

첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 다음과 같이 이루어져 있다.

한 줄에 공백으로 구분 된 여섯 정수 x1, y1, r1, x2, y2, r2가 주어진다.

각 테스트 케이스마다 류재명이 있을 수 있는 위치의 수를 출력한다. 만약 류재명이 있을 수 있는 위치의 개수가 무한대일 경우에는 -1 출력한다.
*/

public class codingTest129 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());            
            int r2 = Integer.parseInt(st.nextToken());

            // 중심 거리 구함
            int distSq = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

            // 개선된 조건문 예시
            if (x1 == x2 && y1 == y2 && r1 == r2) {
                sb.append(-1);
            } else if (distSq > Math.pow(r1 + r2, 2) || distSq < Math.pow(r1 - r2, 2)) {
                sb.append(0); // 만나지 않는 두 가지 경우 (멀거나, 포함되거나)
            } else if (distSq == Math.pow(r1 + r2, 2) || distSq == Math.pow(r1 - r2, 2)) {
                sb.append(1); // 접하는 두 가지 경우 (외접하거나, 내접하거나)
            } else {
                sb.append(2);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
