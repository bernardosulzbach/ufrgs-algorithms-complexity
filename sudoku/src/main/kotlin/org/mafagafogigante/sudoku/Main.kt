package org.mafagafogigante.sudoku

import kotlin.system.measureNanoTime

fun main(args: Array<String>) {
    val board = Sudoku()
    println(board.toString())
    println(board.isSolved())
    val solvedBoard = Sudoku(arrayOf(
            intArrayOf(1, 7, 2, 9, 8, 3, 5, 6, 4),
            intArrayOf(4, 6, 8, 5, 7, 2, 9, 1, 3),
            intArrayOf(5, 3, 9, 6, 1, 4, 8, 7, 2),
            intArrayOf(2, 1, 3, 8, 5, 6, 4, 9, 7),
            intArrayOf(8, 4, 6, 3, 9, 7, 2, 5, 1),
            intArrayOf(9, 5, 7, 2, 4, 1, 3, 8, 6),
            intArrayOf(6, 8, 4, 7, 2, 5, 1, 3, 9),
            intArrayOf(3, 9, 1, 4, 6, 8, 7, 2, 5),
            intArrayOf(7, 2, 5, 1, 3, 9, 6, 4, 8)
    ))
    println(solvedBoard.toString())
    println(solvedBoard.isSolved())
    val almostSolvedBoard = Sudoku(arrayOf(
            intArrayOf(1, 7, 2, 9, 8, 3, 5, 6, 4),
            intArrayOf(4, 6, 8, 5, 7, 2, 9, 1, 3),
            intArrayOf(5, 3, 9, 6, 1, 4, 8, 0, 2),
            intArrayOf(2, 1, 3, 8, 5, 6, 4, 9, 7),
            intArrayOf(8, 4, 6, 3, 9, 7, 0, 5, 1),
            intArrayOf(9, 5, 7, 2, 4, 1, 3, 8, 6),
            intArrayOf(6, 8, 4, 7, 2, 5, 1, 3, 9),
            intArrayOf(3, 9, 1, 4, 6, 8, 0, 2, 5),
            intArrayOf(7, 2, 5, 1, 3, 9, 6, 4, 8)
    ))
    println(almostSolvedBoard.toString())
    almostSolvedBoard.solve()
    println(almostSolvedBoard.toString())

    val easyProblem = Sudoku(arrayOf(
            intArrayOf(0, 8, 9, 0, 0, 1, 5, 0, 0),
            intArrayOf(0, 0, 3, 6, 0, 0, 0, 0, 8),
            intArrayOf(0, 6, 0, 0, 5, 4, 0, 0, 0),
            intArrayOf(0, 4, 5, 1, 0, 7, 0, 0, 0),
            intArrayOf(0, 2, 1, 9, 0, 3, 7, 5, 0),
            intArrayOf(0, 0, 0, 4, 0, 5, 1, 2, 0),
            intArrayOf(0, 0, 0, 5, 4, 0, 0, 9, 0),
            intArrayOf(5, 0, 0, 0, 0, 9, 3, 0, 0),
            intArrayOf(0, 0, 4, 7, 0, 0, 2, 1, 0)))
    println(easyProblem.isSolved())
    println((measureNanoTime { easyProblem.solve() }).toString() + " nanoseconds")
    println(easyProblem.isSolved())
    println(easyProblem.toString())

    val mediumProblem = Sudoku(arrayOf(
            intArrayOf(0, 9, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(3, 0, 0, 0, 0, 0, 4, 6, 9),
            intArrayOf(0, 4, 0, 9, 7, 3, 0, 0, 0),
            intArrayOf(0, 6, 0, 0, 9, 8, 1, 0, 0),
            intArrayOf(5, 0, 0, 3, 1, 7, 0, 0, 6),
            intArrayOf(0, 0, 3, 6, 2, 0, 0, 9, 0),
            intArrayOf(0, 0, 0, 7, 6, 1, 0, 5, 0),
            intArrayOf(6, 8, 2, 0, 0, 0, 0, 0, 1),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 3, 0)))
    println(mediumProblem.isSolved())
    println((measureNanoTime { mediumProblem.solve() }).toString() + " nanoseconds")
    println(mediumProblem.isSolved())
    println(mediumProblem.toString())

    val hardProblem = Sudoku(arrayOf(
            intArrayOf(3, 0, 5, 0, 0, 4, 0, 0, 8),
            intArrayOf(6, 7, 0, 0, 0, 0, 1, 4, 0),
            intArrayOf(0, 0, 0, 0, 1, 0, 5, 0, 0),
            intArrayOf(0, 0, 3, 0, 4, 6, 0, 0, 5),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(9, 0, 0, 7, 5, 0, 8, 0, 0),
            intArrayOf(0, 0, 8, 0, 9, 0, 0, 0, 0),
            intArrayOf(0, 4, 9, 0, 0, 0, 0, 8, 7),
            intArrayOf(1, 0, 0, 3, 0, 0, 4, 0, 9)))
    println(hardProblem.isSolved())
    println((measureNanoTime { hardProblem.solve() }).toString() + " nanoseconds")
    println(hardProblem.isSolved())
    println(hardProblem.toString())
}