import java.util.ArrayList;
import java.util.List;

public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = findPath(root, p);
        List<TreeNode> path2 = findPath(root, q);

        return findAncestor(path1, path2);
    }

    private List<TreeNode> findPath(TreeNode current, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        path.add(current);
        if(target.val > current.val) {
            path.addAll(findPath(current.right, target));
        } else if(target.val < current.val) {
            path.addAll(findPath(current.left, target));
        }
        return path;
    }

    private TreeNode findAncestor(List<TreeNode> path1, List<TreeNode> path2) {
        TreeNode ancestor = path1.get(0);

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
