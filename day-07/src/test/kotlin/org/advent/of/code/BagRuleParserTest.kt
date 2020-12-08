package org.advent.of.code

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


class BagRuleParserTest {

    @ParameterizedTest
    @MethodSource("bagRules")
    fun `should correctly parse bag rules`(
        bagRule: String,
        bagType: BagType,
        containedBagTypes: List<BagType>
    ) {
        val bagRuleParser = BagRuleParser(bagRule)
        assertThat(bagRuleParser.bagType).isEqualTo(bagType);
        assertThat(bagRuleParser.containedBagType.size).isEqualTo(containedBagTypes.size)
        assertThat(bagRuleParser.containedBagType).containsAll(containedBagTypes)
    }

    private companion object {
        @JvmStatic
        fun bagRules(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    "light red bags contain 1 bright white bag, 2 muted yellow bags.",
                    BagType("light red"),
                    listOf(BagType("bright white"), BagType("muted yellow"))
                ),
                Arguments.of(
                    "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
                    BagType("dark orange"),
                    listOf(BagType("bright white"), BagType("muted yellow"))
                ),
                Arguments.of(
                    "faded blue bags contain no other bags.",
                    BagType("faded blue"),
                    emptyList<BagType>()
                ),
                Arguments.of(
                    "bright white bags contain 1 shiny gold bag.",
                    BagType("bright white"),
                    listOf(BagType("shiny gold"))
                )
            )
        }
    }
}