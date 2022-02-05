package challenges.birthdayBar

// https://www.hackerrank.com/challenges/the-birthday-bar/problem
class BirthdayBar {
    fun birthday(s: Array<Int>, d: Int, m: Int): Int {
        var result = 0
        for (i in 0..s.size - m) {
            var sum = 0
            for (j in i until (i + m)) {
                sum += s[j]
            }
            if (sum == d) {
                result++
            }
        }
        return result
    }
}

