package dijkstra

fun main() {

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

    A.neighbours.set(D, 3)
    B.neighbours.set(H, 4)
    C.neighbours.set(D, 9)
    C.neighbours.set(H, 3)
    D.neighbours.set(A, 3)
    D.neighbours.set(C, 9)
    D.neighbours.set(E, 8)
    D.neighbours.set(H, 2)
    D.neighbours.set(I, 1)
    E.neighbours.set(D, 8)
    E.neighbours.set(I, 4)
    E.neighbours.set(J, 6)
    F.neighbours.set(H, 7)
    G.neighbours.set(I, 5)
    H.neighbours.set(B, 4)
    H.neighbours.set(C, 3)
    H.neighbours.set(D, 2)
    H.neighbours.set(F, 7)
    I.neighbours.set(D, 1)
    I.neighbours.set(E, 4)
    I.neighbours.set(G, 5)
    J.neighbours.set(E, 6)

    val cheapestPaths = mutableMapOf(
        A to 0,
        B to 0,
        C to 0,
        D to 0,
        E to 0,
        F to 0,
        G to 0,
        H to 0,
        I to 0,
        J to 0,
    )

    val start = A

    start.findCheapestPaths(cheapestPaths)
    cheapestPaths.forEach {
        println("${it.key.value}:\t${it.value}")
    }
}
