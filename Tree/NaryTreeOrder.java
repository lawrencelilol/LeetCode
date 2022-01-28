import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class NaryTreeOrder {
    public static void main(String[] args) {

        List<Node> level1 = new ArrayList<>();
        List<Node> level2 = new ArrayList<>();
        Node n4 = new Node(5);
        Node n5 = new Node(6);
        level2.add(n4);
        level2.add(n5);

        Node n1 = new Node(3, level2);
        Node n2 = new Node(2);
        Node n3 = new Node(4);
        level1.add(n1);
        level1.add(n2);
        level1.add(n3);

        Node root = new Node(1, level1);

        // print result
        NaryTreeOrder nto = new NaryTreeOrder();
        List<List<Integer>> ans = nto.levelOrder(root);
        System.out.println(ans);

    }
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.offerLast(root);

        while(!deque.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int qSize = deque.size();

            for (int i = 0; i < qSize; i++) {
                Node cur = deque.pollFirst();
                level.add(cur.val);
                List<Node> children = cur.children;

                // Check children is null or children is empty
                if(children == null || children.size() == 0) {
                    continue;
                }

                for(Node c: children) {
                    if(c != null) {
                        deque.offerLast(c);
                    }
                }
            }
            ans.add(level);
        }
        return ans;
    }
}
