package com.amazon.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Test {

    @Test
    fun test() {
        val codeList = arrayOf(
            "orange",
            "apple apple",
            "banana orange apple",
            "banana",
        )
        val shoppingList = arrayOf(
            "orange",
            "apple",
            "apple",
            "banana",
            "orange",
            "apple",
            "banana",
        )
        val sol = CodeList()
        val result = sol.foo(codeList, shoppingList)
        assertEquals(1, result)
    }

    @Test
    fun test2() {
        val codeList = arrayOf(
            "apple apricot",
            "banana anything guava",
            "papaya anything",
        )
        val shoppingList = arrayOf(
            "banana",
            "orange",
            "guava",
            "apple",
            "apricot",
            "papaya",
            "kiwi",
        )
        val sol = CodeList()
        val result = sol.foo(codeList, shoppingList)
    }

    @Test
    fun test3() {

    }
}
