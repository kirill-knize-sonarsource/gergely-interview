package eu.sige.daterbackend.controller;

import eu.sige.daterbackend.service.DogService;
import eu.sige.daterbackend.statistic.model.AccessData;
import eu.sige.daterbackend.statistic.repository.AccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    final DogService dogService;

    final AccessRepository accessRepository;

    @Autowired
    public WebController(DogService dogService, AccessRepository accessRepository) {
        this.dogService = dogService;
        this.accessRepository = accessRepository;
    }

    @GetMapping(value = "dogs", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = {"https://www.simongergely.eu", "https://gizsgugya.simongergely.eu/"})
    public ResponseEntity<String> getDogs() {
//        accessRepository.save(new AccessData());
        String dogApiResponse = dogService.getDogApi();
        return new ResponseEntity<>(dogApiResponse, HttpStatus.OK);
    }
}
