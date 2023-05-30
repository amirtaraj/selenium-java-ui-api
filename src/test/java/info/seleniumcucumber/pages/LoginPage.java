package info.seleniumcucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import info.seleniumcucumber.annotations.PageObject;

@PageObject
public class LoginPage extends AbstractPage {

    @FindBy(how = How.ID, using = "flash")
    private WebElement MESSAGE;

    public WebElement getMessage() throws NoSuchFieldException {
        getDriverWait().waitForElementToLoad(MESSAGE);
        return MESSAGE;
    }
}

