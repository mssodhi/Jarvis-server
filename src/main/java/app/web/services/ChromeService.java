package app.web.services;

import org.springframework.stereotype.Service;

@Service
public class ChromeService {

    public void openChrome() throws Exception {
        String command = "tell application \"Google Chrome\"\n" +
                "\ttell (make new window)\n" +
                "\tend tell\n" +
                "\tactivate\n" +
                "end tell";

        Runtime runtime = Runtime.getRuntime();
        String[] args = {"osascript", "-e", command};
        Process process = runtime.exec(args);
    }

    public void openFb() throws Exception {
        String command = "tell application \"Google Chrome\"\n" +
                "\topen location \"https://facebook.com\"\n" +
                "end tell";

        Runtime runtime = Runtime.getRuntime();
        String[] args = {"osascript", "-e", command};
        Process process = runtime.exec(args);
    }

    public void openNetflix() throws Exception {
        String command = "tell application \"Google Chrome\"\n" +
                "\topen location \"https://netflix.com\"\n" +
                "end tell";

        Runtime runtime = Runtime.getRuntime();
        String[] args = {"osascript", "-e", command};
        Process process = runtime.exec(args);
    }

    public void openYahoo() throws Exception {
        String command = "tell application \"Google Chrome\"\n" +
                "\topen location \"https://yahoo.com\"\n" +
                "end tell";

        Runtime runtime = Runtime.getRuntime();
        String[] args = {"osascript", "-e", command};
        Process process = runtime.exec(args);
    }
}