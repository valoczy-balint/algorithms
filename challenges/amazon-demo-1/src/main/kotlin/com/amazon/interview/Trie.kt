package com.amazon.interview

class Trie {
    private val root: TrieNode = TrieNode()

    fun insert(word: String) {
        var current = root
        for (c in word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children[c] = TrieNode()
            }
            current = current.children[c]!!
        }
        if(current.endOfWord) {
            current.count++
        } else {
            current.endOfWord = true
        }
        current.word = word
    }

    fun startsWith(word: String): List<String> {
        val result = mutableListOf<String>()
        var current: TrieNode = root
        for (c in word.toCharArray()) {
            current.children[c]?.let {
                current = it
            } ?: return emptyList()
        }

        recursive(current, result)

        return result
    }

    private fun recursive(node: TrieNode, result : MutableList<String>) {
        if(result.size == 3) {
            return
        }

        if(node.endOfWord) {
            for (i in 0 until node.count) {
                result.add(node.word!!)
                if(result.size == 3) {
                    return
                }
            }
        }

        node.children.forEach {
            recursive(it.value, result)
        }

    }
}
