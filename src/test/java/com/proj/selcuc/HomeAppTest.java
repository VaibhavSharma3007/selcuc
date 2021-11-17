package com.proj.selcuc;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/java/Home",glue={"GlueCodeHome"})

public class HomeAppTest {

}
