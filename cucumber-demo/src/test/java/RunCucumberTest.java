import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Louz on 2015/10/8.
 */
@RunWith(Cucumber.class)
@CucumberOptions( plugin = {"pretty"}, snippets = SnippetType.CAMELCASE, monochrome = true)
public class RunCucumberTest {

}
