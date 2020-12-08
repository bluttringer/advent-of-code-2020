package org.advent.of.code


class FormAnswers(answers: String) {

    val answerSet: Set<Char>

    val answerIntersection: Int

    init {
        answerSet = readDistinctAnswers(answers)
        answerIntersection = countIntersectingAnswers(answers)
    }

    private fun readDistinctAnswers(answers: String): Set<Char> {
        val sanitizedAnswers = answers.replace(" ", "")
        return sanitizedAnswers.toSet()
    }

    private fun countIntersectingAnswers(answers: String): Int {
        var intersectingAnswers = "abcdefghijklmnopqrstuvwxyz1".toSet()

        for (answer in answers.split(" ")) {
            if (answer.isNotBlank()) {
                intersectingAnswers = intersectingAnswers.intersect(answer.toSet())
            }
        }

        return intersectingAnswers.size
    }

    fun getNumberOfDistinctAnswers() = answerSet.size

    fun getNumberOfIntersectingAnswers() = answerIntersection
}



