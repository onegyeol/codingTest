package Baekjoon;

import java.util.*;
import java.io.*;

/*
 * 백준 1946번 신입 사원
 * 
 * 그래서 진영 주식회사는, 다른 모든 지원자와 비교했을 때 서류심사 성적과 면접시험 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발한다는 원칙을 세웠다. 
 * 즉, 어떤 지원자 A의 성적이 다른 어떤 지원자 B의 성적에 비해 서류 심사 결과와 면접 성적이 모두 떨어진다면 A는 결코 선발되지 않는다.
 * 이러한 조건을 만족시키면서, 진영 주식회사가 이번 신규 사원 채용에서 선발할 수 있는 신입사원의 최대 인원수를 구하는 프로그램을 작성하시오.


 * 첫째 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 20)가 주어진다. 각 테스트 케이스의 첫째 줄에 지원자의 숫자 N(1 ≤ N ≤ 100,000)이 주어진다. 
 * 둘째 줄부터 N개 줄에는 각각의 지원자의 서류심사 성적, 면접 성적의 순위가 공백을 사이에 두고 한 줄에 주어진다. 
 * 두 성적 순위는 모두 1위부터 N위까지 동석차 없이 결정된다고 가정한다.
 * 
 * 
 * - 서류 순위로 먼저 정렬
 * - 자신보다 서류 순위가 낮으면 비교할 필요 없음
 * - 자신보다 서류 순위가 높으면 면접 순위로 비교
 * - 면접순위가 높으면 붙고 낮으면 떨어짐
 * - 이때 합격자는 자기 자신으로 갱신
 */

class Employee implements Comparable<Employee>{
    int paper;
    int interview;

    public Employee(int p, int i){
        this.paper = p;
        this.interview = i;
    }
    @Override
    public int compareTo(Employee o) {
        return this.paper - o.paper;
    }
    
}
public class codingTest73 {
    static int t, n;
    static ArrayList<Employee> employees;

    static int solve(){
        int cnt = 1;
        int tmp = employees.get(0).interview;
        for(int i=1; i<n; i++){
            if(tmp > employees.get(i).interview){ // 면접 순위로 합격자 선발. (합격자보다 면접 순위가 높으면 비교할 의미가 없음)
                cnt++;
                tmp = employees.get(i).interview;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            employees = new ArrayList<>();
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                int paper = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                employees.add(new Employee(paper, interview));

            }
            Collections.sort(employees); // 서류 면접 순위로 오름차순 정렬
            sb.append(solve() + "\n");
        }

        System.out.println(sb);
    }
}
