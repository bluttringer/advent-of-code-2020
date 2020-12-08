package org.advent.of.code


class BagRuleParser(rule: String) {

    val GLOBAL_REGEX = Regex("^(.*) contain (?:no other|(.*))\$")
    val CONTAINED_BAG_TYPE_REGEX = Regex("^(\\d+) (.*)\$")
    val bagType: BagType
    val containedBagType: Set<BagType>

    init {
        val parsedRule = parseRule(rule)
        bagType = parsedRule.first
        containedBagType = parsedRule.second
    }

    private fun parseRule(rule: String): Pair<BagType, Set<BagType>> {
        val sanitizedRule = rule
            .replace(" bags", "")
            .replace(" bag", "")
            .replace(".", "")
            .replace(", ", ",")
        val globalParsing = GLOBAL_REGEX.find(sanitizedRule)!!.groupValues.filter { it.isNotBlank() }
        val bagType = BagType(globalParsing[1])

        val containedBagTypes = if (globalParsing.size > 2) {
            globalParsing[2].split(",")
                .map {
                    val parsingGroups = CONTAINED_BAG_TYPE_REGEX.find(it)!!.groupValues
                    BagType(parsingGroups[2])
                }.toSet()
        } else {
            emptySet()
        }

        return Pair(bagType, containedBagTypes)
    }

}