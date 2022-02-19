package challenges.commonChild

class CommonChild {
    fun commonChild(s1: String, s2: String) =
        dp(s1.toCharArray(), s2.toCharArray())

    private fun dp(array1: CharArray, array2: CharArray): Int {

        val matrix = array1.map { char ->
            Array(array2.size) {
                0
            }
        }.toTypedArray()

        for (row in array1.indices) {
            for (col in array2.indices) {
                if (row == 0) {
                    if (col == 0) {
                        if (array1[row] == array2[col]) {
                            matrix[row][col] = 1
                        } else {
                            matrix[row][col] = 0
                        }
                    } else {
                        if (array1[row] == array2[col]) {
                            matrix[row][col] = 1
                        } else {
                            matrix[row][col] = matrix[row][col - 1]
                        }
                    }
                } else {
                    if (col == 0) {
                        if (array1[row] == array2[col]) {
                            matrix[row][col] = 1
                        } else {
                            matrix[row][col] = matrix[row - 1][col]
                        }
                    } else {
                        if (array1[row] == array2[col]) {
                            matrix[row][col] = matrix[row - 1][col - 1] + 1
                        } else {
                            matrix[row][col] = Math.max(matrix[row - 1][col], matrix[row][col - 1])
                        }
                    }
                }

            }
        }
        return matrix[matrix.size - 1][matrix[0].size - 1]
    }
}
