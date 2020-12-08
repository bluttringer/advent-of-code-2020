package org.advent.of.code


class Day05 {

    fun computeResultPartOne(fileName: String): Int {
        return Utils.loadFile(fileName)
            .map { Seat(it) }
            .map { it.computeSeatId() }
            .maxOf { it }
    }

    fun computeResultPartTwo(fileName: String): Int {
        val seatIdList = Utils.loadFile(fileName)
            .map { Seat(it) }
            .map { it.computeSeatId() }

        val minSeatId = seatIdList.minOf { it }
        val maxSeatId = seatIdList.maxOf { it }

        for (id in minSeatId + 1..maxSeatId) {
            if (!seatIdList.contains(id) && seatIdList.contains(id - 1) && seatIdList.contains(id + 1)) {
                return id
            }
        }

        return 0
    }

}