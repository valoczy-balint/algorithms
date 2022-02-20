package challenges.symmetricTree

// https://leetcode.com/problems/symmetric-tree/
class SymmetricTree {

    fun isSymmetric(root: TreeNode?): Boolean {
        return root?.let {
            recursive(root.left, root.right)
        } ?: true
    }

    private fun recursive(left: TreeNode?, right: TreeNode?): Boolean {
        return if(left == null && right == null) {
            true
        } else if (left?.value != right?.value) {
            false
        } else {
            recursive(left?.left, right?.right) &&
                    recursive(left?.right, right?.left)
        }
    }
}

