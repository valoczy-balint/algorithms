package challenges.courseSchedule

import java.util.Stack

// https://leetcode.com/problems/course-schedule/
class CourseSchedule {

    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph = buildGraph(prerequisites)

        val visited = mutableSetOf<Int>()

        graph.keys.forEach { key ->
            if (!visited.contains(key)) {
                val order = Stack<Int>()
                val path = Stack<Int>()

                try {
                    recursive(graph, path, order, key)
                    visited.addAll(order)
                } catch (e: RuntimeException) {
                    return false
                }
            }
        }
        return true

    }

    private fun recursive(
        graph: Map<Int, List<Int>>,
        path: Stack<Int>,
        order: Stack<Int>,
        current: Int
    ) {
        if (path.contains(current)) {
            throw RuntimeException()
        }

        path.push(current)

        val neighbours = graph[current]

        neighbours?.forEach { neighbour ->
            if(!order.contains(neighbour)) {
                recursive(graph, path, order, neighbour)
            }
        }

        order.push(path.pop())
    }

    private fun buildGraph(prerequisites: Array<IntArray>): Map<Int, List<Int>> {
        val result = mutableMapOf<Int, MutableList<Int>>()

        prerequisites.forEach { edge ->
            val start = edge[0]
            val end = edge[1]

            result[start]?.add(end) ?: run {
                result[start] = mutableListOf(end)
            }
        }

        return result
    }
}
