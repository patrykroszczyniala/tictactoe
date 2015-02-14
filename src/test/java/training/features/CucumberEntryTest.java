package training.features;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Unit test for simple App.
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty", "html:target/cucumber.html"}, monochrome=true, glue={"training.features"}, features={"src/test/resources/features"})
public class CucumberEntryTest {

}