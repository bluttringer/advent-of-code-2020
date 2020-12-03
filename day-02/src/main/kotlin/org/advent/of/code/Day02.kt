package org.advent.of.code


class Day02 {

    val regex = Regex("(\\d+)-(\\d+) (\\w): (\\w*)\$")

    fun computeResult(fileName: String): Int {
        var validPasswordsCount = 0
        val entries = Utils.loadFile(fileName)

        for (entry in entries) {
            val groups = regex.find(entry)!!.groupValues
            println("groups = $groups")

            val nbMin = Integer.parseInt(groups[1])
            val nbMax = Integer.parseInt(groups[2])
            val letter = groups[3][0]
            val password = groups[4]

            val passwordPolicy = PasswordPolicyNew(nbMin, nbMax, letter)
            if (passwordPolicy.isPasswordCompliant(password)) {
                validPasswordsCount++
            }
        }

        return validPasswordsCount
    }

}