package eu.sige.daterbackend.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public ResponseEntity<String> handleError(HttpServletRequest request) {
        String responseCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE).toString();
        HttpStatus httpStatus = HttpStatus.valueOf(Integer.parseInt(responseCode));
        return new ResponseEntity<>(responseCode, httpStatus);
    }

}
