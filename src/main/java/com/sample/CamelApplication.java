package com.sample;

import com.sample.route.HelloWorldRouteBuilder;
import org.apache.camel.Main;

public class CamelApplication {

    Main main;

    public static void main(String args[]) throws Exception {
        CamelApplication application = new CamelApplication();
        final String port = (args.length == 1 ? args[0] : "9090");
        application.run(port);
    }

    private void run(String port) throws Exception {
        System.setProperty("port", port);
        main = new Main();
        main.enableHangupSupport();
        main.addRouteBuilder(new HelloWorldRouteBuilder());
        main.run();
        System.out.println(String.format("Starting Camel, using port %s. Use ctrl + c to terminate the JVM.", port));
    }
}
