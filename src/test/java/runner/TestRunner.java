package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "feature", glue = { "stepDefination" })//plugin = {"html:target/cucumber-html-report.html", "json:target/cucumber.json"}
public class TestRunner {

}
