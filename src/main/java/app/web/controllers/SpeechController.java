package app.web.controllers;

import app.web.services.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

@Controller
@RequestMapping(value = "/")
public class SpeechController {

    @Autowired
    private MusicService musicService;

    private String[] playTopCommands = new String[] {"play top music", "play top", "top music"};
    private String[] pauseCommands = new String[] {"pause", "stop"};
    private String[] muteCommands = new String[] {"mute"};
    private String[] unmuteCommands = new String[] {"unmute"};
    private String[] playMusicCommands = new String[] {"play", "play music"};
    private String[] nextCommands = new String[] {"next", "next song", "next track", "play next", "skip"};
    private String[] previousCommands = new String[] {"previous", "last", "last song", "back"};
    private String[] lightsOnCommands = new String[] {"lights on, turn on lights"};
    private String[] lightsOffCommands = new String[] {"lights off", "turn off lights"};

    @RequestMapping(value = "speech", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void inputSpeech(@RequestParam String input) throws Exception {

        if(Arrays.asList(playTopCommands).contains(input)) { musicService.playTop100(); }
        if(Arrays.asList(pauseCommands).contains(input)) { musicService.pause(); }
        if(Arrays.asList(muteCommands).contains(input)) { musicService.mute(); }
        if(Arrays.asList(unmuteCommands).contains(input)) { musicService.unMute(); }
        if(Arrays.asList(playMusicCommands).contains(input)) { musicService.play(); }
        if(Arrays.asList(nextCommands).contains(input)) { musicService.next(); }
        if(Arrays.asList(previousCommands).contains(input)) { musicService.previous(); }
        if(Arrays.asList(lightsOnCommands).contains(input)) { lights("ON"); }
        if(Arrays.asList(lightsOffCommands).contains(input)) { lights("OFF"); }

    }

    private void lights(String status) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("10.0.0.39");
        byte[] sendData = new byte[1];
        sendData = status.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 12000);
        clientSocket.send(sendPacket);
        clientSocket.close();
    }
}
