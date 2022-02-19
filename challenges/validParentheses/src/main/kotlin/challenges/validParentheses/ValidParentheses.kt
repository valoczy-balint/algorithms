package challenges.validParentheses


fun countValidCombinations(n: Int) =
    recursive(0, n)


fun recursive(openCount: Int, remainingToOpen: Int): Int {
    if(openCount <= 0 && remainingToOpen <= 0) {
        return 1
    }

    var withOpen = 0
    var withClosed = 0

    // Can open
    if (remainingToOpen > 0) {
        withOpen = recursive(openCount + 1, remainingToOpen - 1)
    }
    // Can close
    if (openCount > 0) {
        withClosed = recursive(openCount - 1, remainingToOpen)
    }

    return withOpen + withClosed
}
