package features.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.val;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SpringStepsTest extends SpringIntegrationTest {
    MockHttpServletResponse latestResponse;

    @When("the client calls \\/doubledatediff with {string} and {string}")
    public void theClientCallsDoubledatediffWithAnd(String date1, String date2) throws Throwable {
        latestResponse = executeGet("http://localhost:8080/doubledatediff/" + date1 + "/" + date2);
    }

    @Then("the client receives status code of {int}")
    public void theClientReceivesStatusCodeOf(int expectedStatusCode) {
        val actualStatusCode = latestResponse.getStatus();
        assertThat("status code is incorrect : " +
                actualStatusCode, actualStatusCode, is(expectedStatusCode));
    }

    @And("the client receives the double date difference as {string}")
    public void theClientReceivesTheDoubleDateDifferenceAs(String expectedDate) throws Throwable {
        val actualDate = latestResponse.getContentAsString();
        assertThat("date is incorrect : expected '%s' but got '%s'".formatted(expectedDate, actualDate),
                actualDate, is(expectedDate));
    }
}
