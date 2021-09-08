package exam.api;

import java.io.IOException;
import java.util.Map;

/**
 * This is the offline Output API Handler.
 * Output is redirected to stdout.
 */
public class DummyOutputAPIHandler implements OutputAPIHandler {
    @Override
    public String post(String url, Map<String, String> params) throws IOException {
        /** Print to Stdout */
        String code = params.get("api_paste_code");
        System.out.println(code);
        return "https://pastebin.com/LookAtStandOut";
    }
}
