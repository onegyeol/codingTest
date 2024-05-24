package progammers;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 프로그래머스 Lv.2 주차요금 정산
 * 
 * 주차장의 요금표와 차량이 들어오고(입차) 나간(출차) 기록이 주어졌을 때, 차량별로 주차 요금을 계산하려고 합니다. 아래는 하나의 예시를 나타냅니다.
 * 어떤 차량이 입차된 후에 출차된 내역이 없다면, 23:59에 출차된 것으로 간주합니다.
0000번 차량은 18:59에 입차된 이후, 출차된 내역이 없습니다. 따라서, 23:59에 출차된 것으로 간주합니다.
00:00부터 23:59까지의 입/출차 내역을 바탕으로 차량별 누적 주차 시간을 계산하여 요금을 일괄로 정산합니다.
누적 주차 시간이 기본 시간이하라면, 기본 요금을 청구합니다.
누적 주차 시간이 기본 시간을 초과하면, 기본 요금에 더해서, 초과한 시간에 대해서 단위 시간 마다 단위 요금을 청구합니다.
초과한 시간이 단위 시간으로 나누어 떨어지지 않으면, 올림합니다.
⌈a⌉ : a보다 작지 않은 최소의 정수를 의미합니다. 즉, 올림을 의미합니다.
주차 요금을 나타내는 정수 배열 fees, 자동차의 입/출차 내역을 나타내는 문자열 배열 records가 매개변수로 주어집니다. 
차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
 */

public class codingTest78 {

    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        HashMap<String, Integer> map1 = new HashMap<String, Integer>(); 
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();
        
        for(String record : records){
            String[] tmp = record.split(" "); //공백 기준으로 나눔
            int time = getRealTime(tmp[0]);
            String car = tmp[1];
            String io = tmp[2];
            
            if(io.equals("IN")){ //입차 기록 map1에 넣음
                map1.put(car, time);
            }
            else{ //출차 기록일 때
                int carTime1 = map1.get(car); //시간가져옴
                map1.remove(car); //그러고 map1에서 삭제
                if(map2.containsKey(car)){ //입차기록이 있다면
                    int carTime2 = map2.get(car);
                    map2.replace(car, carTime2+time-carTime1); //시간 갱신
                }
                else map2.put(car, time-carTime1);
            }
        }
        
        int lastTime = 1439; //(11*60)+59
        for(String car : map1.keySet()){ //출차 기록이 없는 애들은 23:59를 출차 기록으로 계산해 저장
            int carTime1 = map1.get(car);
            if(map2.containsKey(car)){
                int carTime2 = map2.get(car);
                map2.replace(car, carTime2+lastTime-carTime1);
            }
            else map2.put(car, lastTime-carTime1);
        }
        
        Object[] sortMap = map2.keySet().toArray(); //차번호 기준으로 정렬
        Arrays.sort(sortMap);
        answer = new int[sortMap.length];
        
        for (int i = 0; i<answer.length; i++) {
            int result = fees[1]; //기본 요금
            String car = String.valueOf(sortMap[i]);
            
            int val = map2.get(car); //시간 가져옴
            if (val > fees[0]) {
                result = (int) (fees[1] + Math.ceil((double)(val-fees[0])/fees[2]) * fees[3]);
            }
            answer[i] = result;
        }
        return answer;
    }
    
    //시간을 초로 바꿈
    static int getRealTime(String t){
        String[] tmp = t.split(":");
        int h = Integer.parseInt(tmp[0])*60;
        int m = Integer.parseInt(tmp[1]);
        
        return h+m;
    }
    /**
     * 다른사람 풀이
     * 
     * public int timeToInt(String time) {
        String temp[] = time.split(":");
        return Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
    }
    public int[] solution(int[] fees, String[] records) {

        TreeMap<String, Integer> map = new TreeMap<>();

        for(String record : records) {
            String temp[] = record.split(" ");
            int time = temp[2].equals("IN") ? -1 : 1;
            time *= timeToInt(temp[0]);
            map.put(temp[1], map.getOrDefault(temp[1], 0) + time);
        }
        int idx = 0, ans[] = new int[map.size()];
        for(int time : map.values()) {
            if(time < 1) time += 1439;
            time -= fees[0];
            int cost = fees[1];
            if(time > 0)
                cost += (time%fees[2] == 0 ? time/fees[2] : time/fees[2]+1)*fees[3];

            ans[idx++] = cost;
        }
        return ans;
    }
     */
}
