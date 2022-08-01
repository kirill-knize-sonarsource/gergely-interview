package eu.sige.daterbackend.controller;

import eu.sige.daterbackend.service.AccessService;
import eu.sige.daterbackend.service.DogService;
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
    final AccessService accessService;

    @Autowired
    public WebController(DogService dogService, AccessService accessService) {
        this.dogService = dogService;
        this.accessService = accessService;
    }

    @GetMapping(value = "dogs", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = {"https://www.simongergely.eu", "https://gizsgugya.simongergely.eu/"})
    public ResponseEntity<String> getDogs() {
        accessService.maintainDbAndSaveAccessData();
        String dogApiResponse = dogService.getDogApi();
        return new ResponseEntity<>(dogApiResponse, HttpStatus.OK);
    }
}
