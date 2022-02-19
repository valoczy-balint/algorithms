package dijkstra

import heap.MinHeap

class DijkstraWithHeap {
    private val minHeap = MinHeap<TentativeDistance>()

    fun findShortestPaths(start: Node): MutableMap<Node, Int> {
        val visited = mutableSetOf<Node>()
        val shortestPaths = mutableMapOf<Node, Int>()
        shortestPaths[start] = 0

        minHeap.insert(TentativeDistance(start, 0))

        while (minHeap.isNotEmpty()) {
            val tentativeDistance = minHeap.delete()
            val node = tentativeDistance.node
            val distanceFromStart = tentativeDistance.distance

            if (visited.contains(node)) {
                continue
            }

            node.neighbours.forEach { (neighbor, distanceFromCurrent) ->
                minHeap.insert(TentativeDistance(neighbor, distanceFromCurrent + distanceFromStart))

                if (!shortestPaths.contains(neighbor)) {
                    shortestPaths[neighbor] = shortestPaths[node]!! + distanceFromCurrent
                } else if (shortestPaths[node]!! + distanceFromCurrent < shortestPaths[neighbor]!!) {
                    shortestPaths[neighbor] = shortestPaths[node]!! + distanceFromCurrent
                }
            }

            visited.add(node)
        }

        return shortestPaths
    }
}
