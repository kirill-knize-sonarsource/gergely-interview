package eu.sige.daterbackend.controller;

import eu.sige.daterbackend.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    final DogService dogService;

    @Autowired
    public WebController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("dogs")
    @CrossOrigin(origins = "*") // TODO Fix this
    public String getDogs() {
        return dogService.getDogUrl();
    }
}
