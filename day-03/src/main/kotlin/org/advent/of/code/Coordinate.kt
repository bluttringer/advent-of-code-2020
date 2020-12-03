package org.advent.of.code


class Coordinate(val x: Int, val y: Int) {

    operator fun plus(coordinate: Coordinate) = Coordinate(
        this.x + coordinate.x,
        this.y + coordinate.y
    )

}