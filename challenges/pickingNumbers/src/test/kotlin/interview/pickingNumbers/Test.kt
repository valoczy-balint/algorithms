package interview.pickingNumbers


import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Test {
    private val underTest = PickingNumbers()

    @Test
    fun test() {
        val input = arrayOf(1, 1, 2, 2, 4, 4, 5, 5, 5)
        Assertions.assertEquals(5, underTest.pickingNumbers(input))
    }

    @Test
    fun test2() {
        val input = arrayOf(4, 6, 5, 3, 3, 1)
        Assertions.assertEquals(3, underTest.pickingNumbers(input))
    }

    @Test
    fun test3() {
        val input = arrayOf(
            84,
            43,
            11,
            41,
            2,
            99,
            31,
            32,
            56,
            53,
            42,
            14,
            98,
            27,
            64,
            57,
            16,
            33,
            48,
            21,
            46,
            61,
            87,
            90,
            28,
            12,
            62,
            49,
            29,
            77,
            82,
            70,
            80,
            89,
            95,
            52,
            13,
            19,
            9,
            79,
            35,
            67,
            51,
            39,
            7,
            1,
            66,
            8,
            17,
            85,
            71,
            97,
            34,
            73,
            75,
            6,
            91,
            40,
            96,
            65,
            37,
            74,
            20,
            68,
            23,
            47,
            76,
            55,
            24,
            3,
            30,
            22,
            55,
            5,
            69,
            86,
            54,
            50,
            10,
            59,
            15,
            4,
            36,
            38,
            83,
            60,
            72,
            63,
            78,
            58,
            88,
            93,
            45,
            18,
            94,
            44,
            92,
            81,
            25,
            26
        )
        Assertions.assertEquals(3, underTest.pickingNumbers(input))
    }


}
