package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 백준 1060번 좋은 수
 * 
 * A와 B는 양의 정수이고, A < B를 만족한다.
A ≤ x ≤ B를 만족하는 모든 정수 x가 집합 S에 속하지 않는다.
정수 x를 포함하는 좋은 구간의 개수가 정수 y를 포함하는 좋은 구간의 개수보다 작으면 x는 y보다 더 좋다고 한다. 
x와 y를 포함하는 좋은 구간의 개수가 같거나, 구간의 개수가 둘 다 무한대와 같은 경우, 작은 수를 더 좋다고 한다.
 */

public class codintTest119 {

    // (s,e) 사이 정수만 유효.
    static class Gap {
        final int s, e;
        int L, R;
        Gap(int s, int e) {
            this.s = s; this.e = e;
            this.L = s + 1;
            this.R = e - 1;
        }
    }

    // 우선순위 큐에 넣을 후보
    static class Node implements Comparable<Node> {
        final long score;   // f(x)
        final int x;        // 값
        final int gid;      // 소속 gap id (-1이면 S의 원소)
        final int side;     // 0=L측, 1=R측, -1=S 원소

        Node(long score, int x, int gid, int side) {
            this.score = score; this.x = x; this.gid = gid; this.side = side;
        }

        @Override public int compareTo(Node o) {
            int c = Long.compare(this.score, o.score);
            if (c != 0) return c;
            return Integer.compare(this.x, o.x);
        }
    }

    // f(x) = (x - s) * (e - x) - 1  (x가 범위 밖이면 큰 값 반환)
    static long f(int x, int s, int e) {
        if (x <= s || x >= e) return Long.MAX_VALUE / 4;
        long left = (long) x - s;
        long right = (long) e - x;
        long val = left * right - 1;
        return Math.max(val, 0L);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());
        int[] input = new int[l];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < l; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        int n = Integer.parseInt(br.readLine());

        // S 집합 들어가지 않는 경계 찾음
        List<Gap> gaps = new ArrayList<>();
        int prev = 0; // 양의 정수 시작을 위해 
        for (int i = 0; i < l; i++) {
            int cur = input[i];
            if (cur - prev > 1) {
                gaps.add(new Gap(prev, cur));
            }
            prev = cur;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        // S 원소는 f(x)=0으로 넣음
        for (int x : input) {
            pq.offer(new Node(0L, x, -1, -1));
        }

        // 각 유한 구간의 양끝 후보를 PQ에 삽입
        for (int i = 0; i < gaps.size(); i++) {
            Gap g = gaps.get(i);
            if (g.L > g.R) continue; // 빈 구간 없음
            long sL = f(g.L, g.s, g.e);
            pq.offer(new Node(sL, g.L, i, 0));
            if (g.R != g.L) {
                long sR = f(g.R, g.s, g.e);
                pq.offer(new Node(sR, g.R, i, 1));
            }
        }

        // n개 뽑기 (중복 방지)
        Set<Integer> used = new HashSet<>();
        StringBuilder out = new StringBuilder();
        int picked = 0;

        while (picked < n && !pq.isEmpty()) {
            Node cur = pq.poll();
            if (used.contains(cur.x)) continue; // 같은 x 중복 방지

            if (picked > 0) out.append(' ');
            out.append(cur.x);
            used.add(cur.x);
            picked++;

            // S 원소면 확장 없음
            if (cur.gid == -1) continue;

            // 같은 구간에서 해당 side를 한 칸 안쪽으로 전진시키며 다음 후보 투입
            Gap g = gaps.get(cur.gid);
            if (cur.side == 0) { // 왼쪽
                g.L++;
                if (g.L <= g.R) {
                    long sc = f(g.L, g.s, g.e);
                    pq.offer(new Node(sc, g.L, cur.gid, 0));
                }
            } else { // 오른쪽
                g.R--;
                if (g.L <= g.R) {
                    long sc = f(g.R, g.s, g.e);
                    pq.offer(new Node(sc, g.R, cur.gid, 1));
                }
            }
        }

        // n개를 못채운 경우 -> 무한대 경우임
        if (picked < n) {
            int last = input[l - 1];
            int x = last + 1;
            while (picked < n) {
                if (!used.contains(x)) {
                    if (picked > 0) out.append(' ');
                    out.append(x);
                    used.add(x);
                    picked++;
                }
                x++;
            }
        }

        System.out.println(out.toString());
    }
}
