package exam.api;

import okhttp3.FormBody;
import okhttp3.FormBody.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;

/**
 * This is the online Output API Handler.
 */
public class OnlineOutputAPIHandler implements OutputAPIHandler {
    private OkHttpClient client;

    public OnlineOutputAPIHandler(OkHttpClient client) {
        this.client = client;
    }

    @Override
    public String post(String url, Map<String, String> params) throws IOException {
        Builder builder = new FormBody.Builder();

        for(String key:params.keySet()) {
            builder.add(key, params.get(key));
        }

        /** Ref: https://square.github.io/okhttp/ */
        FormBody formBody = builder.build();
        Request request = new Request.Builder()
            .url(url)
            .post(formBody)
            .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
