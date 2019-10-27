package cucumber;

import com.carbonit.gameoflife.CellEvolver;
import com.carbonit.gameoflife.GameOfLife;
import com.carbonit.gameoflife.Position;
import com.carbonit.gameoflife.State;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class GameOfLifeSpec {

    private GameOfLife gameOfLife;

    @Given("^the following setup$")
    public void the_following_setup(final DataTable dataTable) {
        final String[] lines = getGridRepresentation(dataTable);

        gameOfLife = GameOfLife.fromLines(lines);
    }

    private static String[] getGridRepresentation(final DataTable dataTable) {
        return IntStream
                .range(0, dataTable.height())
                .mapToObj(dataTable::row)
                .map(line -> line
                        .stream()
                        .map(theLine -> theLine.replaceAll("\\.", GameOfLife.DEAD_REPRESENTATION))
                        .map(theLine -> theLine.replaceAll("x", GameOfLife.ALIVE_REPRESENTATION))
                        .collect(Collectors.joining())
                )
                .toArray(String[]::new);
    }

    @When("^I evolve the board$")
    public void i_evolve_the_board() {
        gameOfLife = gameOfLife.evolve(CellEvolver.Companion::evolve);
    }

    @Then("^the center cell should be (.*)$")
    public void the_center_cell_should_be(final String expectedStateAsString) {
        State cellState = State.valueOf(expectedStateAsString.toUpperCase());

        switch(cellState) {
            case ALIVE:
                assertTrue(gameOfLife.getAlivePositions().contains(Position.of(1, 1)));
                break;
            case DEAD:
                assertFalse(gameOfLife.getAlivePositions().contains(Position.of(1, 1)));
                break;
        }
    }

    @Then("^I should see the following board$")
    public void i_should_see_the_following_board(final DataTable dataTable) {
        final String[] expected = getGridRepresentation(dataTable);

        assertArrayEquals(expected, gameOfLife.getRepresentation());
    }
}
