package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 1541번 잃어버린 괄호
 * 
 * 세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.
 * 그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
 * 괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.
 */
public class codingTest88 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("-");
        int[] sum = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            String[] add = arr[i].split("\\+");

            for(int j=0; j<add.length; j++){
                sum[i] += Integer.parseInt(add[j]);
            }
        }

        int answer = sum[0];
        for(int i=1; i<sum.length; i++){
            answer -= sum[i];
        }

        System.out.println(answer);
    }

}
