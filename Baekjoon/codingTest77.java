package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 백준 1092번 배
 * 
 * 지민이는 항구에서 일한다. 그리고 화물을 배에 실어야 한다. 
 * 모든 화물은 박스에 안에 넣어져 있다. 항구에는 크레인이 N대 있고, 1분에 박스를 하나씩 배에 실을 수 있다. 
 * 모든 크레인은 동시에 움직인다.
 * 각 크레인은 무게 제한이 있다. 이 무게 제한보다 무거운 박스는 크레인으로 움직일 수 없다. 
 * 모든 박스를 배로 옮기는데 드는 시간의 최솟값을 구하는 프로그램을 작성하시오.
 */

public class codingTest77 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> crane = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            crane.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> box = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            box.add(Integer.parseInt(st.nextToken()));
        }

        crane.sort(Collections.reverseOrder());
        box.sort(Collections.reverseOrder());

        if(crane.get(0) < box.get(0)){
            System.out.println(-1);
            return;
        }

        int min=0;;
        while(!box.isEmpty()){
            int boxidx = 0, craneidx = 0;

            while(craneidx<n){
                if(boxidx == box.size()) break;
                else if(crane.get(craneidx) >= box.get(boxidx)){
                    box.remove(boxidx);
                    craneidx++;
                }
                else boxidx++;
            }

            min++;
        }

        System.out.println(min);

    }
}

/*

import sys

def solve():
    # 크레인의 수
    n = int(sys.stdin.readline())
    
    # 크레인 무게 제한
    crane = list(map(int, sys.stdin.readline().split()))
    crane.sort(reverse=True)

    # 박스의 수
    m = int(sys.stdin.readline())
    
    # 박스 무게
    box = list(map(int, sys.stdin.readline().split()))
    box.sort(reverse=True)

    if crane[0] < box[0]:
        print(-1)
        return

    min_time = 0
    while box:
        box_idx = 0
        crane_idx = 0

        while crane_idx < n:
            if box_idx == len(box):
                break
            elif crane[crane_idx] >= box[box_idx]:
                box.pop(box_idx)
                crane_idx += 1
            else:
                box_idx += 1

        min_time += 1

    print(min_time)

if __name__ == "__main__":
    solve()


 */
