package org.advent.of.code

import kotlin.math.atan2


class Day09 {

    fun computeResultPartOne(fileName: String, preambleSize: Int): Long {
        val numbers = Utils.loadFile(fileName).map { it.toLong() }
        val numbersToCheck = numbers.subList(preambleSize, numbers.size)

        var currentIndex = 0
        for (number in numbersToCheck) {
            val possibleSums = computePossibleSums(numbers, currentIndex, currentIndex + preambleSize)
            if (!possibleSums.contains(number)) {
                return number
            }
            currentIndex++
        }
        return 0
    }

    fun computeResultPartTwo(fileName: String, searchFor: Long): Long {
        val numbers = Utils.loadFile(fileName).map { it.toLong() }

        var candidates: MutableList<Long>
        for (index in 0..numbers.size) {
            var currentSum = 0L
            candidates = mutableListOf()
            var currentIncrement = 0
            while (currentSum < searchFor) {
                currentSum += numbers[index + currentIncrement]
                candidates.add(numbers[index + currentIncrement])
                currentIncrement++
            }
            if (currentSum == searchFor) {
                val min = candidates.minOf { it }
                val max = candidates.maxOf { it }
                return min + max
            }
        }
        return 0
    }

    private fun computePossibleSums(numbers: List<Long>, fromIndex: Int, toIndex: Int): Set<Long> {
        var possibleSums = mutableSetOf<Long>()
        val numbersToSum = numbers.subList(fromIndex, toIndex)
        for (n1 in numbersToSum) {
            for (n2 in numbersToSum) {
                if (n1 != n2) {
                    possibleSums.add(n1 + n2)
                }
            }
        }
        return possibleSums;
    }
}