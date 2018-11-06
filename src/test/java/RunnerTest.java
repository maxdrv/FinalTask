import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = {"StepDefs"},
        tags = {"@all"},
        plugin = {"ru.yandex.qatools.allure.cucumberjvm.AllureReporter"}
)

public class RunnerTest {

}