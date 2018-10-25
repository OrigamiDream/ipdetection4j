package avis.ipqualityscore4j.common;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public interface JSONHelper {

    default JSONObject parseJSON(String url) {
        JSONObject object = null;
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            object = new JSONObject(new JSONTokener(connection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }

}
