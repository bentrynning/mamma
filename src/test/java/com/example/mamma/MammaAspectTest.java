package com.example.mamma;

import com.example.mamma.annotations.Mamma;
import com.example.mamma.config.MammaConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig(classes = {MammaConfiguration.class, MammaAspectTest.TestConfig.class})
class MammaAspectTest {

    @Autowired
    private GreetingService greetingService;

    @Test
    void mammaAnnotationPrintsName() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        PrintStream capture = new PrintStream(output, true);
        System.setOut(capture);
        try {
            String greeting = greetingService.greet("Tester");

            assertThat(greeting).isEqualTo("Hello, Tester!");
        } finally {
            System.setOut(originalOut);
            capture.close();
        }

        assertThat(output.toString())
                .contains("greet's mama is Gloria!")
                .contains("Hello, Tester!");
    }

    static class GreetingService {

        @Mamma("Gloria")
        String greet(String name) {
            String message = "Hello, " + name + "!";
            System.out.println(message);
            return message;
        }
    }

    @Configuration
    static class TestConfig {
        @Bean
        GreetingService greetingService() {
            return new GreetingService();
        }
    }
}
