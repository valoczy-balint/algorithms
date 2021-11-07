package tree.bst

fun main() {
    var root = Node(43)
//        val list = listOf(3, 5, 2, 7, 9, 6)
//    val list = listOf(69, 36, 5, 72, 26, 79, 59)
//    val list = listOf(69, 26, 72, 60, 79)
    val list = listOf(26, 69, 20, 60, 72, 50, 70, 79, 90, 80)
    list.forEach { item ->
        root = root.insert(Node(item))
    }

    println(root)
}
