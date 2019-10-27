package com.carbonit.gameoflife

class CellEvolver {

    companion object {
        fun evolve(neighbours: Int, state: State): State {
            return when (neighbours) {
                2 -> state
                3 -> State.ALIVE
                else -> State.DEAD
            }
        }
    }
}
