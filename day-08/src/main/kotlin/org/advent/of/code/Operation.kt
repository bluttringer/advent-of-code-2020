package org.advent.of.code


enum class Operator(val code: String) {
    NOP("nop"), ACC("acc"), JMP("jmp");

    companion object {
        fun findFromCode(code: String): Operator = Operator.values().find { it.code == code }!!
    }
}

class Operation(val operator: Operator, val value: Int) {

    fun apply(step: Int, accumulator: Int): Pair<Int, Int> {
        return when (operator) {
            Operator.ACC -> Pair(step + 1, accumulator + value)
            Operator.JMP -> Pair(step + value, accumulator)
            Operator.NOP -> Pair(step + 1, accumulator)
        }
    }

    override fun toString(): String {
        return "Operation(op=$operator, value=$value)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Operation

        if (operator != other.operator) return false
        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        var result = operator.hashCode()
        result = 31 * result + value
        return result
    }


}