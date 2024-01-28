package section7;

/**
 * 트리노드에서 말단 노드까지 최단경로 구하기
 * dfs와 bfs 방식
 */

import java.util.*;

class Node{
    int data;
    Node lt, rt;
    public Node(int val){
        data=val;
        lt=rt=null;
    }
}


public class Test9 {
    Node root;

    public int DFS(int level, Node root){
        if(root.rt==null && root.lt==null) return level;
        else return Math.min(DFS(level+1, root.lt), DFS(level+1, root.rt));
    }

    public int BFS(Node root){
        Queue<Node> q = new LinkedList<>();
        int level=0;
        q.offer(root);

        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; i++){
                Node curr = q.poll();
                if(curr.lt == null && curr.rt == null) return level;
                if(curr.lt != null) q.offer(curr.lt);
                if(curr.rt != null) q.offer(curr.rt);
            }
            level++;
        }

        return 0;

    }
    public static void main(String[] args) {
        Test9 tree = new Test9();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        System.out.println(tree.BFS(tree.root));
        System.out.println(tree.DFS(0, tree.root));
    }
}
