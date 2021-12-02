package dijkstra

class TentativeDistance(
    val node: Node,
    val distance: Int
) : Comparable<TentativeDistance> {

    override fun compareTo(other: TentativeDistance) =
        this.distance - other.distance
}
