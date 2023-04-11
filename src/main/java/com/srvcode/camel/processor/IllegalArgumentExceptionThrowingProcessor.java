package com.srvcode.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.srvcode.camel.route.ExceptionThrowingRoute;

public class IllegalArgumentExceptionThrowingProcessor implements Processor {

	private static final Logger LOGGER = LoggerFactory.getLogger(IllegalArgumentExceptionThrowingProcessor.class);
	
	@Override
	public void process(Exchange exchange) throws Exception {
		LOGGER.error("Exception Thrown");
		throw new IllegalArgumentException("An exception happened on purpose");
	}

}
