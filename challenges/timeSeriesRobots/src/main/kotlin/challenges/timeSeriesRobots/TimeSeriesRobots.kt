package challenges.timeSeriesRobots

/**
 * This is a practise exercise for one of the FAANG
 * I get an array of arrays and the number of robots on a map
 * Each row represents the state of the map in a given moment
 * The map itself is of course 2D (an array) in which a 1 is a robot, 0 is no robots on that spot
 * A robot can move 1 position in either direction per time tick (between arrays)
 * The task is to figure out if the input is a valid time series data of robot positions
 */
class TimeSeriesRobots {
    fun isValidTimeSeries(matrix: Array<Array<Int>>, numRobots: Int): Boolean {
        fun countRobots() = matrix[matrix.size - 1].sum() == numRobots

        matrix.indices.forEach { rowIndex ->
            if (rowIndex == matrix.size - 1) {
                return countRobots()
            }

            val currentRow = matrix[rowIndex]
            val nextRow = matrix[rowIndex + 1]

            val nextRowCopy = nextRow.copyOf()
            var robotsInRow = 0

            currentRow.indices.forEach { colIndex ->
                if (currentRow[colIndex] == 1) {
                    robotsInRow++

                    if (colIndex != 0
                        && nextRowCopy[colIndex - 1] == 1
                    ) {
                        nextRowCopy[colIndex - 1] = 0
                    } else if (nextRowCopy[colIndex] == 1) {
                        nextRowCopy[colIndex] = 0
                    } else if (colIndex != currentRow.size - 1
                        && nextRowCopy[colIndex + 1] == 1
                    ) {
                        nextRowCopy[colIndex + 1] = 0
                    } else {
                        return false
                    }
                }
            }
            if (robotsInRow != numRobots) {
                return false
            }
        }
        return true
    }
}
