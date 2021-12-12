import java.util.LinkedList;

public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> path1 = findPathDepthFirst(root, p);
        LinkedList<TreeNode> path2 = findPathDepthFirst(root, q);

        if(path1 == null || path2 == null) {
            return null;
        }
        return findAncestor(path1, path2);
    }

    private LinkedList<TreeNode> findPathDepthFirst(TreeNode current, TreeNode target) {
        if(current.val == target.val) {
            LinkedList<TreeNode> path = new LinkedList<>();
            path.add(current);
            return path;
        } else {

            if (current.left != null) {
                LinkedList<TreeNode> leftPath = findPathDepthFirst(current.left, target);
                if(leftPath != null) {
                    leftPath.addFirst(current);
                    return leftPath;
                }
            }

            if(current.right != null) {
                LinkedList<TreeNode> rightPath = findPathDepthFirst(current.right, target);
                if(rightPath != null) {
                    rightPath.addFirst(current);
                    return rightPath;
                }
            }
        }
        return null;
    }

    private TreeNode findAncestor(LinkedList<TreeNode> path1, LinkedList<TreeNode> path2) {
        TreeNode ancestor = path1.getFirst();

        for (int i = 0; i < Math.min(path1.size(), path2.size()); i++) {
            if(path1.get(i) == path2.get(i)) {
                ancestor = path1.get(i);
            } else {
                break;
            }
        }

        return ancestor;
    }
}
