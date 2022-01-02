package com.jet.framework.stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.jet.framework.base.Base;
import com.jet.framework.connections.ConfigReader;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;




public class MyHooks extends Base{	

	
	@Before
	public void init(Scenario scenario) throws FileNotFoundException, IOException {
		logger.info("********************************Test - "+scenario.getName()+"*************************************");
		ConfigReader.loadConfig();

	}
	
	@After
	public void after() {

	}

}
