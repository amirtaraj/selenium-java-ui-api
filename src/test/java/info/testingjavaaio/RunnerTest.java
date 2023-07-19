package info.testingjavaaio;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
                "json:target/reports/cucumber-json-reports/json-report.json",
                "html:target/reports/cucumber-html-reports/html-report.html"
        },
        glue = {"info.testingjavaaio.steps"
        },
        features = {"classpath:features"},
        tags = {"@UI"}
)
public class RunnerTest {
}
