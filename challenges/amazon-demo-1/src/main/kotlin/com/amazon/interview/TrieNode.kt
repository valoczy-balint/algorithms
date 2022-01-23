package com.amazon.interview

data class TrieNode (
    val children: MutableMap<Char, TrieNode> = LinkedHashMap(),
    var endOfWord: Boolean = false,
    var word : String? = null,
    var count: Int = 1
)
