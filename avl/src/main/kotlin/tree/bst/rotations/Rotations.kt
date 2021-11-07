package tree.bst.rotations

import tree.bst.Node

enum class Rotations {
    L, R, LR, RL
}

val left = Left()
val right = Right()
val leftRight = LeftRight()
val rightLeft = RightLeft()

fun Rotations.rotate(node: Node) {
    when (this) {
        Rotations.L -> left.rotate(node)
        Rotations.R -> right.rotate(node)
        Rotations.LR -> leftRight.rotate(node)
        Rotations.RL -> rightLeft.rotate(node)
    }
}


