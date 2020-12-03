package org.advent.of.code


class Day01 {

    fun computeResult(fileName: String): Int {
        val entries = Utils.loadFile(fileName).map(Integer::parseInt)

        for (i in entries) {
            for (j in entries) {
                for (k in entries) {
                    if (i + j + k == 2020) {
                        return i * j * k
                    }
                }
            }
        }

        return 0;
    }

}