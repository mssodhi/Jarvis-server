package app.web.services;

import org.springframework.stereotype.Service;

@Service
public class MusicService {

    public void playTop100() throws Exception {
        String command = "tell application \"Spotify\"\n" +
                "set shuffling to true\n" +
                "\tplay track \"spotify:user:spotify:playlist:4hOKQuZbraPDIfaGbM3lKI\"\n" +
                "\tnext track\n" +
                "end tell";

        Runtime runtime = Runtime.getRuntime();
        String[] args = {"osascript", "-e", command};
        Process process = runtime.exec(args);
    }

    public void mute() throws Exception {
        String command = "set curVolume to get volume settings\n" +
                "if output muted of curVolume is false then\n" +
                "\tset volume with output muted\n" +
                "else\n" +
                "\tset volume without output muted\n" +
                "end if";

        Runtime runtime = Runtime.getRuntime();
        String[] args = {"osascript", "-e", command};
        Process process = runtime.exec(args);
    }

    public void unMute() throws Exception {
        String command = "set volume without output muted";

        Runtime runtime = Runtime.getRuntime();
        String[] args = {"osascript", "-e", command};
        Process process = runtime.exec(args);
    }

    public void play() throws Exception {
        String command = "tell application \"Spotify\"\n" +
                "\tplay\n" +
                "end tell\n";

        Runtime runtime = Runtime.getRuntime();
        String[] args = {"osascript", "-e", command};
        Process process = runtime.exec(args);
    }

    public void pause() throws Exception {
        String command = "tell application \"Spotify\"\n" +
                "\tpause\n" +
                "end tell\n";

        Runtime runtime = Runtime.getRuntime();
        String[] args = {"osascript", "-e", command};
        Process process = runtime.exec(args);
    }

    public void next() throws Exception {
        String command = "tell application \"Spotify\"\n" +
                "\tnext track\n" +
                "end tell\n";

        Runtime runtime = Runtime.getRuntime();
        String[] args = {"osascript", "-e", command};
        Process process = runtime.exec(args);
    }

    public void previous() throws Exception {
        String command = "tell application \"Spotify\"\n" +
                "\tprevious track\n" +
                "end tell\n";

        Runtime runtime = Runtime.getRuntime();
        String[] args = {"osascript", "-e", command};
        Process process = runtime.exec(args);
    }
}