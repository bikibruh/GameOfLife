package com.carbonit.gameoflife

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EnumSource

class CellEvolverTest {

    @ParameterizedTest
    @CsvSource("0, DEAD", "0, ALIVE", "1, DEAD", "1, ALIVE")
    internal fun cellShouldDieWithLessThan2NeighboursDueToUnderpopulation(neighbours: Int, state: State) {
        Assertions.assertEquals(State.DEAD, CellEvolver.evolve(neighbours, state))
    }

    @ParameterizedTest
    @CsvSource("4, DEAD", "4, ALIVE", "5, DEAD", "5, ALIVE", "6, DEAD", "6, ALIVE", "7, ALIVE", "7, DEAD", "8, ALIVE", "8, DEAD")
    internal fun cellShouldDieWithMoreThan3NeighboursDueToOverpopulation(neighbours: Int, state: State) {
        Assertions.assertEquals(State.DEAD, CellEvolver.evolve(neighbours, state))
    }

    @ParameterizedTest
    @EnumSource(State::class)
    internal fun cellShouldStayTheSameWith2Neighbours(state: State) {
        Assertions.assertEquals(state, CellEvolver.evolve(2, state))
    }

    @ParameterizedTest
    @EnumSource(State::class)
    internal fun cellShouldBeBornWith3NeighboursDueToReproduction(state: State) {
        Assertions.assertEquals(State.ALIVE, CellEvolver.evolve(3, state))
    }
}