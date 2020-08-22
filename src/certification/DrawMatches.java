package certification;

import static java.util.stream.Collectors.joining;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DrawMatches {

    public static int getNumDraws(int year) {
        int numDraws = 0;
        //https://jsonmock.hackerrank.com/api/football_matches?year=2011&page=1
        String urlString = "https://jsonmock.hackerrank.com/api/football_matches?year="+ year +"&page=1";
        try {
            URL url = new URL(urlString);//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output = br.readLine();

            if (output.contains("\"total\":")){
                output = output.replaceFirst(".*\"total\":", "").replaceFirst(",.*","");
                numDraws = Integer.parseInt(output);
            }
            conn.disconnect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return numDraws;
    }

    public static void main(String[] args) {
        DrawMatches.getNumDraws(2011);
    }
}

