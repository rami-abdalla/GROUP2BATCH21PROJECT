package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/features/",


        glue = "steps",

        dryRun = false,

        plugin = {"pretty",
        "json:target/cucumber.json",  // ✅ Generates JSON report
        "html:target/cucumber-reports.html"},

        tags = ""


)

public class RunnerClass {

}
