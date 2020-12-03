package org.advent.of.code


class Day03 {

    fun computeResult(fileName: String, xIncrement: Int, yIncrement: Int): Int {
        val entries = Utils.loadFile(fileName)
        val coordinateIncrement = Coordinate(xIncrement, yIncrement)
        var numberOfTrees = 0

        var currentCoordinate = Coordinate(0,0)
        while (currentCoordinate.y < entries.size) {
            val itemPicker = ItemPicker(entries[currentCoordinate.y])
            val item = itemPicker.pickItemAt(currentCoordinate.x)
            if (item == '#') {
                numberOfTrees++
            }
            currentCoordinate += coordinateIncrement
        }

        return numberOfTrees
    }

}