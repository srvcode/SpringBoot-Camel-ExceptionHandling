package com.srvcode.camel.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.srvcode.camel.exceptions.CamelCustomException;
import com.srvcode.camel.processor.ConditionalProcessor;
import com.srvcode.camel.processor.ExceptionThrowingProcessor;

@Component
public class SimpleRouteBuilderRedelivery extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		onException(CamelCustomException.class).process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				System.out.println("OnException Retry handling");
			}
		}).maximumRedeliveries(5).redeliveryDelay(5000).log("Received Body ").handled(true);
		
		from("file:src/main/resources/inputFolder?noop=true")
		.process(new ConditionalProcessor())
		.to("file:src/main/resources/outputFolder");
	}

}
