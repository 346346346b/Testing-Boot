package ru.ilyafilim.testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.ilyafilim.testing.config.CSVSettings;
import ru.ilyafilim.testing.config.TestingSettings;
import ru.ilyafilim.testing.services.GameService;

@SpringBootApplication
@EnableConfigurationProperties({CSVSettings.class, TestingSettings.class})
public class TestingApplication {

    @Autowired
    ApplicationContext context;

    public static void main(String[] args) {
        //SpringApplication.run(TestingApplication.class, args);
        ApplicationContext context =
                SpringApplication.run(TestingApplication.class, args);
        GameService gameService = context.getBean(GameService.class);
        gameService.game();
    }

}
