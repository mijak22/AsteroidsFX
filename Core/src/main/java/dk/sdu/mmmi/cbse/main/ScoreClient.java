package dk.sdu.mmmi.cbse.main;

import dk.sdu.mmmi.cbse.common.services.ScoreService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ScoreClient implements ScoreService {

    private final String baseUrl = "http://localhost:8080/scores";

    @Override
    public void submitScore(int value) {
        try {
            URL url = new URL(baseUrl + "?value=" + value);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            int status = conn.getResponseCode();
            if (status == HttpURLConnection.HTTP_OK) {
                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                    String id = reader.readLine();
                    System.out.println("Score submitted, id=" + id);
                }
            } else {
                System.err.println("Failed to submit score: HTTP " + status);
            }
            conn.disconnect();
        } catch (Exception e) {
            System.err.println("Error submitting score: " + e.getMessage());
            e.printStackTrace();
        }
    }
}