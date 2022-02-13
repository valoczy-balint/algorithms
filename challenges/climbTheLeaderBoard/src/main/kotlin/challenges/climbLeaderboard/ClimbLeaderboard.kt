package challenges.climbLeaderboard

class ClimbLeaderboard {
    fun climbingLeaderboard(ranked: Array<Int>, player: Array<Int>): Array<Int> {
        // Rank = index + 1
        val scores = ranked.fold(mutableSetOf<Int>()) { acc, item ->
            acc.add(item)
            acc
        }.toTypedArray()

        fun map(playerScore: Int): Int {
            var start = 0
            var end = scores.size
            var middle = end / 2

            //TODO could examine ends as well as middle with each run
            while (end != start) {
                val currentScore = scores[middle]

                if (playerScore == currentScore) {
                    return middle + 1
                } else if (playerScore < currentScore) {
                    if (scores.size > middle + 1 &&
                        playerScore > scores[middle + 1]
                    ) {
                        return middle + 2
                    }
                    start = middle + 1
                    middle = start + ((end - start) / 2)
                } else {
                    if (0 <= middle - 1 &&
                        playerScore < scores[middle - 1]
                    ) {
                        return middle + 1
                    }
                    end = middle
                    middle = start + ((end - start) / 2)
                }
            }

            return if (start == 0) { // New highest score
                1
            } else {                 // New lowest score
                scores.size + 1
            }

        }

        return player.map { map(it) }.toTypedArray()
    }


}

