package section5;

import java.util.*;

class Person{ //우선순위와 중복 값이 있을 시 어떤 id 값을 삭제할 것인지 저장하기 위해 만든 클래스
    int id;
    int priority;
    public Person(int id, int priority){
        this.id = id;
        this.priority = priority;
    }
}

public class Test8 {
    public int solution(int n, int  m, int[] a){
        Queue<Person> q = new LinkedList<>();
        int answer=0;

        for(int i=0; i<n; i++){
            q.add(new Person(i, a[i]));
        }

        while(!q.isEmpty()){
            Person tmp = q.poll();
            for(Person x : q){
                if(x.priority > tmp.priority){ // 이 다음 환자의 우선순위가 높다면 제일 뒤로 이동
                    q.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null){
                answer++;
                if(tmp.id == m) return answer;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Test8 t = new Test8();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] patients = new int[n];

        for(int i=0; i<n; i++){
            patients[i] = in.nextInt();
        }
    
        System.out.println(t.solution(n, m, patients));

    }
}
