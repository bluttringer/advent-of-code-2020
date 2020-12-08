package org.advent.of.code

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


class SeatTest {

    @ParameterizedTest
    @MethodSource("seatCoordinates")
    fun `should correctly interpret seat coordinates`(
        seatCoordinates: String,
        expectedRowNumber: Int,
        expectedSeatNumber: Int,
        expectedSeatId: Int
    ) {
        val seat = Seat(seatCoordinates)
        assertThat(seat.rowNumber).isEqualTo(expectedRowNumber);
        assertThat(seat.seatNumber).isEqualTo(expectedSeatNumber);
        assertThat(seat.computeSeatId()).isEqualTo(expectedSeatId);
    }

    private companion object {
        @JvmStatic
        fun seatCoordinates(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("BFFFBBFRRR", 70, 7, 567),
                Arguments.of("FFFBBBFRRR", 14, 7, 119),
                Arguments.of("BBFFBBFRLL", 102, 4, 820)
            )
        }
    }
}