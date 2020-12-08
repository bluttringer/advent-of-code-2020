package org.advent.of.code


class Seat(data: String) {

    val rowNumber: Int
    val seatNumber: Int

    init {
        rowNumber = readSeatRow(data)
        seatNumber = readSeatNumber(data)
    }

    private fun readSeatRow(seatCoordinates: String): Int {
        val binaryRow = transformSeatCoordinateToBinary(seatCoordinates).subSequence(0, 7).toString()
        return Integer.parseInt(binaryRow, 2)
    }

    private fun readSeatNumber(seatCoordinates: String): Int {
        val binarySeatNumber = transformSeatCoordinateToBinary(seatCoordinates).subSequence(7, 10).toString()
        return Integer.parseInt(binarySeatNumber, 2)
    }

    fun computeSeatId() = rowNumber * 8 + seatNumber

    companion object SeatUtils {

        fun transformSeatCoordinateToBinary(seatCoordinate: String): String {
            return String(
                seatCoordinate.map {
                    when (it) {
                        'F', 'L' -> '0'
                        'B', 'R' -> '1'
                        else -> '#'
                    }
                }.toCharArray()
            )
        }
    }
}



