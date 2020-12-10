package org.advent.of.code

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


class OperationListParserTest {

    @ParameterizedTest
    @MethodSource("operations")
    fun `should correctly parse operations`(
        operationsList: List<String>,
        expectedOperations: List<Operation>
    ) {
        val operationListParser = OperationListParser(operationsList)
        assertThat(operationListParser.operations).containsExactlyElementsOf(expectedOperations);
    }

    private companion object {
        @JvmStatic
        fun operations(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(
                        "acc +1",
                        "nop +2",
                        "jmp -4",
                        "jmp -20",
                        "nop +0"
                    ),
                    listOf(
                        Operation(Operator.ACC, 1),
                        Operation(Operator.NOP, 2),
                        Operation(Operator.JMP, -4),
                        Operation(Operator.JMP, -20),
                        Operation(Operator.NOP, 0)
                    )
                )
            )
        }
    }
}