package org.mafagafogigante.sudoku

import org.junit.Assert

class SudokuTest {

    @org.junit.Test
    fun testIsSolvedReturnsTrueForSolvedGames() {
        val solvedBoard = Sudoku(arrayOf(
                intArrayOf(1, 7, 2, 9, 8, 3, 5, 6, 4),
                intArrayOf(4, 6, 8, 5, 7, 2, 9, 1, 3),
                intArrayOf(5, 3, 9, 6, 1, 4, 8, 7, 2),
                intArrayOf(2, 1, 3, 8, 5, 6, 4, 9, 7),
                intArrayOf(8, 4, 6, 3, 9, 7, 2, 5, 1),
                intArrayOf(9, 5, 7, 2, 4, 1, 3, 8, 6),
                intArrayOf(6, 8, 4, 7, 2, 5, 1, 3, 9),
                intArrayOf(3, 9, 1, 4, 6, 8, 7, 2, 5),
                intArrayOf(7, 2, 5, 1, 3, 9, 6, 4, 8)))
        Assert.assertTrue(solvedBoard.isSolved())
    }

    @org.junit.Test
    fun testIsSolvedReturnsFalseForUnsolvedGames() {
        val solvedBoard = Sudoku(arrayOf(
                intArrayOf(1, 7, 2, 9, 8, 3, 5, 6, 4),
                intArrayOf(4, 6, 8, 5, 7, 2, 9, 1, 3),
                intArrayOf(5, 3, 9, 6, 1, 4, 8, 7, 2),
                intArrayOf(2, 1, 3, 8, 5, 6, 4, 9, 7),
                intArrayOf(8, 4, 6, 3, 9, 7, 2, 5, 1),
                intArrayOf(9, 5, 7, 2, 4, 1, 3, 8, 6),
                intArrayOf(6, 8, 4, 7, 2, 5, 1, 3, 9),
                intArrayOf(3, 9, 1, 4, 6, 8, 7, 2, 5),
                intArrayOf(7, 2, 5, 1, 3, 9, 6, 4, 8)))
        val grid = solvedBoard.getGridCopy()
        for (i in 0..8) {
            for (j in 0..8) {
                val original = grid[i][j]
                grid[i][j] = 9 - original
                Assert.assertFalse(Sudoku(grid).isSolved())
                grid[i][j] = original
            }
        }
    }

    @org.junit.Test
    fun testIsSolvedShouldDetectRegionallyUnsolved() {
        val regionallyUnsolvedBoard = Sudoku(arrayOf(
                intArrayOf(1, 9, 4, 2, 3, 5, 6, 8, 7),
                intArrayOf(3, 5, 7, 1, 8, 2, 4, 6, 9),
                intArrayOf(2, 4, 6, 9, 7, 3, 5, 1, 8),
                intArrayOf(7, 6, 5, 4, 9, 8, 1, 2, 3),
                intArrayOf(5, 2, 8, 3, 1, 7, 9, 4, 6),
                intArrayOf(8, 1, 3, 6, 2, 4, 7, 9, 5),
                intArrayOf(4, 3, 9, 7, 6, 1, 8, 5, 2),
                intArrayOf(6, 8, 2, 5, 4, 9, 3, 7, 1),
                intArrayOf(9, 7, 1, 8, 5, 6, 2, 3, 4)))
        Assert.assertFalse(regionallyUnsolvedBoard.isSolved())
    }

    @org.junit.Test
    fun testSolveShouldSolveEasyGames() {
        val problem = Sudoku(arrayOf(
                intArrayOf(0, 8, 9, 0, 0, 1, 5, 0, 0),
                intArrayOf(0, 0, 3, 6, 0, 0, 0, 0, 8),
                intArrayOf(0, 6, 0, 0, 5, 4, 0, 0, 0),
                intArrayOf(0, 4, 5, 1, 0, 7, 0, 0, 0),
                intArrayOf(0, 2, 1, 9, 0, 3, 7, 5, 0),
                intArrayOf(0, 0, 0, 4, 0, 5, 1, 2, 0),
                intArrayOf(0, 0, 0, 5, 4, 0, 0, 9, 0),
                intArrayOf(5, 0, 0, 0, 0, 9, 3, 0, 0),
                intArrayOf(0, 0, 4, 7, 0, 0, 2, 1, 0)))
        Assert.assertFalse(problem.isSolved())
        problem.solve()
        Assert.assertTrue(problem.isSolved())
    }

    @org.junit.Test
    fun testSolveShouldSolveMediumGames() {
        val problem = Sudoku(arrayOf(
                intArrayOf(0, 9, 0, 0, 0, 0, 0, 0, 0),
                intArrayOf(3, 0, 0, 0, 0, 0, 4, 6, 9),
                intArrayOf(0, 4, 0, 9, 7, 3, 0, 0, 0),
                intArrayOf(0, 6, 0, 0, 9, 8, 1, 0, 0),
                intArrayOf(5, 0, 0, 3, 1, 7, 0, 0, 6),
                intArrayOf(0, 0, 3, 6, 2, 0, 0, 9, 0),
                intArrayOf(0, 0, 0, 7, 6, 1, 0, 5, 0),
                intArrayOf(6, 8, 2, 0, 0, 0, 0, 0, 1),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 3, 0)))
        Assert.assertFalse(problem.isSolved())
        problem.solve()
        Assert.assertTrue(problem.isSolved())
    }

    @org.junit.Test
    fun testSolveShouldSolveHardGames() {
        val problem = Sudoku(arrayOf(
                intArrayOf(3, 0, 5, 0, 0, 4, 0, 0, 8),
                intArrayOf(6, 7, 0, 0, 0, 0, 1, 4, 0),
                intArrayOf(0, 0, 0, 0, 1, 0, 5, 0, 0),
                intArrayOf(0, 0, 3, 0, 4, 6, 0, 0, 5),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
                intArrayOf(9, 0, 0, 7, 5, 0, 8, 0, 0),
                intArrayOf(0, 0, 8, 0, 9, 0, 0, 0, 0),
                intArrayOf(0, 4, 9, 0, 0, 0, 0, 8, 7),
                intArrayOf(1, 0, 0, 3, 0, 0, 4, 0, 9)))
        Assert.assertFalse(problem.isSolved())
        problem.solve()
        Assert.assertTrue(problem.isSolved())
    }

}
