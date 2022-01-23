package com.amazon.interview

class Solution {
    fun searchSuggestions(repository: Array<String>, customerQuery: String): Array<Array<String>> {
        val query = customerQuery.lowercase()
        val result = mutableListOf<Array<String>>()
        val trie = Trie()

        val lowercaseRepo = repository.map {
            it.lowercase()
        }.sorted()
        lowercaseRepo.forEach { word ->
            trie.insert(word)
        }


        for (i in 2 .. query.length) {
            val subString = query.subSequence(0, i).toString()
            val matchedWords = trie.startsWith(subString).toTypedArray()
            result.add(matchedWords)
        }

        return result.toTypedArray()
    }
}

