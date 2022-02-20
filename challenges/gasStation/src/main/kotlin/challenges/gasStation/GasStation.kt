package challenges.gasStation

// https://leetcode.com/problems/gas-station/
class GasStation {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var stationIndex = 0
        while(stationIndex < gas.size) {
            val result = go(gas, cost, stationIndex)

            if(result == -1) {
                return stationIndex
            } else if(result > stationIndex){
                stationIndex = result + 1
            } else {
                stationIndex++
            }
        }
        return -1
    }

    private fun go(gas: IntArray, cost: IntArray, startIndex: Int): Int {
        var currentIndex = startIndex
        var result = -1
        var gasInTank = 0L
        do {
            val gasAtStation = gas[currentIndex]
            val costToNextStation = cost[currentIndex]
            gasInTank += gasAtStation
            if(gasInTank < costToNextStation) {
                result = currentIndex
                break;
            }

            gasInTank -= costToNextStation

            currentIndex += 1
            if(currentIndex >= gas.size) {
                currentIndex = 0
            }
        } while(currentIndex != startIndex)
        return result
    }
}
