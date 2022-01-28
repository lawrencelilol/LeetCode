import com.sun.source.tree.Tree;

public class DeletBST {
//    public TreeNode deleteNode(TreeNode root, int key) {
//        if(root == null) {
//            return root;
//        }
//        TreeNode cur = root;
//        TreeNode pre = root;
//        boolean found = false;
//
//        while(true) {
//            if(cur.val > key) {
//                if(cur.left != null) {
//                    pre = cur;
//                    cur = cur.left;
//                } else {
//                    break;
//                }
//            } else if(cur.val < key) {
//                if(cur.right != null) {
//                    pre =cur;
//                    cur = cur.right;
//                } else {
//                    break;
//                }
//            } else {
//                found = true;
//                break;
//            }
//        }
//
//        if(found) {
//            if (cur.right != null && cur.left != null) {
//                if (pre.val > key) {
//                    TreeNode tmp = cur;
//                    cur = cur.right;
//                    cur.left = tmp.left;
//                    pre.left = cur;
//                } else if (pre.val < key) {
//                    TreeNode tmp = cur;
//                    cur = cur.right;
//                    cur.left = tmp.left;
//                    pre.right = cur;
//                }  else {
//                    TreeNode tmp = cur;
//                    root = root.right;
//                    root.left = cur.left;
//                }
//            } else if (cur.right != null && cur.left == null) {
//                cur = cur.right;
//                if (pre.val > key) {
//                    pre.left = cur;
//                } else if (pre.val < key) {
//                    pre.right = cur;
//                } else  {
//                    root = root.right;
//                }
//            } else if (cur.right == null && cur.left != null) {
//                cur = cur.left;
//                if (pre.val > key) {
//                    pre.left = cur;
//                } else if (pre.val < key) {
//                    pre.right = cur;
//                } else {
//                    root = root.left;
//                }
//            } else {
//                if (pre.val > key) {
//                    pre.left = null;
//                } else if (pre.val < key) {
//                    pre.right = null;
//                } else {
//                    root = null;
//                }
//            }
//        }
//        return root;

//    public TreeNode deleteNode(TreeNode root, int key) {
//        if(root == null) {
//            return null;
//        }
//        if(root.val > key) {
//            root.left = deleteNode(root.left,key);
//        } else if( root.val < key) {
//            root.right  = deleteNode(root.right,key);
//        } else {
//            if(root.left == null) {
//                return root.right;
//            }
//            if(root.right == null) {
//                return root.left;
//            }
//            TreeNode tmp = root.right;
//            while(tmp.left != null) {
//                tmp = tmp.left;
//            }
//            root.val = tmp.val;
//            root.right = deleteNode(root.right,tmp.val);
//        }
//        return root;
//    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }
        if(root.val == key) {
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            } else {
                TreeNode cur = root.right;
                while(cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                root = root.right;
                return root;
            }
        }
        if(root.val > key) {
            root.left = deleteNode(root.left,key);
        }
        if(root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

}
