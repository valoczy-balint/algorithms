package challenges.magicSquare

import kotlin.math.min

class MagicSquare {

    fun formingMagicSquare(s: Array<Array<Int>>) =
        getAllMagicSquares().fold(Int.MAX_VALUE) { acc, item ->
            min(acc, calculateTransformationCost(item, s))
        }

    private fun calculateTransformationCost(magicSquare: Array<Array<Int>>, square: Array<Array<Int>>): Int {
        var cost = 0

        magicSquare.indices.forEach { row ->
            magicSquare[row].indices.forEach { col ->
                cost += Math.abs(square[row][col] - magicSquare[row][col])
            }
        }

        return cost
    }

    private fun getAllMagicSquares() =
        listOf(
            arrayOf(
                arrayOf(4, 3, 8),
                arrayOf(9, 5, 1),
                arrayOf(2, 7, 6),
            ),
            arrayOf(
                arrayOf(8, 3, 4),
                arrayOf(1, 5, 9),
                arrayOf(6, 7, 2),
            ),
            arrayOf(
                arrayOf(8, 1, 6),
                arrayOf(3, 5, 7),
                arrayOf(4, 9, 2),
            ),
            arrayOf(
                arrayOf(4, 9, 2),
                arrayOf(3, 5, 7),
                arrayOf(8, 1, 6),
            ),
            arrayOf(
                arrayOf(2, 7, 6),
                arrayOf(9, 5, 1),
                arrayOf(4, 3, 8),
            ),
            arrayOf(
                arrayOf(6, 7, 2),
                arrayOf(1, 5, 9),
                arrayOf(8, 3, 4),
            ),
            arrayOf(
                arrayOf(6, 1, 8),
                arrayOf(7, 5, 3),
                arrayOf(2, 9, 4),
            ),
            arrayOf(
                arrayOf(2, 9, 4),
                arrayOf(7, 5, 3),
                arrayOf(6, 1, 8),
            ),
        )
}

/**
 * 1. The sum of each col/row/diag is 15
 * - if the sum of a row is x, the sum of all 3 rows is 3X
 * - 1+2+...9 = 45 => 45 = 3x => X = 15
 * 2. There are 8 ways to sum these numbers to 15
 * 3. The center square is always 5
 * - The center has square has to be in 4 of these sequences
 * - Only 5 is present in 4 sequences
 * 4. Apply the same logic to corners
 * - Only those numbers that are present in 3 sequences can be in the corner
 * - 2, 4, 6, 8
 * 5. Apply same logic to the edges
 * - Only numbers that are present in 2 sequences can be on the edge
 * - 1, 3, 5, 7, 9
 */
