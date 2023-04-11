package com.srvcode.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.srvcode.camel.exceptions.CamelCustomException;

public class ExceptionThrowingProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

		System.out.println("Exception thrown");
		throw new CamelCustomException("Exception....");
	}

}
