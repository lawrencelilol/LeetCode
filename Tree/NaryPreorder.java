import java.util.ArrayList;
import java.util.List;

public class NaryPreorder {

    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        preOrderTraversal(root,ans);
        return ans;
    }
    void preOrderTraversal(Node root, List<Integer> list) {
        if(root == null) {
            return;
        }

        list.add(root.val);
        List<Node> children = root.children;

        for(Node c: children) {
            preOrderTraversal(c,list);
        }

    }
}
