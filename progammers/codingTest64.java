package progammers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * 프로그래머스 Lv.3 단어 변환
 * 
 * 두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.

1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
2. words에 있는 단어로만 변환할 수 있습니다.
예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면 "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.

두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.
 */
public class codingTest64 {

    public int solution(String begin, String target, String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        if (!wordSet.contains(target)) { //타겟이 words 배열 안에 없으면 
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        Set<String> visited = new HashSet<>(); //사용한 단어 체크위해
        visited.add(begin);
        int answer = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if (currentWord.equals(target)) { //타겟과 같다면 더이상 변환할 필요없음
                    return answer;
                }
                for (String word : getAdjacentWords(currentWord, wordSet)) { 
                    if (!visited.contains(word)) { //사용하지 않았던 단어라면
                        visited.add(word);
                        queue.offer(word); //변환한 단어 큐에 넣어주기
                    }
                }
            }
            answer++;
        }

        return 0; // target에 도달할 수 없는 경우
    }
    
    //word 배열안에 해당 단어로 바꿀 수 있는게 있는지
    private List<String> getAdjacentWords(String word, Set<String> wordSet) { 

        List<String> adjacentWords = new ArrayList<>();
        char[] charArray = word.toCharArray();
        
        for (int i = 0; i < charArray.length; i++) {
            char originalChar = charArray[i]; //원래 단어로 복원해주기 위해 기존 값 저장
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originalChar) {
                    continue;
                }
                charArray[i] = c; //a~z 중 한단어씩 바꿔봄
                String newWord = new String(charArray);
                if (wordSet.contains(newWord)) { //바군 단어가 words 배열에 있다면
                    adjacentWords.add(newWord);
                }
            }
            charArray[i] = originalChar; // 원래 문자로 복원
        }
        return adjacentWords;
    }

    /**
     * 다른사람 풀이
     * 
     * static class Node {
        String next;
        int edge;

        public Node(String next, int edge) {
            this.next = next;
            this.edge = edge;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int n = words.length, ans = 0;

        // for (int i=0; i<n; i++)
        //  if (words[i] != target && i == n-1) return 0;

        Queue<Node> q = new LinkedList<>();


        boolean[] visit = new boolean[n];
        q.add(new Node(begin, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.next.equals(target)) {
                ans = cur.edge;
                break;
            }

            for (int i=0; i<n; i++) {
                if (!visit[i] && isNext(cur.next, words[i])) {
                    visit[i] = true;
                    q.add(new Node(words[i], cur.edge + 1));
                }
            }
        }

        return ans;
    }

    static boolean isNext(String cur, String n) {
        int cnt = 0;
        for (int i=0; i<n.length(); i++) {
            if (cur.charAt(i) != n.charAt(i)) {
                if (++ cnt > 1) return false;
            }
        }

        return true;
    }    
     */
}
