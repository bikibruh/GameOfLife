package com.carbonit.gameoflife

data class Position constructor(val x: Int, val y: Int) {
    fun neighbours(): Set<Position> {
        return setOf(
            Position(x - 1, y - 1), Position(x - 1, y), Position(x - 1, y + 1),
            Position(x, y - 1), Position(x, y + 1),
            Position(x + 1, y - 1), Position(x + 1, y), Position(x + 1, y + 1)
        )
    }

    companion object {
        @JvmStatic
        fun of(
            x: Int,
            y: Int
        ) = Position(x, y)
    }
}
