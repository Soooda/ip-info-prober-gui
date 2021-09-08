package exam.json;

import exam.entity.*;
import exam.builder.*;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;


public class JSONConverterImpl implements JSONConverter {
    private final JSONParser parser;
    private final IPResponseBuilder builder;
    private int gmt;

    public JSONConverterImpl() {
        this.parser = new JSONParser();
        this.builder = new IPResponseBuilderImpl();

        /** GMT offset by default is set to be zero. */
        this.gmt = 0;
    }

    @Override
    public String checkError(String json) {
        if(json == null) return "Something went horribly wrong.";
        /** If the json is empty means the ip address not found in API's database. */
        if(json.equals("")) return "The IP address is undefined.";

        JSONObject obj = null;
        try {
            obj = (JSONObject) parser.parse(json);
        } catch (ParseException e) {
            /** This is less likely to happen, checkError() should be call before this method. */
            return e.getMessage();
        }

        /** If the json is an error message */
        if(!obj.containsKey("error")) {
            return null;
        }

        JSONObject error = (JSONObject) obj.get("error");
        String message = (String) error.get("message");
        return message;
    }

    @Override
    public IPResponse convert(String json) {
        JSONObject obj = null;
        try {
            obj = (JSONObject) parser.parse(json);
        } catch (ParseException e) {
            /** This is less likely to happen, checkError() should be call before this method. */
            System.out.println(e.getMessage());
            return null;
        }

        /** 
         * Build
         */
        builder.addIPAddress((String) obj.get("ip_address"))
            .addCity((String) obj.get("city"))
            /** For some weired input this field might be null. */
            .addCityGeonameID((long) (obj.get("city_geoname_id") == null ? -1l:obj.get("city_geoname_id")))
            .addRegion((String) obj.get("region"))
            .addRegionIsoCode((String) obj.get("region_iso_code"))
            /** For some weired input this field might be null. */
            .addRegionGeonameID((long) (obj.get("region_geoname_id") == null ? -1l:obj.get("region_geoname_id")))
            .addPostalCode((String) obj.get("postal_code"))
            .addCountry((String) obj.get("country"))
            .addCountryCode((String) obj.get("country_code"))
            .addCountryGeonameID((long) (obj.get("country_geoname_id") == null ? -1l:obj.get("country_geoname_id")))
            .addCountryIsEU((boolean) obj.get("country_is_eu"))
            .addContinent((String) obj.get("continent"))
            .addContinentCode((String) obj.get("continent_code"))
            .addContinentGeonameID((long) (obj.get("continent_geoname_id") == null ? -1l:obj.get("continent_geoname_id")))
            .addLongitude((double) obj.get("longitude"))
            .addLatitude((double) obj.get("latitude"));

        /** Security */
        JSONObject temp = (JSONObject) obj.get("security");
        Security security = new Security((boolean) temp.get("is_vpn"));
        builder.addSecurity(security);

        /** Timezone */
        temp = (JSONObject) obj.get("timezone");
        Timezone timezone = new Timezone(
                (String) temp.get("name"),
                (String) temp.get("abbreviation"),
                (long) temp.get("gmt_offset"),
                (String) temp.get("current_time"),
                (boolean) temp.get("is_dst")
                );
        builder.addTimezone(timezone);

        /** Match Time */
        if(gmt != (long) temp.get("gmt_offset")) {
            builder.addMatchTime(false);
        } else {
            builder.addMatchTime(true);
        }

        /** Flag */
        temp = (JSONObject) obj.get("flag");
        Flag flag = new Flag(
                (String) temp.get("emoji"),
                (String) temp.get("unicode"),
                (String) temp.get("png"),
                (String) temp.get("svg")
                );
        builder.addFlag(flag);

        /** Currency */
        temp = (JSONObject) obj.get("currency");
        Currency currency = new Currency(
                (String) temp.get("currency_name"),
                (String) temp.get("currency_code")
                );
        builder.addCurrency(currency);

        /** Connection */
        temp = (JSONObject) obj.get("connection");
        Connection connection = new Connection(
                (long) temp.get("autonomous_system_number"),
                (String) temp.get("autonomous_system_organization"),
                (String) temp.get("connection_type"),
                (String) temp.get("isp_name"),
                (String) temp.get("organization_name")
                );
        builder.addConnection(connection);


        IPResponse ret = builder.build();
        /** Reset the builder */
        builder.reset();

        return ret;
    }

    @Override
    public void setGMT(int gmt) {
        this.gmt = gmt;
    }
}
