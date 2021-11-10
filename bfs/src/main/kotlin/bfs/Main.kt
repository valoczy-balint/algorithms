package bfs

import tree.Node
import tree.getStaticTree


fun main() {

    val tree = getStaticTree()

    val bfs = Bfs()
    println(bfs.findInTree(tree, Node("H")))
    println(bfs.findInTree(tree, Node("F")))
    println(bfs.findInTree(tree, Node("L")))

}
