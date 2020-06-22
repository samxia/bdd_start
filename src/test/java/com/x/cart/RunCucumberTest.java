package com.x.cart;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
//@CucumberOptions(plugin = {"pretty","html:target/cucumber"})
//@CucumberOptions(plugin = {"pretty", "summary"}, strict = true, snippets = CAMELCASE)
//@CucumberOptions(dryRun=true)
@CucumberOptions(monochrome=true , tags =  "@add_to_cart" )
//@CucumberOptions(strict=false)
//@CucumberOptions(tags = {"@foo", "not @bar"})
public class RunCucumberTest {
}
