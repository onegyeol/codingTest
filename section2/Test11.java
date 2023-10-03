package section2;

import java.util.Scanner;

public class Test11{
    public int solution(int k, int[][] a){
        int answer=0, max=Integer.MIN_VALUE;
        
        for(int i=1; i<=k; i++){
            int cnt=0;
            for(int j=1; j<=k; j++){
                for(int z=1; z<=5; z++){
                    if(a[i][z] == a[j][z]){
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt>max){
                max = cnt;
                answer = i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Test11 t = new Test11();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] arr = new int[n+1][6];

        for(int i=1; i<n+1; i++){
            for(int j=1; j<6; j++){
                arr[i][j]=in.nextInt();
            }
        }

        System.out.println(t.solution(n, arr));
    }
}