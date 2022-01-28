import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaxDepthNaryTree {
    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }

        Deque<Node> deque = new LinkedList<>();
        int level = 0;
        deque.offerLast(root);

        while(!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                Node cur = deque.pollFirst();
                List<Node> children = cur.children;
                if(children.size() == 0 || children == null ) {
                    continue;
                } else {
                    for(Node c: children) {
                        deque.offerLast(c);
                    }
                }
            }
            level++;
        }
        return level;
    }
}
