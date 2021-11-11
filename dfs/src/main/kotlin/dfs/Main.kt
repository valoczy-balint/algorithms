package dfs

import tree.Node
import tree.getStaticTree


fun main() {

    val tree = getStaticTree()

    val dfs = Dfs()
//    println(dfs.preOrder(tree, Node("H")))
//    println(dfs.preOrder(tree, Node("F")))
//    println(dfs.preOrder(tree, Node("L")))

    println(dfs.postOrder(tree, Node("H")))
    println(dfs.postOrder(tree, Node("F")))
    println(dfs.postOrder(tree, Node("L")))
}
