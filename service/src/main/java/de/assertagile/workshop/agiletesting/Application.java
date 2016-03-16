package de.assertagile.workshop.agiletesting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    Logger log = LoggerFactory.getLogger(getClass());

    public static void main(final String[] args) {
        final SpringApplication application = new SpringApplication(Application.class);
        application.run(args);
    }
}
