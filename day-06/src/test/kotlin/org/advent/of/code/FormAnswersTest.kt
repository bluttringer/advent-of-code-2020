package org.advent.of.code

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


class FormAnswersTest {

    @ParameterizedTest
    @MethodSource("answers")
    fun `should correctly count distinct answers`(
        answers: String,
        expectedNumberOfDistinctAnswers: Int
    ) {
        val formAnswers = FormAnswers(answers)
        assertThat(formAnswers.getNumberOfDistinctAnswers()).isEqualTo(expectedNumberOfDistinctAnswers);
    }

    private companion object {
        @JvmStatic
        fun answers(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("abc", 3),
                Arguments.of("a b c",3),
                Arguments.of("ab ac", 3),
                Arguments.of("a a a a", 1),
                Arguments.of("b", 1)
            )
        }
    }
}