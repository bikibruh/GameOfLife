package com.carbonit.gameoflife

import com.carbonit.gameoflife.exceptions.InvalidRepresentationException
import com.carbonit.gameoflife.exceptions.LineLengthConflictException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GameOfLifeTest {

    @Test
    internal fun shouldCreateFromRepresentation() {
        val gameOfLife = GameOfLife.fromLines(
            arrayOf(
                "---",
                "XX-"
            )
        )

        assertEquals(gameOfLife.alivePositions, setOf(Position(0, 1), Position(1,1)))
   }

    @Test
    internal fun shouldRejectRepresentationsWithInvalidTokens() {
        assertThrows(InvalidRepresentationException::class.java) {
            GameOfLife.fromLines(
                arrayOf(
                    "YY",
                    "XX"
                )
            )
        }
    }

    @Test
    internal fun shouldRejectRepresentationsWithLinesOfDifferentSizes() {
        assertThrows(LineLengthConflictException::class.java) {
            GameOfLife.fromLines(
                arrayOf(
                    "-",
                    "XX"
                )
            )
        }
    }
}