package org.advent.of.code

object Utils {

    fun loadFile(fileName: String): List<String> {
        var sanitizedFileName = fileName;
        if (!sanitizedFileName.startsWith("/")) {
            sanitizedFileName = "/$sanitizedFileName"
        }
        return Utils::class.java.getResourceAsStream(sanitizedFileName).bufferedReader().readLines()
    }

    fun loadFileAndJoinSplittingByBlank(fileName: String, separator: String = "@"): List<String> {
        var sanitizedFileName = fileName;
        if (!sanitizedFileName.startsWith("/")) {
            sanitizedFileName = "/$sanitizedFileName"
        }
        return Utils::class.java.getResourceAsStream(sanitizedFileName).bufferedReader().readLines()
            .joinToString(" ") { if (it.isBlank()) "$separator" else it }
            .split(separator)
    }

}

