package org.advent.of.code

object Utils {

    fun loadFile(fileName: String): List<String> {
        var sanitizedFileName = fileName;
        if (!sanitizedFileName.startsWith("/")) {
            sanitizedFileName = "/$sanitizedFileName"
        }
        return Utils::class.java.getResourceAsStream(sanitizedFileName).bufferedReader().readLines()
    }

}

