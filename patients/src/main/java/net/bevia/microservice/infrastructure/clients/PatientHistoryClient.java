package net.bevia.microservice.infrastructure.clients;

import net.bevia.microservice.domain.models.PatientHistory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;


@Component
public class PatientHistoryClient {

    private WebClient client = WebClient.create("http://localhost:8082/api/v1/patients");

    public Flux<PatientHistory> getPatientHistory(String uuid){
        return client.get()
                .uri("/getPatientHistory"+uuid)
                .retrieve().bodyToFlux(PatientHistory.class);
    }
}
