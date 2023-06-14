package info.seleniumcucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.hamcrest.Matchers;
import info.seleniumcucumber.pages.AbstractPage;
import info.seleniumcucumber.pages.LoginPage;
import info.seleniumcucumber.utils.ConfigUtils;
import info.seleniumcucumber.utils.RestUtils;
import io.restassured.response.Response;
import static org.junit.Assert.assertEquals;
import java.io.IOException;
public class ApiStepDefinitions extends AbstractPage {

    private Response response;
    @Given("^I should get logged-in$")
    public void should_logged_in() throws NoSuchFieldException {
        final LoginPage loginPage = new LoginPage();
        Assert.assertEquals("You logged into a secure are!", loginPage.getMessage().getText().split("\n")[0].trim());
    }

    @When("I perform a GET request")
    public void getRequest(){
        response = RestUtils.performGetRequest();
    }

    @Given("I have set the {string}")
    public void setBaseUrl(String base_url) {
        String baseUrl = ConfigUtils.getProperties(base_url);
        RestUtils.setBaseUrl(baseUrl);
    }

    @Given("I have set the path {string}")
    public void setBasePath(String base_path) {
        String basePath = ConfigUtils.getProperties(base_path + "_path");
        RestUtils.setBasePath(basePath);
    }

    @Given("I have set the path {string} with param {string}")
    public void setBasePathWithParam(String base_path, String param) {
        String path = ConfigUtils.getProperties(base_path + "_path");
        String basePath = path + "/" + param;
        RestUtils.setBasePath(basePath);
    }

    @Given("I have set the content type to {string}")
    public void setContentType(String content_type) {
        String contentType;
        if (content_type.equals("application")) {
            contentType = ConfigUtils.getProperties("content_type");
        } else {
            contentType = ConfigUtils.getProperties(content_type);
        }
        RestUtils.setContentType(contentType);
    }

    @Then("I should receive a response with status code {int}")
    public void checkStatusCode(int expectedStatusCode) {
        assertEquals(expectedStatusCode, RestUtils.response.getStatusCode());
    }

    @When("I perform a POST request to with payload {string}")
    public void performPostRequest(String payload) throws IOException {
        RestUtils.performPostRequest(payload);
    }

    @When("I perform a PUT request to with payload {string}")
    public void putRequest(String payload) throws IOException {
        response = RestUtils.performPutRequest(payload);
    }

    @When("I perform a DELETE request")
    public void deleteRequest(){
        response = RestUtils.performDeleteRequest();
    }

   
    @Then("^I should get \"([^\"]*)\" as \"([^\"]*)\"$")
    public void validateFieldValue(String field, String expectedValue) {
    String jsonPath = field.replaceAll("\"", "");
    if (expectedValue.matches("-?\\d+")) {
        response.then().assertThat().body(jsonPath, Matchers.equalTo(Integer.parseInt(expectedValue)));
    } else {
        response.then().assertThat().body(jsonPath, Matchers.equalTo(expectedValue));
    }
    }

   
}
