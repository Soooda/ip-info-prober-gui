package exam.api;

import java.util.Map;
import java.io.IOException;

public interface OutputAPIHandler {
    /**
     * Send a POST request to the URL and return the response as a String.
     *
     * @param url The URL that the request is sent to.
     * @param params A map of a collection of required parameters as String.
     * @return The response from the server.
     * @throws IOException If the request could not be executed due to cancellation, a connectivity problem or timeout.
     */
    String post(String url, Map<String, String> params) throws IOException;
}
