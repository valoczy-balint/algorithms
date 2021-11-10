package graph

class Node(
    var value: String,
    val neighbours: MutableMap<Node, Int> = mutableMapOf(),
    var visited: Boolean = false
)
