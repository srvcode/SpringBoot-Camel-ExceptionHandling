package com.srvcode.camel.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.srvcode.camel.exceptions.CamelCustomException;
import com.srvcode.camel.processor.ExceptionThrowingProcessor;

//@Component
public class SimpleRouteBuilderOnException extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		onException(CamelCustomException.class).process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				System.out.println("OnException handling");
			}
		}).log("Received Body ").handled(true);
		
		from("file:src/main/resources/inputFolder?noop=true")
		.process(new ExceptionThrowingProcessor())
		.to("file:src/main/resources/outputFolder");
	}

}
