package exam.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.util.Map;

/**
 * This is the online Input API Handler.
 */
public class OnlineInputAPIHandler implements InputAPIHandler {
    private OkHttpClient client;

    public OnlineInputAPIHandler(OkHttpClient client) {
        this.client = client;
    }

    @Override
    public String get(String url, Map<String, String> params) throws IOException {
        if (!params.isEmpty()) {
            StringBuilder sb = new StringBuilder(url);
            sb.append("?");

            for(String key:params.keySet()) {
                sb.append(key + "=" + params.get(key) + "&");
            }

            /** Remove the last '&' */
            sb.setLength(sb.length() - 1);
            url = sb.toString();
        }

        /** Ref: https://square.github.io/okhttp/ */
        Request request = new Request.Builder()
            .url(url)
            .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
