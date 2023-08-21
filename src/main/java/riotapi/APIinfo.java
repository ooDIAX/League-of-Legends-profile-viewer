package riotapi;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@Getter
@Setter
public class APIinfo {

    public final static String privateKey = "API_KEY";

    public static String getData(String strUrl){
        try {
            URL url = new URL(strUrl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();

            // 200 OK
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {

                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                //Close the scanner
                scanner.close();

//                System.out.println(informationString);
                String info = informationString.toString();
                return info;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
