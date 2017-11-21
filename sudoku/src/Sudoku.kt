val SIZE = 9

class Sudoku(var grid: Array<ShortArray>) {

    constructor() : this(Array(SIZE, { ShortArray(SIZE) }))

    fun isSolved(): Boolean {
        return true
    }

    fun toOrdinal(oneHot: Short): Short {
        var shifts: Short = 0
        var value = oneHot
        while (value != 0.toShort()) {
            value = value.div(2).toShort()
            shifts++
        }
        return shifts
    }

    fun toOneHot(ordinal: Short): Short {
        if (ordinal == 0.toShort()) {
            return 0
        }
        var oneHot: Short = 1
        for (i in 1..ordinal) {
            oneHot = oneHot.times(2).toShort()
        }
        return oneHot
    }

    override fun toString(): String {
        val builder = StringBuilder()
        for (i in 0..grid.size - 1) {
            if (i > 0 && i % 3 == 0) {
                builder.append('\n')
            }
            for (j in 0..grid[i].size - 1) {
                if (j > 0 && j % 3 == 0) {
                    builder.append(' ')
                }
                builder.append(toOrdinal(grid[i][j]))
            }
            builder.append('\n')
        }
        return builder.toString()
    }

}