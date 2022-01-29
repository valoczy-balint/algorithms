package challenges.searchInRotatedSortedArray

class SearchInRotatedSortedArray {
    fun find(input: List<Int>, target: Int): Int {
        var start = 0
        var end = input.size
        var middle = end / 2

        fun moveScopeLeft() {
            end = middle
        }

        fun moveScopeRight() {
            start = middle + 1
        }

        fun isInFirstPart(number: Int): Boolean {
            return number >= input[0]
        }

        val targetIsInFirstPart = isInFirstPart(target)

        while (start != end) {
            val current = input[middle]

            if (current == target) {
                return middle
            }
            val currentIsInFirstPart = isInFirstPart(current)



            if (targetIsInFirstPart) {
                if (currentIsInFirstPart) {
                    if (target < current) {
                        moveScopeLeft()
                    } else {
                        moveScopeRight()
                    }
                } else {    // Current is in second part
                    moveScopeLeft()
                }
            } else {        // Target is in second part
                if (currentIsInFirstPart) {
                    moveScopeRight()
                } else {    // Current is in second part
                    if (target < current) {
                        moveScopeLeft()
                    } else {
                        moveScopeRight()
                    }
                }
            }
            middle = (start + end) / 2
        }

        return -1
    }
}
