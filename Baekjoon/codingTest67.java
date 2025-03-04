package Baekjoon;

import java.util.*;
import java.io.*;

/*
 * 백준 1202번 보석 도둑
 * 
 * 세계적인 도둑 상덕이는 보석점을 털기로 결심했다.
 * 상덕이가 털 보석점에는 보석이 총 N개 있다. 각 보석은 무게 Mi와 가격 Vi를 가지고 있다. 
 * 상덕이는 가방을 K개 가지고 있고, 각 가방에 담을 수 있는 최대 무게는 Ci이다. 가방에는 최대 한 개의 보석만 넣을 수 있다.
 * 상덕이가 훔칠 수 있는 보석의 최대 가격을 구하는 프로그램을 작성하시오.
 */
class Jewerly implements Comparable<Jewerly>{
    int weight;
    int price;

    public Jewerly(int x, int y){
        this.weight = x;
        this.price = y;
    }

    @Override
    public int compareTo(Jewerly o) {
        return this.weight - o.weight;

    }
}

public class codingTest67 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 보석 수
        int k = Integer.parseInt(st.nextToken()); // 가방 수

        int[] bags = new int[k];
        Jewerly[] jewerlies = new Jewerly[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            jewerlies[i] = new Jewerly(a, b);
        }

        for(int i=0; i<k; i++){
            bags[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(jewerlies);
        Arrays.sort(bags);

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        long maxPrice = 0;
        int j=0; // 쥬얼리 수

        for(int i=0; i<k; i++){
            while(j<n && jewerlies[j].weight<=bags[i]){ // 가방이 보석의 개수보다 많을 경우 가방에 담을 수 있는 최대 개수는 보석의 개수만큼이기에 n을 넘을 수 없음
                q.add(jewerlies[j].price); 
                j++;
            }

            if(!q.isEmpty()) maxPrice+=q.poll();
        }

        System.out.println(maxPrice);

    }


}
