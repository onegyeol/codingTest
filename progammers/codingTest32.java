package progammers;

/**
 * 프로그래머스 Lv.1 모의고사
 * 
 * 수포자는 수학을 포기한 사람의 준말입니다. 
 * 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 
 * 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 * 
 */

import java.util.*;

public class codingTest32 {

    public int[] solution(int[] answers) {
        List<Person> list = List.of(
        new Person(new LinkedList<>(List.of(1, 2, 3, 4, 5)), 0),
        new Person(new LinkedList<>(List.of(2, 1, 2, 3, 2, 4, 2, 5)), 0),
        new Person(new LinkedList<>(List.of(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)),0));
        
        for(int a : answers){
            for(Person p : list){
                Integer num = p.q.poll();
                if(a == num) p.score++; //answer의 답과 수포자의 답이 정답일 때 정답맞춘 수포자의 점수 +1
                p.q.add(num); //poll했던 번호 다시 큐의 마지막에 추가해줌
            }
        }
        
        int max = Integer.MIN_VALUE; //최대점수찾기 위해 최소값 넣어줌
        
        for(Person p : list){
            max = Math.max(p.score, max);
        }
        
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<list.size(); i++){
            if(list.get(i).score == max) answer.add(i+1); //최대 점수랑 수포자의 점수가 같으면 answer에 수포자 번호(1, 2, 3) 넣어줌
        }

        return answer.stream().mapToInt(Integer::intValue).toArray(); //List 형태의 answer을 int 배열형으로 리턴해주기 위해 stream 사용
    }
    
    class Person{
        private Queue<Integer> q; //수포자가 찍는 번호를 큐에 담음
        private int score;
        
        Person(Queue<Integer> q, int score){
            this.q = q;
            this.score = score;
        }
    }
}

/* 다른 사람 풀이


 * public static int[] solution(int[] answers) {
        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] hit = new int[3];
        for(int i = 0; i < hit.length; i++) {
            for(int j = 0; j < answers.length; j++) {
                if(patterns[i][j % patterns[i].length] == answers[j]) hit[i]++;
            }
        }

        int max = Math.max(hit[0], Math.max(hit[1], hit[2]));
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < hit.length; i++)
            if(max == hit[i]) list.add(i + 1);

        int[] answer = new int[list.size()];
        int cnt = 0;
        for(int num : list)
            answer[cnt++] = num;
        return answer;
    }
 */