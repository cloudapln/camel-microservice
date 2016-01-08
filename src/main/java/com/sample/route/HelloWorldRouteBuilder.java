package com.sample.route;

import com.sample.service.HelloWorldService;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;

public class HelloWorldRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:getMessage").setExchangePattern(ExchangePattern.InOut).bean(new HelloWorldService(), "getMessage");
        // add HTTP interface
        from("jetty:http://0.0.0.0:/message").setExchangePattern(ExchangePattern.InOut).to("direct:getMessage");
    }
}
