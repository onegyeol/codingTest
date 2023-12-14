package section6;
// 선택 정렬: 중첩 반복문 통해 매회마다 가장 작은값 앞으로
import java.util.*;

public class Test3 {
    public int[] solution(int n, int[] a){
        int least;

        for(int i=0; i<n-1; i++){
            least = i;
            for(int j=i+1; j<n; j++)
                if(a[least] > a[j]) least = j; //젤 앞의 값이 크다면 ? 가장 작은값이 아니기에 least 값 j로 변경
            int tmp = a[i]; //swap 함수 구현
            a[i] = a[least];
            a[least] = tmp;
        }

        return a;
    }
    public static void main(String[] args) {
        Test3 t = new Test3();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = in.nextInt();

        for(int i : t.solution(n, arr))
            System.out.print(i + " ");
    }
}
