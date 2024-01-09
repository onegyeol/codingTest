package section6;

import java.util.*;

public class Test8 {
    
    public static void main(String[] args) {
        Test8 t = new Test8();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }

        System.out.println(binarySearch(n, m, arr));


    }

    private static int binarySearch(int n, int m, int[] a){
        int mid, low=0, high=n;
        Arrays.sort(a);

        while(low <= high){
            mid = (low+high)/2;

            if(m ==  a[mid]){
                return mid+1;
                
            }
            else if(m < a[mid]){
                high = mid;
            }
            else low=mid;
        }

        return -1;
    }
}


