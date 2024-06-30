package progammers;

import java.util.HashSet;

/**
 * 프로그래머스 Lv.2 방문 길이
 * 
 * 게임 캐릭터를 4가지 명령어를 통해 움직이려 합니다. 명령어는 다음과 같습니다.

U: 위쪽으로 한 칸 가기

D: 아래쪽으로 한 칸 가기

R: 오른쪽으로 한 칸 가기

L: 왼쪽으로 한 칸 가기

캐릭터는 좌표평면의 (0, 0) 위치에서 시작합니다. 
좌표평면의 경계는 왼쪽 위(-5, 5), 왼쪽 아래(-5, -5), 오른쪽 위(5, 5), 오른쪽 아래(5, -5)로 이루어져 있습니다
단, 좌표평면의 경계를 넘어가는 명령어는 무시합니다.
 */

public class codingTest84 {
    public int solution(String dirs) {
        int answer = 0;
 
        HashSet<String> visited = new HashSet<>();

        int currentX = 0;
        int currentY = 0;
 
        for (int i = 0; i < dirs.length(); i++) {
            int nextX = currentX;
            int nextY = currentY;
            String moving = "";
 
            if (dirs.charAt(i) == 'U') {
                nextY++; 
                moving += currentX + "" + currentY + "" + nextX +  nextY;
/**
 * 이렇게 적는 이유
 * 
 * 이미 방문한 곳을 다시 방문하지 않기 위해 이미 거쳐간 길을 중복처리 해준다.
 * (0, 0) -> (1, 0) 0010
 * (1, 0) -> (0, 0) 0010
 * 
 */

            } else if (dirs.charAt(i) == 'D') {
                nextY--;
                moving += nextX + "" + nextY + "" + currentX + currentY ;
            } else if (dirs.charAt(i) == 'R') {
                nextX++; 
                moving += currentX + "" + currentY + "" + nextX + nextY;
            } else {
                nextX--;
                moving += nextX + "" + nextY + "" + currentX + currentY;
            }
 
            // 좌표평면의 경계를 넘어가면 추가하지 않고 다음 명령으로 넘어간다.
            if (nextX < -5 || nextY < -5 || nextX > 5 || nextY > 5) {
                continue;
            }
            visited.add(moving);
 
            currentX = nextX;
            currentY = nextY;
        }
        answer = visited.size();
 
        return answer;
    }
}
