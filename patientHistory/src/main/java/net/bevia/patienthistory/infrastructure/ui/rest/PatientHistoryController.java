package net.bevia.patienthistory.infrastructure.ui.rest;

import net.bevia.patienthistory.app.services.PatientHistoryService;
import net.bevia.patienthistory.app.services.PatientLineHistoryService;
import net.bevia.patienthistory.domain.entities.PatientHistory;
import net.bevia.patienthistory.domain.entities.PatientLineHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/patients")
public class PatientHistoryController {

    private Logger log = LoggerFactory.getLogger(PatientHistoryController.class);

    private PatientLineHistoryService patientLineHistoryService;
    private PatientHistoryService patientHistoryService;

    public PatientHistoryController(PatientLineHistoryService patientLineHistoryService, PatientHistoryService patientHistoryService){
        this.patientLineHistoryService = patientLineHistoryService;
        this.patientHistoryService = patientHistoryService;

    }

    @PostMapping("/{uuid}")
    public ResponseEntity<PatientLineHistory> saveLine(@RequestBody PatientLineHistory patientLineHistory,
                                                        @PathVariable("uuid") String uuid){

        try{
            PatientLineHistory result = patientLineHistoryService.save(uuid, patientLineHistory);
            return new ResponseEntity(result, HttpStatus.OK);
        } catch (Exception ex){
            log.error(ex.getMessage());
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("getPatientHistory")
    public Flux<PatientHistory> getPatientHistory(@PathVariable("uuid") String uuid){
        Flux<PatientHistory> result = Flux.just(patientHistoryService.getPatientHistory(uuid).get());
        return result;
    }
}
