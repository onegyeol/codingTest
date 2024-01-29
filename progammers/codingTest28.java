package progammers;

/**
 * Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.

Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로, 세로 크기를 순서대로 배열에 담아 
return 하도록 solution 함수를 작성해주세요.

제한 사항
* 갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
* 노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
* 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.

 */
public class codingTest28 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int yellow_w=1, brown_w=0, yellow_h=0; 
        //w는 가로, h는 세로의 의미
        
        while(true){
            brown_w = yellow_w+2; 
            //노란 타일 가로 길이의 +2를 해야 갈색 타일의 가로 길이가 됨
            yellow_h = (brown - (brown_w*2))/2; 
            //계산한 갈색 타일 수를 전체 타일 수에서 빼서 2로 나누면 노란 타일의 세로길이가 됨
            
            if(brown_w >= yellow_h+2 && yellow_w * yellow_h == yellow){
                answer[0] = brown_w;
                answer[1] = yellow_h+2;
                break;
            }
            
            yellow_w++;
        }
        
        return answer;
    }
}
