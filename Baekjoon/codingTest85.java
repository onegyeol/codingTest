package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

/*
 * 백준 7662번 이중 우선순위 큐
 * 
 * 입력 데이터는 표준입력을 사용한다. 입력은 T개의 테스트 데이터로 구성된다. 
 * 입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다. 
 *  테스트 데이터의 첫째 줄에는 Q에 적용할 연산의 개수를 나타내는 정수 k (k ≤ 1,000,000)가 주어진다. 
 * 이어지는 k 줄 각각엔 연산을 나타내는 문자(‘D’ 또는 ‘I’)와 정수 n이 주어진다. ‘I n’은 정수 n을 Q에 삽입하는 연산을 의미한다. 
 * 동일한 정수가 삽입될 수 있음을 참고하기 바란다. ‘D 1’는 Q에서 최댓값을 삭제하는 연산을 의미하며, 
 * ‘D -1’는 Q 에서 최솟값을 삭제하는 연산을 의미한다. 최댓값(최솟값)을 삭제하는 연산에서 최댓값(최솟값)이 둘 이상인 경우, 하나만 삭제됨을 유념하기 바란다.
 */

public class codingTest85 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            int q = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for(int j=0; j<q; j++){
                st = new StringTokenizer(br.readLine());
                String tmp1 = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(tmp1.equals("I")){
                    map.put(num, map.getOrDefault(num, 0)+1);
                }
                else if(tmp1.equals("D") && !map.isEmpty()){
                    int key = (num == -1) ? map.firstKey() : map.lastKey();

                    // 중복 값이 삭제되는 경우 
                    if (map.get(key) == 1) {
                        map.remove(key);
                    } else {
                        map.put(key, map.get(key) - 1);
                    }
                }
            }

            if(map.isEmpty()) sb.append("EMPTY\n");
            else sb.append(map.lastKey() + " " + map.firstKey() + " \n");
        }

        System.out.println(sb);
    }
}
