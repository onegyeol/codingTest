package section7;

import java.util.*;

/**
 * 이진트리 레벨 탐색 순회
 */

class Node{
    int data;
    Node lt, rt;
    public Node(int val){
        data=val;
        lt=rt=null;
    }
}


public class Test7 {
    Node root;

    public void BFS(Node root){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int L=0;

        while(!q.isEmpty()){
            int len = q.size();
            System.out.print(L + " : ");
            for(int i=0; i<len; i++){
                Node n = q.poll();
                System.out.print(n.data + " ");
                if(n.lt != null) q.offer(n.lt);
                if(n.rt != null) q.offer(n.rt);
            }
            System.out.println();
            L++;
        }

    }
    public static void main(String[] args) {
        Test7 tree = new Test7();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        tree.BFS(tree.root);
    }
}
