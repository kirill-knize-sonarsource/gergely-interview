package eu.sige.daterbackend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    private final Logger log = LoggerFactory.getLogger(CustomErrorController.class);

    @RequestMapping("/error")
    public ResponseEntity<String> handleError(HttpServletRequest request) {
        String responseCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE).toString();
        HttpStatus httpStatus = HttpStatus.valueOf(Integer.parseInt(responseCode));
        log.warn("An error occurred: {}", responseCode);
        return new ResponseEntity<>(responseCode, httpStatus);
    }


}
