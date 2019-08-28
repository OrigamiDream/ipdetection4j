package avis.ipdetection4j.common;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public interface JSONHelper {

    default JSONObject parseJSON(String url) {
        return parseJSON(url, new HashMap<>());
    }

    default JSONObject parseJSON(String url, Map<String, String> headers) {
        JSONObject object = null;
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            headers.forEach(connection::setRequestProperty);
            object = new JSONObject(new JSONTokener(connection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }

}
