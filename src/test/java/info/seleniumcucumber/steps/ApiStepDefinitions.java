package info.seleniumcucumber.steps;

import info.seleniumcucumber.pages.AbstractPage;
import info.seleniumcucumber.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import info.seleniumcucumber.utils.RestUtils;
import info.seleniumcucumber.utils.ConfigUtils;
import io.restassured.response.Response;
import static org.junit.Assert.assertEquals;
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
}
