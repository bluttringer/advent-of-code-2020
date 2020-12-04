package org.advent.of.code


class Day04 {

    fun computeResult(fileName: String): Int {
        val validPassports = PassportExtractor(Utils.loadFile(fileName))
            .extractPassports()
            .filter { it.isValidStrict() }

        return validPassports.size
    }


}