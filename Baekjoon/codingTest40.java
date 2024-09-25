package Baekjoon;

import java.util.*;
import java.io.*;

/**
 * 백준 1339번 단어 수학
 * 
 * 민식이는 수학학원에서 단어 수학 문제를 푸는 숙제를 받았다.

단어 수학 문제는 N개의 단어로 이루어져 있으며, 각 단어는 알파벳 대문자로만 이루어져 있다. 
이때, 각 알파벳 대문자를 0부터 9까지의 숫자 중 하나로 바꿔서 N개의 수를 합하는 문제이다. 
같은 알파벳은 같은 숫자로 바꿔야 하며, 두 개 이상의 알파벳이 같은 숫자로 바뀌어지면 안 된다.

예를 들어, GCF + ACDEB를 계산한다고 할 때, A = 9, B = 4, C = 8, D = 6, E = 5, F = 3, G = 7로 결정한다면, 두 수의 합은 99437이 되어서 최대가 될 것이다.

N개의 단어가 주어졌을 때, 그 수의 합을 최대로 만드는 프로그램을 작성하시오.
 */
public class codingTest40 {
    static int n;
    static int[] alpha = new int[26];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        Arrays.fill(alpha, 0);

        for(int i=0; i<n; i++){
            String str = br.readLine(); // 입력받은 단어
            for(int j=0; j<str.length(); j++){
                char c = str.charAt(j);
                alpha[c - 'A'] += (int)Math.pow(10, str.length()-1-j);
            }
        }

        Arrays.sort(alpha); // 배열 정렬

        int num = 9; // 가장 큰 수부터 넣음
        int index = 25; // 가장 큰 자릿값을 가진 알파벳 인덱스
        int sum = 0;

        while(alpha[index] > 0){
            sum += alpha[index] * num; 
            index--; num--;
        }
        System.out.println(sum);
        
        
    }
}
