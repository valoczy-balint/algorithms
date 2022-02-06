package interview.pickingNumbers

// https://www.hackerrank.com/challenges/picking-numbers/
class PickingNumbers {
    fun pickingNumbers(a: Array<Int>): Int {
        var longestSubarray = 0
        var currentSubarray = 1
        a.indices.forEach { i ->

            if (i > 0 && Math.abs(a[i] - a[i-1]) < 2) {
                currentSubarray++
            } else {
                currentSubarray = 1
            }

            if(currentSubarray > longestSubarray) {
                longestSubarray  = currentSubarray
            }
        }

        return longestSubarray
    }
}

