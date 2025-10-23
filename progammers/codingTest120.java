package progammers;

import java.util.ArrayList;

/*
 * 프로그래머스 Lv.1 바탕화면 정리
 * 
 * 머쓱이의 컴퓨터 바탕화면의 상태를 나타내는 문자열 배열 wallpaper가 매개변수로 주어질 때 
 * 바탕화면의 파일들을 한 번에 삭제하기 위해 최소한의 이동거리를 갖는 드래그의 시작점과 끝점을 담은 정수 배열을 return하는 solution 함수를 작성해 주세요. 
 * 드래그의 시작점이 (lux, luy), 끝점이 (rdx, rdy)라면 정수 배열 [lux, luy, rdx, rdy]를 return하면 됩니다.
 */

public class codingTest120 {
    public static void main(String[] args) {
        // wallpaper 입력받음
    }

    private class Location{
        int x, y;
        
        public Location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int[] solution(String[] wallpaper) {
        ArrayList<Location> locations = new ArrayList<>();
        
        
        for(int i=0; i<wallpaper.length; i++){
            String str = wallpaper[i];
            for(int j=0; j<wallpaper[0].length(); j++){
                if((str.substring(j, j+1)).equals("#")){
                    locations.add(new Location(i+1, j+1));
                }
            }
        }
        
        // 최소 좌표 구하기 위함
        int left_y = Integer.MAX_VALUE;
        int left_x = Integer.MAX_VALUE;
        int right_y = Integer.MIN_VALUE;
        int right_x = Integer.MIN_VALUE;
        
        for(Location l : locations){
            int x = l.x;
            int y = l.y;
            
            left_y = Math.min(left_y, y);
            left_x = Math.min(left_x, x);
            right_y = Math.max(right_y, y);
            right_x = Math.max(right_x, x);
        }
        
        // 왼쪽 좌표는 시작 점부터 해야하기에 -1
        int[] answer = {left_x-1, left_y-1, right_x, right_y};
        
        return answer;
    }
}
