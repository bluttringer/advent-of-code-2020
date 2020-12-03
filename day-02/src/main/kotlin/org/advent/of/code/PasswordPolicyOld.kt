package org.advent.of.code


class PasswordPolicyOld(private val nbMin: Int, private val nbMax: Int, private val letter: Char) {
    fun isPasswordCompliant(password: String): Boolean {
        var count = 0
        for (c in password) {
            if (c == letter) {
                count++
            }
        }
        return count >= nbMin && count <= nbMax
    }
}