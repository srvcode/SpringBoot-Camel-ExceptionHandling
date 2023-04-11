package com.srvcode.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.srvcode.camel.exceptions.CamelCustomException;

public class ConditionalProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

		String a = exchange.getIn().getBody(String.class);
		System.out.println("hello, " + a);
		if(a.contains("test")) {
			throw new CamelCustomException("Test present.");
		}
	}

}
