package org.advent.of.code

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


class PasswordPolicyNewTest {

    @ParameterizedTest
    @MethodSource("shouldCorrectlyValidatePasswordProvider")
    fun `should correclty validate password against policy`(nbMin: Int, nbMax: Int, letter: Char, password: String, result: Boolean) {
        val passwordPolicy = PasswordPolicyNew(nbMin, nbMax, letter)
        assertThat(passwordPolicy.isPasswordCompliant(password)).isEqualTo(result)
    }

    private companion object {
        @JvmStatic
        fun shouldCorrectlyValidatePasswordProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(1, 3, 'a', "abcde", true),
                Arguments.of(1, 3, 'a', "abade", false),
                Arguments.of(1, 3, 'b', "cdefg", false),
                Arguments.of(1, 3, 'b', "cdbfg", true),
                Arguments.of(2, 9, 'c', "ccccccccc", false),
                Arguments.of(2, 9, 'c', "caccccccc", true),
            )
        }
    }

}