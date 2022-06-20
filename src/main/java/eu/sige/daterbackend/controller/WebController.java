package eu.sige.daterbackend.controller;

import eu.sige.daterbackend.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@RestController
public class WebController {

    final DogService dogService;

    @Autowired
    public WebController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping(value = "dogs", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = {"https://www.simongergely.eu", "https://gizsgugya.simongergely.eu/"})
    public ResponseEntity<String> getDogs() {
        String dogApiResponse = dogService.getDogApi();
        return new ResponseEntity<>(dogApiResponse, HttpStatus.OK);
    }
}
