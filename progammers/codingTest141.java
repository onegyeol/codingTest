package progammers;

/*
프로그래머스 Lv.3 기지국 설치 (Greedy)

아파트의 개수 N, 현재 기지국이 설치된 아파트의 번호가 담긴 1차원 배열 stations, 전파의 도달 거리 W가 매개변수로 주어질 때, 모든 아파트에 전파를 전달하기 위해 증설해야 할 기지국 개수의 최솟값을 리턴하는 solution 함수를 완성해주세요
*/

public class codingTest141 {
    public static void main(String[] args) {
        // n, stations, w 입력 받음
    }
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int position = 1;
        int idx = 0;
        int range = 2*w+1; // 각각 오/왼/내위치

        while(position<=n){
            // 현재 위치가 기지국 왼쪽 끝 전파 범위보다 크거나 같아야 함
            if(idx<stations.length && position >= stations[idx]-w){
                // 현재 위치에서 기지국 전파가 끝나는 시점으로 이동
                position = stations[idx]+w+1;
                idx++;
            } else{ // 전파 범위에 있지 않다면 기지국 설치
                answer++;
                position += range;
            }
        }
        return answer;
    }
}
