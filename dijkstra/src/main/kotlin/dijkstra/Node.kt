package dijkstra

class Node(
    var value: String,
    val neighbours: MutableMap<Node, Int> = mutableMapOf(),
    var visited: Boolean = false
) {
    fun findCheapestPaths(cheapestPaths: MutableMap<Node, Int>) {
        this.visited = true

        val sortedNeighbours = mutableMapOf<Node, Int>()

        neighbours.entries.sortedBy { it.value }.forEach {
            sortedNeighbours[it.key] = it.value
        }

        sortedNeighbours.forEach {
            if (!it.key.visited) {
                if (cheapestPaths[it.key] == 0) {
                    cheapestPaths[it.key] = cheapestPaths[this]!! + it.value
                } else if (cheapestPaths[this]!! + it.value < cheapestPaths[it.key]!!) {
                    cheapestPaths[it.key] = cheapestPaths[this]!! + it.value
                }
            }
        }
        sortedNeighbours.forEach {
            if (!it.key.visited) {
                it.key.findCheapestPaths(cheapestPaths)
            }
        }
    }

    override fun toString() = value
}
