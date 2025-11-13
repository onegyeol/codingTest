package progammers;

/*
 *  프로그래머스 Lv.2 2018 KAKAO BLIND RECRUITMENT [3차] 방금그곡
 * 
 * 네오는 자신이 기억한 멜로디를 가지고 방금그곡을 이용해 음악을 찾는다. 
 * 그런데 라디오 방송에서는 한 음악을 반복해서 재생할 때도 있어서 네오가 기억하고 있는 멜로디는 음악 끝부분과 처음 부분이 이어서 재생된 멜로디일 수도 있다. 
 * 반대로, 한 음악을 중간에 끊을 경우 원본 음악에는 네오가 기억한 멜로디가 들어있다 해도 그 곡이 네오가 들은 곡이 아닐 수도 있다. 
 * 그렇기 때문에 네오는 기억한 멜로디를 재생 시간과 제공된 악보를 직접 보면서 비교하려고 한다. 
 * 다음과 같은 가정을 할 때 네오가 찾으려는 음악의 제목을 구하여라.
 * 
 * - 방금그곡 서비스에서는 음악 제목, 재생이 시작되고 끝난 시각, 악보를 제공한다.
 * - 네오가 기억한 멜로디와 악보에 사용되는 음은 C, C#, D, D#, E, F, F#, G, G#, A, A#, B 12개이다.
 * - 각 음은 1분에 1개씩 재생된다. 
 *   음악은 반드시 처음부터 재생되며 음악 길이보다 재생된 시간이 길 때는 음악이 끊김 없이 처음부터 반복해서 재생된다. 
 *   음악 길이보다 재생된 시간이 짧을 때는 처음부터 재생 시간만큼만 재생된다.
 * - 음악이 00:00를 넘겨서까지 재생되는 일은 없다.
 * - 조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다. 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.
 * - 조건이 일치하는 음악이 없을 때에는 “(None)”을 반환한다.
 */

public class codingTest128 {
    public static void main(String[] args) {
        
    }
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = replaceInfo(m);

        int maxTime = -1;

        for (String info : musicinfos) {
            String[] tmp = info.split(",");
            String start = tmp[0];
            String end = tmp[1];
            String title = tmp[2];
            String sheet = replaceInfo(tmp[3]);

            int playTime = getPlayTime(start, end);
            String playedMusic = buildMusic(sheet, playTime);

            // m이 포함되는 음악인지 검사
            if (playedMusic.contains(m)) {
                // 곡이 여러개 일 때는 시간이 젤 긴 제목 반환 위해
                if (playTime > maxTime) {
                    maxTime = playTime;
                    answer = title;
                }
            }
        }

        return answer;
    }

    // 악보 반복 생성 (시간보다 악보가 길면 악보는 항상 처음부터 반복 생성)
    public String buildMusic(String sheet, int time) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < time; i++) {
            sb.append(sheet.charAt(i % sheet.length()));
        }
        return sb.toString();
    }

    // 재생 시간 계산
    public int getPlayTime(String s, String e) {
        int start = Integer.parseInt(s.split(":")[0]) * 60 + Integer.parseInt(s.split(":")[1]);
        int end = Integer.parseInt(e.split(":")[0]) * 60 + Integer.parseInt(e.split(":")[1]);
        return end - start;
    }

    // 이때 B#은 C와 같고 E#은 F와 같음
    public static String replaceInfo(String s) {
        return s.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a")
                .replace("B#", "C")
                .replace("E#", "F");
    }
}
