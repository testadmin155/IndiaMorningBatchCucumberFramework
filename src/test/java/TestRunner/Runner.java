package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
(
  features=".//Feature/Login.Feature",
  glue="StepDefnition",
  dryRun= false,
  plugin = {"pretty","html:test-output"},
  tags= {"@Sanity"}
)


public class Runner {

}
