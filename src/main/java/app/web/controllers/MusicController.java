package app.web.controllers;

import app.web.services.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(value = "/")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @RequestMapping(value = "playTop100", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void playTop100() throws Exception {
        musicService.playTop100();
    }

    @RequestMapping(value = "mute", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void mute() throws Exception {
        musicService.mute();
    }

    @RequestMapping(value = "unMute", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void unMute() throws Exception {
        musicService.unMute();
    }


    @RequestMapping(value = "play", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void play() throws Exception {
        musicService.play();
    }

    @RequestMapping(value = "pause", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void pause() throws Exception {
        musicService.pause();
    }

    @RequestMapping(value = "next", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void next() throws Exception {
        musicService.next();
    }

    @RequestMapping(value = "previous", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void previous() throws Exception {
        musicService.previous();
    }

}
