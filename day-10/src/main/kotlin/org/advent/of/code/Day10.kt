package org.advent.of.code


class Day10 {

    fun computeResultPartOne(fileName: String): Int {
        val ratings = Utils.loadFile(fileName).map { Adapter(it.toInt()) }.toMutableList()
        ratings.add(0, Adapter(0))
        ratings.add(Adapter(ratings.maxOf { it.rating } + 3))
        ratings.sortBy { it.rating }

        var currentIndex = 0
        for (rating in ratings) {
            if (currentIndex != 0) {
                rating.diffFromPrevious = rating.rating - ratings[currentIndex - 1].rating
            }
            currentIndex++
        }

        return ratings.filter { it.diffFromPrevious == 1 }.size * ratings.filter { it.diffFromPrevious == 3 }.size
    }

    fun computeResultPartTwo(fileName: String): Long {
        val adapters = Utils.loadFile(fileName).map { Adapter(it.toInt()) }.toMutableList()
        adapters.add(0, Adapter(0))
        adapters.add(Adapter(adapters.maxOf { it.rating } + 3))
        adapters.sortBy { it.rating }

        return computePossibilities2(adapters, 0, mutableMapOf())
    }

    private fun computePossibilities2(adapters: List<Adapter>, index: Int, cache: MutableMap<Int, Long>): Long {
        if (index == adapters.size - 1) {
            return 1L
        }

        if (cache.containsKey(index)) return cache[index]!!

        var count = 0L
        for (i in index + 1 until adapters.size) {
            if (adapters[i].rating - adapters[index].rating <= 3) {
                // adapter optionnel
                count += computePossibilities2(adapters, i, cache)
            }
        }
        cache[index] = count
        return count
    }
}