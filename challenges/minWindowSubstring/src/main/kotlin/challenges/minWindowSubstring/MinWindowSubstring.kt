package challenges.minWindowSubstring

class MinWindowSubstring {
    fun min(input: String, target: String): Int {
        if(input == "" || target == "") {
            return 0
        }

        // Max 26 keys - the English alphabet
        val map = createMap(target.toCharArray())

        val chars = input.toCharArray()

        var shortest = -1

        for (start in chars.indices) {
            val mapCopy = map.toMutableMap()

            for (end in start until chars.size) {
                mapCopy[chars[end]]?.let { count ->
                    mapCopy[chars[end]] = count - 1
                    if (mapCopy[chars[end]] == 0) {
                        mapCopy.remove(chars[end])
                        val diff = end - start + 1
                        if (mapCopy.isEmpty() && (diff < shortest || shortest == -1)) {
                            shortest = diff
                        }
                    }
                }
            }
        }

        return shortest
    }

    private fun createMap(target: CharArray): MutableMap<Char, Int> =
        target.fold(mutableMapOf()) { acc, char ->
            acc[char]?.let {
                acc[char] = it + 1
            } ?: run {
                acc[char] = 1
            }
            acc
        }
}

