package org.advent.of.code


class Day08 {

    fun computeResultPartOne(fileName: String): Int {
        val operationsList = OperationListParser(Utils.loadFile(fileName)).operations
        return runOperations(operationsList)
    }

    fun computeResultPartTwo(fileName: String): Int {
        val operationsList = OperationListParser(Utils.loadFile(fileName)).operations
        var nextTry = true
        var currentOperationsList = operationsList
        var currentIndex = 0
        while (nextTry) {
//            println("essai $currentIndex")
            currentOperationsList = replaceNextOperation(operationsList, currentIndex++)
            nextTry = !doesCompleteWithOperations(currentOperationsList)
        }

        return runOperations(currentOperationsList)
    }

    private fun runOperations(operationsList: List<Operation>): Int {
        val alreadyVisitedStep = mutableSetOf<Int>()
        var currentStatus = Pair(0, 0)

        while (currentStatus.first < operationsList.size && !alreadyVisitedStep.contains(currentStatus.first)) {
            alreadyVisitedStep.add(currentStatus.first)
            val currentOperation = operationsList[currentStatus.first]
            currentStatus = currentOperation.apply(currentStatus.first, currentStatus.second)
        }
        return currentStatus.second
    }

    private fun doesCompleteWithOperations(operationsList: List<Operation>): Boolean {
        val alreadyVisitedStep = mutableSetOf<Int>()
        var currentStatus = Pair(0, 0)

        while (currentStatus.first < operationsList.size && !alreadyVisitedStep.contains(currentStatus.first)) {
            alreadyVisitedStep.add(currentStatus.first)
            val currentOperation = operationsList[currentStatus.first]
            currentStatus = currentOperation.apply(currentStatus.first, currentStatus.second)
        }

        return currentStatus.first == operationsList.size
    }

    private fun replaceNextOperation(operationsList: List<Operation>, afterIndex: Int): List<Operation> {
        var currentIndex = 0
        var alreadyReplaced = false
        var newOperationsList = mutableListOf<Operation>()
        for (operation in operationsList) {
            if (!alreadyReplaced && currentIndex >= afterIndex) {
                if (operation.operator == Operator.NOP) {
                    newOperationsList.add(Operation(Operator.JMP, operation.value))
                    alreadyReplaced = true
                } else if (operation.operator == Operator.JMP) {
                    newOperationsList.add(Operation(Operator.NOP, operation.value))
                    alreadyReplaced = true
                } else {
                    newOperationsList.add(operation)
                }
            } else {
                newOperationsList.add(operation)
            }
            currentIndex++
        }

        return newOperationsList
    }
}