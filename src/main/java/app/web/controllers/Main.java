package app.web.controllers;

import org.joda.time.DateTime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(value = "/")
public class Main {

    @RequestMapping("/")
    private String index() {
        return "index";
    }

    @RequestMapping(value = "status", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void status() {
        System.out.println("Status Checked at: " + new DateTime());
    }

}