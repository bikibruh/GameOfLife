package cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.fail;

public class GameOfLifeSpec {

    @Given("^the following setup$")
    public void the_following_setup(final DataTable dataTable) {
        final String[] lines = getGridRepresentation(dataTable);
    }

    private static String[] getGridRepresentation(final DataTable dataTable) {
        return IntStream
                .range(0, dataTable.height())
                .mapToObj(dataTable::row)
                .map(line -> line
                        .stream()
                        // TODO : the replacement strings are the representation of a dead/alive cell. Feel free to replace them.
                        .map(theLine -> theLine.replaceAll("\\.", "-"))
                        .map(theLine -> theLine.replaceAll("x", "X"))
                        .collect(Collectors.joining())
                )
                .toArray(String[]::new);
    }

    @When("^I evolve the board$")
    public void i_evolve_the_board() {
        fail("Implement");
    }

    @Then("^the center cell should be (.*)$")
    public void the_center_cell_should_be(final String expectedStateAsString) {
        fail("Implement");
    }

    @Then("^I should see the following board$")
    public void i_should_see_the_following_board(final DataTable dataTable) {
        final String[] expected = getGridRepresentation(dataTable);

        fail("Implement");
    }
}
