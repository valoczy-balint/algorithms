package challenges.commonChild

class CommonChildRecursive {
    fun commonChild(s1: String, s2: String) =
        recursive(s1.toCharArray(), s2.toCharArray(), 0)

    private fun recursive(array1: CharArray, array2: CharArray, sum: Int): Int {
        if (array1.isEmpty() || array2.isEmpty()) {
            return sum
        }

        val current = array1[0]
        val currentIndexInArray2 = array2.indexOf(current)

        if (array1.size == 1) {
            return if (currentIndexInArray2 == -1) sum else sum + 1
        }
        val nextArray1 = array1.copyOfRange(1, array1.size)

        return if (currentIndexInArray2 == -1) {
            recursive(nextArray1, array2, sum)
        } else {
            if (array2.size <= currentIndexInArray2 + 1) {
                sum + 1
            } else {
                val nextArray2 = array2.copyOfRange(currentIndexInArray2 + 1, array2.size)
                Math.max(
                    recursive(nextArray1, array2, sum),
                    recursive(nextArray1, nextArray2, sum + 1)
                )
            }
        }
    }
}

