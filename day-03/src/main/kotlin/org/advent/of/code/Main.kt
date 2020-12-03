package org.advent.of.code

fun main() {

    val puzzle = Day03()
    val resultForSlope1 = puzzle.computeResult("day-03-input.txt", 1, 1)
    val resultForSlope2 = puzzle.computeResult("day-03-input.txt", 3, 1)
    val resultForSlope3 = puzzle.computeResult("day-03-input.txt", 5, 1)
    val resultForSlope4 = puzzle.computeResult("day-03-input.txt", 7, 1)
    val resultForSlope5 = puzzle.computeResult("day-03-input.txt", 1, 2)

    println("Result = " + (resultForSlope1 * resultForSlope2 * resultForSlope3 * resultForSlope4 * resultForSlope5))
}

