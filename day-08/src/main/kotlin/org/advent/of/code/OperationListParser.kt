package org.advent.of.code


class OperationListParser(operationsList: List<String>) {

    val operationRegex = Regex("^(\\w*) ([+-]?\\d*)$")
    val operations: List<Operation>

    init {
        operations = parseOperations(operationsList)
    }

    private fun parseOperations(operationsList: List<String>): List<Operation> {

        return operationsList.map {
            val matchingGroups = operationRegex.find(it)!!.groupValues
            Operation(Operator.findFromCode(matchingGroups[1]), Integer.parseInt(matchingGroups[2]))
        }
    }

}