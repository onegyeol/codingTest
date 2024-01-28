package section7;

/**
 * 첫번째 줄부터 각 줄에 하나씩 부분집합을 출력함.
 * 각 숫자 1~3까지 선택할지 안할지 여부 표기 필수.
 * ch 배열을 통해 선택할지 안할지 체크함.
 * 
 * 
 * 출력 결과
 * 1 2 3 
 * 1 2
 * 1 3
 * 1
 * 2 3
 * 2
 * 3
 */

public class Test6 {
    static int n;
    static int[] ch;

    public void DFS(int l){
        if(l == n+1){
            String tmp = "";
            for(int i=1; i<=n; i++){
                if(ch[i] == 1) tmp += (i + " ");
            }
            if(tmp.length() > 0) System.out.println(tmp);

        }
        else{
            ch[l] = 1; //l을 사용하겠단 뜻
            DFS(l+1);
            ch[l] = 0; //l을 사용하지 않겠단 뜻
            DFS(l+1);
        }
    }

    public static void main(String[] args) {
        Test6 t = new Test6();
        n = 3;
        ch = new int[n+1];
        t.DFS(1);
    }

}
