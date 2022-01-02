package com.jet.framework.TestRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(  
	    features = "src/test/java/com/jet/framework/test/Features",
	    glue="com/jet/framework/stepDefinitions",
	    tags="@AddPost",
	    monochrome=true,
	    stepNotifications = true,
	    plugin= {"pretty","html:target/cucumber","json:target/cucumber/cucumber.json","junit:target/cukes.xml"})

public class TestRunner {
	

}
