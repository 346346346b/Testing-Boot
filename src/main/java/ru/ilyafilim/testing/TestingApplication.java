package ru.ilyafilim.testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.ilyafilim.testing.config.CSVSettings;
import ru.ilyafilim.testing.config.TestingSettings;

@SpringBootApplication
@EnableConfigurationProperties({CSVSettings.class, TestingSettings.class})
public class TestingApplication {


    public static void main(String[] args) {
        SpringApplication.run(TestingApplication.class, args);
    }

}
