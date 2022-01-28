//import java.util.Deque;
//import java.util.LinkedList;
//
//public class NextRightPointersII {
//    public static void main(String[] args) {
//        Node root = new Node(1);
//        Node l1 = new Node(2);
//        Node r1 = new Node(3);
//        root.left = l1;
//        root.right = r1;
//
//        Node l2 = new Node(4);
//        Node r2 = new Node(5);
//        l1.left = l2;
//        l1.right = r2;
//
//        Node r3 = new Node(7);
//        r1.left = null;
//        r1.right = r3;
//
//        NextRightPointersII nrp = new NextRightPointersII();
//        nrp.connect(root);
//    }
//
//    public Node connect(Node root) {
//        if(root == null) {
//            return null;
//        }
//
//        Deque<Node> deque = new LinkedList<>();
//        deque.offerLast(root);
//
//        while(!deque.isEmpty()) {
//
//            int size = deque.size();
//
//            // loop over each level
//            for (int i = 0; i < size; i++) {
//                Node cur = deque.pollFirst();
//
//                if(cur.left != null) {
//                    deque.offerLast(cur.left);
//                }
//                if(cur.right != null) {
//                    deque.offerLast(cur.right);
//                }
//
//                if(i == size - 1) {
//                    cur.next = null;
//                } else {
//                    Node nxt = deque.peek();
//                    cur.next = nxt;
//                }
//            }
//        }
//        return root;
//    }
//}
