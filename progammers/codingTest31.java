package progammers;

public class codingTest31 {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int cnt1=0, cnt2=0;
        
        for(int i=0; i<goal.length; i++){
            if(cnt1 < cards1.length){    
                if(cards1[cnt1].equals(goal[i])) cnt1++;
            }
            else break;
        }
        
        for(int i=0; i<goal.length; i++){
            if(cnt2 < cards2.length){
                if(cards2[cnt2].equals(goal[i]))   cnt2++;
            }
            else break;
        }
        if(cnt1+cnt2 == goal.length) return "Yes"; //주어진 cards1과 cards2를 다 쓰지 않을수도 있음.
        else return "No";

    }
}
