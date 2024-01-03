package section6;

import java.util.*;

class Point implements Comparable<Point>{
    public int x, y;
    Point(int a, int b){
        this.x = a;
        this.y = b;
    }
    @Override
    public int compareTo(Point o) {
        if(this.x==o.x) return this.y-o.y;
        else return this.x-o.x;
    }
    /**
     * 기준값 == 비교값 : 0
     * 기준값 < 비교값 : -1
     * 기준값 > 비교값 : 1
     */
    
}

public class Test7 {
    
    public static void main(String[] args) {
        Test7 t = new Test7();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        ArrayList<Point> arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            arr.add(new Point(x, y));
        }

        Collections.sort(arr);

        for(Point k : arr){
            System.out.println(k.x + " " + k.y);
        }
        
    }
}
