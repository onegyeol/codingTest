package progammers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 프로그래머스 [PCCE 기출문제] 10번 / 데이터 분석
 */

public class codingTest91 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] data = new int[n][4];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
            data[i][2] = Integer.parseInt(st.nextToken());
            data[i][3] = Integer.parseInt(st.nextToken());
        }

        String ext = br.readLine();
        int val_ext = Integer.parseInt(br.readLine());
        String sort_by = br.readLine();

        System.out.println(solution(data, ext, val_ext, sort_by));
    }

    static ArrayList<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {

        ArrayList<int[]> filtered = new ArrayList<>();
        
        // ext 기준으로 필터링
        int extIndex = getIndex(ext);
        for (int[] row : data) {
            if (row[extIndex] <= val_ext) {
                filtered.add(row);
            }
        }

        // sort_by 기준으로 정렬
        int sortIndex = getIndex(sort_by);
        filtered.sort((a, b) -> Integer.compare(a[sortIndex], b[sortIndex]));

        return filtered;
    }

    // 열 이름 → 인덱스 변환
    static int getIndex(String col) {
        switch (col) {
            case "code": return 0;
            case "date": return 1;
            case "maximum": return 2;
            case "remain": return 3;
            default: throw new IllegalArgumentException("잘못된 컬럼명: " + col);
        }
    }

}
