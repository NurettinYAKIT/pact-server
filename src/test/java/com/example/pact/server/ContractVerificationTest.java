package com.example.pact.server;

import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.loader.PactBroker;
import com.example.pact.server.ServerApplication;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.SpringApplication;
import org.springframework.web.context.ConfigurableWebApplicationContext;

@Provider("server")
@PactBroker(url = "http://localhost:9292")
@ExtendWith(PactVerificationInvocationContextProvider.class)
public class ContractVerificationTest {

    private static ConfigurableWebApplicationContext application;

    @BeforeAll
    public static void start() {
        System.setProperty("pact.verifier.publishResults", "true");
        application = (ConfigurableWebApplicationContext) SpringApplication.run(ServerApplication.class);
    }

    @BeforeEach
    void before(PactVerificationContext context) {
        context.setTarget(new HttpTestTarget("localhost", 8082, "/"));
    }

    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    void pactVerificationTestTemplate(PactVerificationContext context) {
        context.verifyInteraction();
    }

    @State("test GET")
    public void toGetState() {
    }

    @State("test POST")
    public void toPostState() {
    }
}

