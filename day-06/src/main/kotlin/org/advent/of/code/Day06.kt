package org.advent.of.code


class Day06 {

    fun computeResultPartOne(fileName: String): Int {
        return Utils.loadFileAndJoinSplittingByBlank(fileName)
            .map { FormAnswers(it) }
            .map { it.getNumberOfDistinctAnswers() }
            .reduce(Int::plus)
    }

    fun computeResultPartTwo(fileName: String): Int {
        return Utils.loadFileAndJoinSplittingByBlank(fileName)
            .map { FormAnswers(it) }
            .map { it.getNumberOfIntersectingAnswers() }
            .reduce(Int::plus)
    }

}