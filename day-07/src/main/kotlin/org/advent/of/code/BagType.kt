package org.advent.of.code


class BagType(val color: String, val number: Int = 1) {

    override fun toString(): String {
        return "BagType(color='$color', number=$number)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BagType

        if (color != other.color) return false

        return true
    }

    override fun hashCode(): Int {
        return color.hashCode()
    }


}