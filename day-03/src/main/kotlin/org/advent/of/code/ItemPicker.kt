package org.advent.of.code


class ItemPicker(private val data: String) {
    fun pickItemAt(x: Int): Char {
        return data[x % data.length]
    }
}

