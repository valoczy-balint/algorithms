package tree.bst.rotations

import tree.bst.Node


interface Rotation {
    fun rotate(node: Node)

    fun adjustParentChild(node: Node, newChild: Node) {
        if (node.parent?.left == node) {
            node.parent?.left = newChild
        } else {
            node.parent?.right = newChild
        }
    }

}
