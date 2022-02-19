package com.amazon.interview

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Test {

    @Test
    fun test() {

//        val repo = arrayOf(
//            "bags",
//            "baggage",
//            "banner",
//            "box",
//            "cloths"
//        )
//        val query = "bags";
        val repo = arrayOf(
            "5",
            "bags",
            "baggage",
            "banner",
            "box",
            "cloths",
            "bags",
        )
        val query = "bags"

//        "abc", "abbs", "abbs"

        val solution = Solution()

        val result = solution.searchSuggestions(repo, query)

        println(result.toString())
    }

    @Test
    fun test2() {

        val repo = arrayOf(
            "abbS",
            "abc",
            "Abs",
            "bcs",
            "bdsa",
            "cdde",
            "rgb",
            "yjmm",
            "xxmm",
            "zeee",
        )
        val query = "abbs"

        val solution = Solution()

        val result = solution.searchSuggestions(repo, query)
        val expected = arrayOf(
            arrayOf("abbS", "abc", "abs"),
            arrayOf("abbS"),
            arrayOf("abbS")
        )
        Assertions.assertEquals(expected, result)
        println(result.toString())
    }

    @Test
    fun test3() {

        val repo = arrayOf(
            "abbS",
            "abc",
            "Abs",
            "bcs",
            "bdsa",
            "cdde",
            "rgb",
            "yjmm",
            "xxmm",
            "zeee",
            "abs abbs abc",
            "abbs",
            "abbs",
        )
        val query = "abbs"

        val solution = Solution()

        val result = solution.searchSuggestions(repo, query)

        println(result.toString())
    }

    @Test
    fun test10() {

        val repo = arrayOf(
            "ab",
            "aBC",
            "abc",
            "Abcd",
            "abcde",
            "abCdef",
            "abcdefg",
            "abCdefgH",
        )
        val query = "abcdef"

        val solution = Solution()

        val result = solution.searchSuggestions(repo, query)
        val expected = arrayOf(
            arrayOf("ab", "abc", "abc"),
            arrayOf("abc", "abc", "abcd"),
            arrayOf("abcd", "abcde", "abcdef"),
            arrayOf("abcde", "abcdef", "abcdefg"),
            arrayOf("abcdef", "abcdefg", "abcdefgh")

        )
        Assertions.assertEquals(expected, result)

        println(result.toString())
    }


}
