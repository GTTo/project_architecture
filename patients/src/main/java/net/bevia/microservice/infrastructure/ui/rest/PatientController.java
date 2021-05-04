package net.bevia.microservice.infrastructure.ui.rest;

import net.bevia.microservice.app.services.PatientService;
import net.bevia.microservice.domain.entities.Patient;
import net.bevia.microservice.domain.exceptions.PatientException;
import net.bevia.microservice.domain.models.PatientHistory;
import net.bevia.microservice.infrastructure.clients.PatientHistoryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("patients")
public class PatientController {

    private PatientService patientService;
    private PatientHistoryClient patientHistoryClient;

    public PatientController(PatientService patientService, PatientHistoryClient patientHistoryClient) {
        this.patientService = patientService;
        this.patientHistoryClient = patientHistoryClient;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Void> home(){
        return new ResponseEntity("Es una prueba", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
        Patient result = null;
        try {
            result = patientService.savePatient(patient);
        } catch (PatientException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(result, HttpStatus.OK);

    }

    @GetMapping("/{uuid}")
    public Mono<Patient> findByUUID(@PathVariable("uuid") String uuid){
        return patientService.findPatientByUUID(uuid);
    }

    @GetMapping("/history/{uuid}")
    public Flux<PatientHistory> getPatientHistory(@PathVariable("uuid") String uuid){
        return patientHistoryClient.getPatientHistory(uuid);
    }
}
