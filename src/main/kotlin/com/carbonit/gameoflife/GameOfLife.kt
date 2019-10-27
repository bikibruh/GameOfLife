package com.carbonit.gameoflife

import com.carbonit.gameoflife.exceptions.InvalidRepresentationException
import com.carbonit.gameoflife.exceptions.LineLengthConflictException


class GameOfLife(val alivePositions: Set<Position>, val representation: Array<String>) {
    companion object {
        const val DEAD_REPRESENTATION = "-"
        const val ALIVE_REPRESENTATION = "X"

        @JvmStatic
        fun fromLines(lines: Array<String>): GameOfLife {
            if (lines.map { line -> line.length }.toSet().size > 1) {
                throw LineLengthConflictException()
            }
            if (lines.any { line -> !line.contains(DEAD_REPRESENTATION) && !line.contains(ALIVE_REPRESENTATION) }) {
                throw InvalidRepresentationException()
            }

            val alivePositions =
                lines.withIndex().flatMap { (y, line) ->
                    line.toList().withIndex().map { (x, c) ->
                        Pair(Position(x, y), c.toString() == ALIVE_REPRESENTATION)
                    }
                }
                    .filter { (_, alive) -> alive }
                    .map { (position, _) -> position }
                    .toSet()

            return GameOfLife(alivePositions, lines)
        }
    }

    fun evolve(cellEvolver: (Int, State) -> State): GameOfLife {
        return this
    }
}
