package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 1101번 카드 정리 1
 * 
 * 박스는 N개가 있고, 카드는 색상으로 구분할 수 있다. 서로 다른 색상의 수는 M개가 있다. 태수는 아래 조건을 지키게 하기 위해 카드를 정리하려고 한다.
 * 
 * 박스 최대 1개는 조커 박스로 지정할 수 있다. 조커 박스는 색이 다른 카드를 보관해도 된다.
 * 조커 박스를 제외한 모든 박스는 비어있거나, 같은 색의 카드만 보관해야 한다.
 * 같은 색을 가진 모든 카드는 모두 같은 박스에 있어야 한다. 이때 조커 박스에 들어있는 카드는 제외한다. 같은 색을 가진 모든 카드가 조커 박스에 들어있는 것도 가능하다.
 * 
 * 각각의 박스에 각 색상을 가진 카드가 몇 장 들어있는지 입력으로 주어진다. 
 * 이때 최소 몇 번 이동해서 위의 조건을 지키게 할 수 있는지 구해보자. 이동 한 번은 한 박스에서 1장 이상의 카드를 빼 다른 박스에 넣는 것을 의미하며, 빼낸 카드의 색상은 같지 않아도 된다.
 */

public class codingTest102 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] card = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                card[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = n; // 이동 최소값 저장용

        for (int joker = 0; joker < n; joker++) {
            boolean[] usedColor = new boolean[m];
            int moves = 0;

            for (int i = 0; i < n; i++) {
                if (i == joker)
                    continue; // 조커 박스는 건너뜀

                int nonZeroCount = 0, colorIdx = -1;
                for (int j = 0; j < m; j++) {
                    if (card[i][j] > 0) {
                        nonZeroCount++;
                        colorIdx = j;
                    }
                }

                if (nonZeroCount == 0) {
                    // 비어 있으면 이동할 것도 없음
                } else if (nonZeroCount == 1) { // 이 박스는 하나의 색만 존재
                    if (usedColor[colorIdx]) // 이미 전용 색상 박스가 존재한다면 이동 필요
                        moves++;
                    else // 전용 색상 박스가 없다면
                        usedColor[colorIdx] = true;
                } else { // 두개 이상 존재할 시 무조건 이동 -> 조커 박스로 이동 
                    moves++;
                }
            }

            ans = Math.min(ans, moves);
        }

        System.out.println(ans);

    }
}
