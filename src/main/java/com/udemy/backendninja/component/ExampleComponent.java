package com.udemy.backendninja.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

//dependency declared 
@Component("exampleComponent")
public class ExampleComponent implements IExampleComponent{

	private final Log LOGGER = LogFactory.getLog(ExampleComponent.class);
	
	public void sayHello() {
		LOGGER.info("Hello from ExampleComponenet xd");
	}
}
