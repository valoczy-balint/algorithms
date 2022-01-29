package com.amazon.interview

class CodeList {

    // ["banana apple kiwi", "orange apple anything"]
    // ["banana apple kiwi mango orange apple kiwi]
    // [orange, apple, apple, banana, apple kiwi, orange apple apple]

    fun foo(codeList: Array<String>, shoppingCart: Array<String>): Int {
        var codeListIndex = 0
        var codeIndex = 0
        var currentCodeList: List<String> = emptyList()

        shoppingCart.forEach { currentItem ->
            if(currentCodeList.isNotEmpty() && codeIndex >= currentCodeList.size) {
                codeListIndex++
                codeIndex = 0
            }
            currentCodeList = codeList[codeListIndex].split(" ")

            val currentCode = currentCodeList[codeIndex]

            if("anything".equals(currentCode, true) || currentCode.equals(currentItem, true)) {
                codeIndex++
            } else {
                codeIndex = 0
            }
            if(codeListIndex >= codeList.size - 1 && codeIndex >= currentCodeList.size) {
                return 1
            }
        }
        return 0
    }
}
