package org.advent.of.code

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


class ItemPickerTest {

    @ParameterizedTest
    @MethodSource("shouldPickCorrectItemDataProvider")
    fun `should pick correct item in data for given abscissa`(data: String, x: Int, expected: Char) {
        val itemPicker = ItemPicker(data)
        assertThat(itemPicker.pickItemAt(x)).isEqualTo(expected)
    }

    private companion object {
        @JvmStatic
        fun shouldPickCorrectItemDataProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1234", 0, '1'),
                Arguments.of("1234", 6, '3'),
                Arguments.of("#..##...###", 1, '.'),
                Arguments.of("#..##...###", 35, '.')
            )
        }
    }

}