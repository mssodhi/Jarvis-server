package app.web.controllers;

import app.web.services.ChromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(value = "/")
public class BrowserController {

    @Autowired
    private ChromeService chromeService;

    @RequestMapping(value = "openChrome", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void openChrome() throws Exception {
        chromeService.openChrome();
    }

    @RequestMapping(value = "openFb", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void openFb() throws Exception {
        chromeService.openFb();
    }
    @RequestMapping(value = "openNetflix", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void openNetflix() throws Exception {
        chromeService.openNetflix();
    }
    @RequestMapping(value = "openYahoo", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void openYahoo() throws Exception {
        chromeService.openYahoo();
    }

}
