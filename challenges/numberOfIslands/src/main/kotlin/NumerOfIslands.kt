package challenges.numberOfIslands

class NumerOfIslands(
    private val map: List<List<Int>>
) {

    fun count(): Int {
        var result = 0
        val visited = mutableListOf<MutableList<Boolean>>()

        map.forEach { row ->
            val list = mutableListOf<Boolean>()
            repeat(row.size) {
                list.add(false)
            }
            visited.add(list)
        }


        for (row in map.indices) {
            for (col in map[row].indices) {
                if (visited[row][col]) {
                    continue
                }

                if (map[row][col] == 1) {
                    mapIsland(row, col, visited)
                    result++
                } else {
                    visited[row][col] = true
                }
            }
        }
        return result
    }

    private fun mapIsland(row: Int, col: Int, visited: MutableList<MutableList<Boolean>>) {
        if (!visited[row][col]) {
            visited[row][col] = true
            if (map[row][col] == 1) {
                if (col + 1 < map.size) {
                    mapIsland(row, col + 1, visited)
                }
                if (row + 1 < map.size) {
                    mapIsland(row + 1, col, visited)
                }
            }
        }
    }
}
