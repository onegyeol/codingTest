package section8;

import java.util.*;

public class Test4 {
    static int n, m;
    static int[] pm;

    public void DFS(int level){
        if(level == m){
            for(int i: pm) System.out.print(i + " ");
            System.out.println();
        }
        else{
            for(int i=1; i<=n; i++){
                pm[level] = i;
                DFS(level+1);
            }
        }
    }

    public static void main(String[] args) {
        Test4 t = new Test4();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        pm = new int[m];

        t.DFS(0);
    }
}
