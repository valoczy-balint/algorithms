package tree

class Node(
    var value: String,
) {
    var children: MutableList<Node> = mutableListOf()
    var parent: Node? = null
}
