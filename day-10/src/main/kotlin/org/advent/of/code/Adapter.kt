package org.advent.of.code


class Adapter(val rating: Int, var diffFromPrevious: Int = 0, var diffToNext: Int = 0) {
    override fun toString(): String {
        return "Adapter(rating=$rating, diiffFromPrevious=$diffFromPrevious, diffToNext=$diffToNext)"
    }
}