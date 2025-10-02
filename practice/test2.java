package practice;

import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

/*
 * Task 클래스: name, priority(정수, 클수록 우선순위 높음).
 * Scheduler 클래스: addTask(Task task)
 * getNextTask() → 가장 높은 우선순위 반환 (동점이면 먼저 들어온 순서).
 */

public class test2 {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        scheduler.addTask(new Task("A", 1));
        scheduler.addTask(new Task("B", 3));
        scheduler.addTask(new Task("C",1));

        System.out.println(scheduler.getNextTask());
        System.out.println(scheduler.getNextTask());

    }
}

class Task{
    String name;
    int priority;
    long seq;

    public Task(String name, int priority){
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString(){
        return name;
    }
}

class Scheduler{
    private PriorityQueue<Task> queue;
    private AtomicLong sequence = new AtomicLong(0);

    public Scheduler(){
        queue = new PriorityQueue<>((t1, t2) -> {
            if(t1.priority != t2.priority){
                return Integer.compare(t1.priority, t2.priority);
            } else {
                return Long.compare(t1.seq, t2.seq);
            }
        });
    }

    public void addTask(Task task){
        task.seq = sequence.getAndIncrement();
        queue.offer(task);
    }

    public String getNextTask(){
        Task task = queue.poll();
        return task==null ? null : task.name; 
    }
}
