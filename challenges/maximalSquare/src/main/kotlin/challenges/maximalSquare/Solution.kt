package challenges.maximalSquare

import kotlin.math.min

// https://leetcode.com/problems/maximal-square/
class Solution {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        // Stores the size of the square whose bottom right cell is the given cell
        val cache = Array(matrix.size) {
            CharArray(matrix[0].size)
        }

        var max = 0

        matrix.indices.forEach { row ->
            matrix[row].indices.forEach { col ->
                val element = matrix[row][col]

                if (element == '1') {
                    if (row == 0 || col == 0) {
                        cache[row][col] = '1'
                    } else {
                        val top = cache[row-1][col].digitToInt()
                        val left = cache[row][col-1].digitToInt()
                        val topLeft = cache[row-1][col-1].digitToInt()

                        val min = min(min(top, left), topLeft)
                        cache[row][col] = (min +1).digitToChar()
                    }
                } else {
                    cache[row][col] = '0'
                }

                val cached = cache[row][col].digitToInt()
                if(cached > max) {
                    max = cached
                }
            }

        }

        return max * max
    }
}

