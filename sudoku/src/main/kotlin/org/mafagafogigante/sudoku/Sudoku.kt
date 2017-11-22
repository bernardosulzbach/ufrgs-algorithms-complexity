package org.mafagafogigante.sudoku

import java.lang.Exception

val SIZE = 9

class Sudoku(private var grid: Array<IntArray>) {

    constructor() : this(Array(SIZE, { IntArray(SIZE) }))

    fun isSolved(): Boolean {
        return isSolvedHorizontally() && isSolvedVertically() && isSolvedRegionally()
    }

    private fun isSolvedHorizontally(): Boolean {
        for (i in 0..SIZE - 1) {
            val seen = BooleanArray(SIZE)
            for (j in 0..SIZE - 1) {
                if (grid[i][j] < 1 || grid[i][j] > 9) {
                    return false
                }
                val index = grid[i][j] - 1
                if (seen[index]) {
                    return false
                }
                seen[index] = true
            }
            if (!seen.all({ x -> x })) {
                return false
            }
        }
        return true
    }

    private fun isSolvedVertically(): Boolean {
        for (j in 0..SIZE - 1) {
            val seen = BooleanArray(SIZE)
            for (i in 0..SIZE - 1) {
                if (grid[i][j] < 1 || grid[i][j] > 9) {
                    return false
                }
                val index = grid[i][j] - 1
                if (seen[index]) {
                    return false
                }
                seen[index] = true
            }
            if (!seen.all({ x -> x })) {
                return false
            }
        }
        return true
    }

    private fun isSolvedRegionally(): Boolean {
        for (i in 0..2) {
            for (j in 0..2) {
                val iStart = 3 * i
                val jStart = 3 * j
                val available = BooleanArray(SIZE, { true })
                for (ni in iStart..iStart + 2) {
                    for (nj in jStart..jStart + 2) {
                        if (grid[ni][nj] in 1..9) {
                            val index = grid[ni][nj] - 1
                            if (!available[index]) {
                                return false
                            }
                            available[index] = false
                        }
                    }
                }
            }
        }
        return true
    }

    private fun fill(i: Int, j: Int): Boolean {
        val available = availableValues(i, j)
        for (k in 0..available.size - 1) {
            if (!available[k]) {
                continue
            }
            val value = k + 1
            grid[i][j] = value
            var foundZero = false
            for (pos in i * SIZE + j + 1..SIZE * SIZE - 1) {
                val ni = pos / SIZE
                val nj = pos % SIZE
                if (grid[ni][nj] == 0) {
                    foundZero = true
                    if (fill(ni, nj)) {
                        return true
                    }
                    break
                }
            }
            if (!foundZero) {
                return true
            }
        }
        grid[i][j] = 0
        return false
    }

    private fun availableValues(i: Int, j: Int): BooleanArray {
        val available = BooleanArray(9, { true })
        for (altJ in 0..SIZE - 1) {
            if (grid[i][altJ] in 1..9) {
                available[grid[i][altJ] - 1] = false
            }
        }
        for (altI in 0..SIZE - 1) {
            if (grid[altI][j] in 1..9) {
                available[grid[altI][j] - 1] = false
            }
        }
        val iStart = i - i % 3
        val jStart = j - j % 3
        for (ni in iStart..iStart + 2) {
            for (nj in jStart..jStart + 2) {
                if (grid[ni][nj] in 1..9) {
                    available[grid[ni][nj] - 1] = false
                }
            }
        }
        return available
    }

    fun solve() {
        for (i in 0..SIZE - 1) {
            for (j in 0..SIZE - 1) {
                if (grid[i][j] == 0) {
                    if (fill(i, j)) {
                        return
                    }
                    throw Exception()
                }
            }
        }
    }

    override fun toString(): String {
        val builder = StringBuilder()
        for (i in 0..grid.size - 1) {
            if (i > 0) {
                builder.append('\n')
            }
            if (i > 0 && i % 3 == 0) {
                builder.append('\n')
            }
            for (j in 0..grid[i].size - 1) {
                if (j > 0 && j % 3 == 0) {
                    builder.append(' ')
                }
                if (grid[i][j] != 0) {
                    builder.append(grid[i][j])
                } else {
                    builder.append(' ')
                }
            }
        }
        return builder.toString()
    }

    fun getGridCopy(): Array<IntArray> {
        return Array(grid.size) { index -> grid[index].copyOf() }
    }

}