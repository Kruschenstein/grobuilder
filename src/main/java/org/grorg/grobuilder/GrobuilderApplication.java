package org.grorg.grobuilder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GrobuilderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrobuilderApplication.class, args);
    }

    @Bean
    public CommandLineRunner program() {
        return args -> {
            boolean condition = true;
            var dd = GroDto
                    .builder()
                    .onCondition(condition)
                    .name("DOUZE")

                    .onCondition(!condition)
                    .age(12)
                    .id(14)

                    .onCondition(condition)
                    .size(21.21)
                    .build();

            System.out.println(dd);
        };
    }
}
