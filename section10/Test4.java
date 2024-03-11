package section10;

import java.util.*;

/**
 * 코테 강의 10-4. 가장 높은 탑 쌓기
 * 
 * 밑면이 정사각형인 직육면체 벽돌들을 사용하여 탑을 쌓고자 한다. 탑은 벽돌을 한 개씩 아래에서 위로 쌓으면서 만들어 간다.

아래의 조건을 만족하면서 가장 높은 탑을 쌓을 수 있는 프로그램을 작성하시오.

(조건1) 벽돌은 회전시킬 수 없다. 즉, 옆면을 밑면으로 사용할 수 없다.

(조건2) 밑면의 넓이가 같은 벽돌은 없으며, 또한 무게가 같은 벽돌도 없다.

(조건3) 벽돌들의 높이는 같을 수도 있다.

(조건4) 탑을 쌓을 때 밑면이 좁은 벽돌 위에 밑면이 넓은 벽돌은 놓을 수 없다.

(조건5) 무게가 무거운 벽돌을 무게가 가벼운 벽돌 위에 놓을 수 없다.
 */

class Top implements Comparable<Top>{
    public int width, height, weight;

    Top(int width, int height, int weight){
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Top o) {
        return o.width - this.width;
    }

}

public class Test4 {
    static int[] h;

    public int solution(ArrayList<Top> arr){
        Collections.sort(arr); //넓이 순으로 정렬
        h[0] = arr.get(0).height;

        for(int i=1; i<arr.size(); i++){
            int max_h = 0;
            for(int j=i-1; j>=0;j--){
                if(arr.get(j).weight > arr.get(i).weight && h[j] > max_h){ //위에 쌓이는 애가 더 가벼워야함
                    max_h = h[j];
                }
            }
            h[i] = max_h + arr.get(i).height;
        }

        return Arrays.stream(h).max().getAsInt();
    }
    public static void main(String[] args) {
        Test4 t = new Test4();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        ArrayList<Top> arr = new ArrayList<>();
        h = new int[n];

        for(int i=0; i<n; i++){
            int width = in.nextInt();
            int height = in.nextInt();
            int weight = in.nextInt();
            arr.add(new Top(width, height, weight));   
        }
        
        System.out.println(t.solution(arr));
        
    }
}
