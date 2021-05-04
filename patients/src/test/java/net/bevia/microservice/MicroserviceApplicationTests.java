package net.bevia.microservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = PatientsApplication.class)
class MicroserviceApplicationTests {

    @Test
    void contextLoads() {
    }

}
