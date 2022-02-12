package interview.skeleton

class ClimbLeaderboard {
    fun climbingLeaderboard(ranked: Array<Int>, player: Array<Int>): Array<Int> {
        val scoreToRankMap = LinkedHashMap<Int, Int>() //TODO array enough?

        ranked.forEach { score ->
            if (scoreToRankMap[score] == null) {
                scoreToRankMap[score] = scoreToRankMap.size
            }
        }

        val scores = scoreToRankMap.keys.toList()

        fun map(playerScore: Int): Int {
            var start = 0
            var end = scores.size
            var middle = end / 2

            //TODO could examine ends as well as middle with each run
            while (end != start) {
                val currentScore = scores[middle]

                if (playerScore == currentScore) {
                    return scoreToRankMap[currentScore]!!
                } else if (playerScore < currentScore) {
                    if (scores.size > middle + 1 &&
                        playerScore > scores[middle + 1]
                    ) {
                        return scoreToRankMap[scores[middle + 1]]!!
                    }
                    start = middle + 1
                    middle = start + ((end - start) / 2)
                } else {
                    if(0 < middle - 1 &&
                            playerScore < scores[middle - 1]) {
                        return scoreToRankMap[scores[middle]]!!
                    }
                    end = middle
                    middle = start + ((end - start) / 2)
                }
            }

            if(start == 0) { // New highest score
                return 1
            } else {         // New lowest score
                return scores.size
            }

        }

        return player.map { map(it) }.toTypedArray()
        // Nem mapolni kell, hanem az uj rankingban is lefuttatni a keresest
    }


}

