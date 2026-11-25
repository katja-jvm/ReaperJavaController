import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Track {
    int bpm;
    String title;

    public void playInReaper() {
        // Print track info to console
        System.out.println("Playing track in REAPER: " + title + " (" + bpm + " BPM)");

        // REAPER Web API command URL: 1007 = Play
        String reaperUrl = "http://127.0.0.1:8080/_/1007";

        try {
            // Create HTTP client using HTTP 1.1 protocol
            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_1_1)
                    .build();

            // Build GET request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(reaperUrl))
                    .GET()
                    .build();

            // Send command to REAPER
            client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Command sent successfully!");

        } catch (Exception e) {
            System.out.println("Connection error. Check REAPER Web Interface: " + e.getMessage());
        }
    }
}
