package interview.pickingNumbers

import kotlin.math.max

// https://www.hackerrank.com/challenges/picking-numbers/
class PickingNumbers {

    fun pickingNumbers(a: Array<Int>): Int {

        // Number -> length of list with (number - 1)
        val map = HashMap<Int, Int>()

        a.forEach { number ->
            map[number]?.let { length ->
                map[number] = length + 1
            } ?: run {
                map[number] = 1
            }

            val higherNumber = number + 1
            map[higherNumber]?.let { higherLength ->
                map[higherNumber] = higherLength + 1
            } ?: run { map[higherNumber] = 1 }

        }

        return map.entries.fold(0) { acc, entry ->
            max(entry.value, acc)
        }
    }
}

