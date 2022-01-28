import java.util.ArrayList;
import java.util.List;

public class PostOrder {
    public static void main(String[] args) {


        List<Node>level2 = new ArrayList<>();
        level2.add(new Node(5));
        level2.add(new Node(6));

        List<Node>level1 = new ArrayList<>();
        level1.add(new Node(3,level2));
        level1.add(new Node(2));
        level1.add(new Node(4));

        Node root = new Node(1,level1);

        PostOrder po = new PostOrder();
        List<Integer>ans = po.postorder(root);

        System.out.println(ans);

    }
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        postOrderTraversal(root,ans);
        return ans;
    }
    void postOrderTraversal(Node root, List<Integer> list) {
        if(root == null) {
            return;
        }

        List<Node> children = root.children;

        if(children == null) {
            list.add(root.val);
            return;
        }

        for(Node c: children) {
            postOrderTraversal(c,list);
        }

        list.add(root.val);
    }
}
