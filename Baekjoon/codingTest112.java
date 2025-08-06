package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 백준 1024번 수열의 합
 * 
 * 연속된 len개 수의 합이 N
 * N=start+(start+1)+...+(start+len−1)
 * 
 * 이를 합치면
 * N = len*start+(len*(len−1)/2)
 * 
 * 여기서 start를 구하면
 * start = (N-(len*(len−1)/2)) / len
 * -> tmp = N-(len*(len−1)/2)로 잡은 것 
 * 
 */
public class codingTest112 {
    static int l;
    static long n;
    static ArrayList<Long> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Long.parseLong(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        boolean found=false;

        for(int len=l; len<=100; len++){
            long tmp = n-(long)len*(len-1)/2; // 첫 시작이 정수임을 확인하기 위해 (start를 구하기 위해 분자를 tmp로 잡은 것)
            if(tmp<0) break;  // 분자가 음수이면 안됨
            if(tmp%len == 0){ // 시작값이 정수여야 하기에
                long start = tmp/len; // 시작값 구함
                for(long j=start; j<start+len; j++){
                    System.out.print(j+" ");
                }
                found = true;
                break;
            }
        }

        if(!found) System.out.println(-1);

    }

}
