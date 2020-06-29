package org.gclub;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:target/cucumber"},tags="@smoke")
//@CucumberOptions(plugin = {"pretty", "summary"}, strict = true, snippets = CAMELCASE)
//@CucumberOptions(dryRun=true)
//@CucumberOptions(monochrome=true , tags =  "@add_some_products" )
//@CucumberOptions(monochrome=true , tags =  "@add_multiple_product" )
//@CucumberOptions(monochrome=true, tags = "@add_to_cart" )
//@CucumberOptions(strict=false)
//@CucumberOptions(tags = {"@foo", "not @bar"})
public class RunCucumberTest {
}
