package tree

fun getStaticTree(): Node {

    val A = Node("A")
    val B = Node("B")
    val C = Node("C")
    val D = Node("D")
    val E = Node("E")
    val F = Node("F")
    val G = Node("G")
    val H = Node("H")
    val I = Node("I")
    val J = Node("J")

    A.children.addAll(listOf(B, C, D))
    B.children.add(E)
    C.children.add(H)
    D.children.addAll(listOf(G, J))
    E.children.add(F)
    H.children.add(I)

    return A
}
