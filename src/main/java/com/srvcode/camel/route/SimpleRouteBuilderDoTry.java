package com.srvcode.camel.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.srvcode.camel.exceptions.CamelCustomException;
import com.srvcode.camel.processor.ExceptionThrowingProcessor;

//@Component
public class SimpleRouteBuilderDoTry extends RouteBuilder {

	@Override
	public void configure() throws Exception {

//		from("file:D:/EclipseWS2023/SpringBoot-Camel/src/main/resources/inputFolder?noop=true")
//		//.process(new MyProcessor())
//		.to("file:D:/EclipseWS2023/SpringBoot-Camel/src/main/resources/outputFolder");
//		
//		from("file:src/main/resources/inputFolder?noop=true")
//		.process(new MyProcessor())
//		.to("file:src/main/resources/outputFolder");
		
		from("file:src/main/resources/inputFolder?noop=true").doTry()
		.process(new ExceptionThrowingProcessor())
		.to("file:src/main/resources/outputFolder").doCatch(CamelCustomException.class)
		.process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				System.out.println("Handling ex");
			}
		}).log("Received Body");

	}

}
