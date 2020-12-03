package org.advent.of.code


class PasswordPolicyNew(private val firstPosition: Int, private val secondPosition: Int, private val letter: Char) {
    fun isPasswordCompliant(password: String): Boolean {
        val firstPositionChar = password[firstPosition - 1]
        val secondPositionChar = password[secondPosition - 1]

        return (firstPositionChar == letter).xor(secondPositionChar == letter)
    }
}