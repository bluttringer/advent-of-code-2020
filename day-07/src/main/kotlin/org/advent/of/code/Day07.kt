package org.advent.of.code


class Day07 {

    fun computeResultPartOne(fileName: String): Int {

        val bagTypes = Utils.loadFile(fileName)
            .map {
                BagRuleParser(it)
            }
            .map { it.bagType to it.containedBagType }
            .toMap()

        return findBagTypeWithColor(BagType("shiny gold"), bagTypes, setOf(), bagTypes.keys).size
    }

    fun computeResultPartTwo(fileName: String): Int {
        val bagTypes = Utils.loadFile(fileName)
            .map {
                BagRuleParser(it)
            }
            .map { it.bagType to it.containedBagType }
            .toMap()

        return countBagContainedIn(BagType("shiny gold"), bagTypes) - 1
    }

    private fun findBagTypeWithColor(
        searchedBagType: BagType,
        allBagTypes: Map<BagType, Set<BagType>>,
        allParents: Set<BagType>,
        searchIn: Set<BagType>
    ): Set<BagType> {
        var result = mutableSetOf<BagType>()
        for (bagType in searchIn) {
            if (bagType == searchedBagType) {
                result.addAll(allParents)
            }
            if (hasChildren(bagType, allBagTypes)) {
                val newAllParents = mutableSetOf(bagType)
                newAllParents.addAll(allParents)
                result.addAll(findBagTypeWithColor(searchedBagType, allBagTypes, newAllParents, allBagTypes[bagType]!!))
            }
        }
        return result
    }

    private fun countBagContainedIn(
        searchedBagType: BagType,
        allBagTypes: Map<BagType, Set<BagType>>
    ): Int {
        val children = allBagTypes[searchedBagType]

        var currentCount = searchedBagType.number
        if (children!!.isNotEmpty()) {
            for (child in children) {
                currentCount += searchedBagType.number * countBagContainedIn(child, allBagTypes)
            }
        }
        return currentCount
    }

    private fun hasChildren(bagType: BagType, allBagTypes: Map<BagType, Set<BagType>>) =
        allBagTypes[bagType]!!.isNotEmpty()
}