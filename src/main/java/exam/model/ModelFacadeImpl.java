package exam.model;

import exam.entity.*;
import exam.api.*;
import exam.database.*;
import exam.json.*;

import okhttp3.OkHttpClient;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ModelFacadeImpl implements ModelFacade {
    private final String INPUT_URL = "https://ipgeolocation.abstractapi.com/v1/";
    private final String OUTPUT_URL = "https://pastebin.com/api/api_post.php";
    private final OkHttpClient client;
    private final JSONConverter converter;
    private String INPUT_API_KEY;
    private String OUTPUT_API_KEY;

    private InputAPIHandler input;
    private OutputAPIHandler output;
    private DatabaseHandler database;

    /**
     * ModelFacade Constructor.
     * @params args Command line arguments.
     * @throws IllegalArgumentException If the command line arguments are unexpected.
     * @throws FileNotFoundException If the .env file is not found.
     */
    public ModelFacadeImpl(List<String> args) throws IllegalArgumentException, FileNotFoundException {
        /** Defensive checking for args */
        if (args == null) throw new IllegalArgumentException("Something went wrong!");
        if (args.size() != 2) throw new IllegalArgumentException("Too many or less command line arguments given!");
        if (args.get(0) == null) throw new IllegalArgumentException("Something went wrong!"); 
        if (args.get(1) == null) throw new IllegalArgumentException("Something went wrong!"); 

        /** Set up API handlers */
        this.client = new OkHttpClient();
        if (args.get(0).equals("online")) {
            this.setInputAPIHandler(new OnlineInputAPIHandler(client));
        } else if (args.get(0).equals("offline")) {
            this.setInputAPIHandler(new DummyInputAPIHandler());
        } else {
            throw new IllegalArgumentException("You can only input <online/offline>!");
        }
        if (args.get(1).equals("online")) {
            this.setOutputAPIHandler(new OnlineOutputAPIHandler(client));
        } else if (args.get(1).equals("offline")) {
            this.setOutputAPIHandler(new DummyOutputAPIHandler());
        } else {
            throw new IllegalArgumentException("You can only input <online/offline>!");
        }

        this.converter = new JSONConverterImpl();
        this.setDatabaseHandler(new DatabaseHandlerImpl());

        /** Read API Keys */
        File f = new File("src/main/resources/.env");
        Scanner reader = new Scanner(f);
        if(reader.hasNextLine()) {
            String temp = reader.nextLine();
            this.INPUT_API_KEY = temp.split("=")[1];
        }
        if(reader.hasNextLine()) {
            String temp = reader.nextLine();
            this.OUTPUT_API_KEY = temp.split("=")[1];
        }
        reader.close();
    }

    @Override
    public void setInputAPIHandler(InputAPIHandler input) {
        this.input = input;
    }

    @Override
    public void setOutputAPIHandler(OutputAPIHandler output) {
        this.output = output;
    }

    @Override
    public IPResponse locate(String ipAddress) throws IllegalArgumentException, IOException {
        if(ipAddress == null) throw new IllegalArgumentException("The ip address transmited is missing!");
        if(ipAddress.equals("")) throw new IllegalArgumentException("The input cannot be empty!");

        /** Prepare the params. */
        Map<String, String> params = new HashMap<>();
        params.put("api_key", INPUT_API_KEY);
        params.put("ip_address", ipAddress);

        String json = null;
        try {
            json = input.get(INPUT_URL, params);
        } catch(IOException e) {
            throw new IOException("The request could not be executed due to cancellation, a connectivity problem or timeout.");
        }

        /** Check Errors */
        String message = converter.checkError(json);
        if(message != null) {
            throw new IllegalArgumentException(message);
        }

        /** Update the database */
        database.cache(ipAddress, json);

        IPResponse ret = converter.convert(json);
        return ret;
    }

    @Override
    public String generateReport(IPResponse ipResponse) throws IllegalArgumentException, IOException {
        if(ipResponse == null) throw new IllegalArgumentException("The request object is missing!");

        /** Prepare the params. */
        Map<String, String> params = new HashMap<>();
        params.put("api_dev_key", OUTPUT_API_KEY);
        params.put("api_option", "paste");
        params.put("api_paste_code", ipResponse.toString());

        String ret = null;
        try {
            ret = output.post(OUTPUT_URL, params);
        } catch(IOException e) {
            throw new IOException("The request could not be executed due to cancellation, a connectivity problem or timeout.");
        }

        /** Check Response */
        if(!ret.startsWith("https://pastebin.com/")) {
            throw new IllegalArgumentException(ret);
        }
        return ret;
    }

    @Override
    public void setDatabaseHandler(DatabaseHandler database) {
        this.database = database;
    }

    @Override
    public boolean isCached(String ipAddress) {
        return database.query(ipAddress);
    }

    @Override
    public IPResponse getCache(String ipAddress) throws IllegalArgumentException {
        /** If the IP address is not in the cache */
        if(!database.query(ipAddress)) return null;

        String json = database.get(ipAddress);

        /** Check Errors */
        String message = converter.checkError(json);
        if(message != null) {
            throw new IllegalArgumentException(message);
        }

        IPResponse ret = converter.convert(json);
        return ret;
    }

    @Override
    public void setGMT(int gmt) throws IllegalArgumentException {
        if(gmt > 12 || gmt < -12) throw new IllegalArgumentException("GMT Offset must be between -12 and 12.");
        converter.setGMT(gmt);
    }
}
