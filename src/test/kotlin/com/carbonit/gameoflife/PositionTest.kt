package com.carbonit.gameoflife

import nl.jqno.equalsverifier.EqualsVerifier
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PositionTest {

    @Test
    fun shouldBeInitializedProperly() {
        val position = Position(1, 2)

        assertEquals(1, position.x)
        assertEquals(2, position.y)
    }

    @Test
    fun shouldSupportEqualsAndHashCode() {
        EqualsVerifier.forClass(Position::class.java).verify()
    }

    @Test
    internal fun shouldReturnNeighboursPosition() {
        val position = Position(1, 1)

        assertEquals(8, position.neighbours().size)
        for (dx in -1..1) {
            for (dy in -1..1) {
                if (dx == 0 && dy == 0) {
                    continue
                }

                assertTrue(position.neighbours().contains(Position.of(position.x + dx, position.y + dy)))
            }
        }
    }
}