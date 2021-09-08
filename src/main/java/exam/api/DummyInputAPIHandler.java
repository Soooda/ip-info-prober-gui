package exam.api;

import java.io.IOException;
import java.util.Map;

/**
 * This is the offline Input API Handler.
 */
public class DummyInputAPIHandler implements InputAPIHandler {

    @Override
    public String get(String url, Map<String, String> params) throws IOException {
        String ip = params.get("ip_address");
        // return "{\"ip_address\":\"" + ip +  "\",\"city\":\"Central\",\"city_geoname_id\":8223932,\"region\":\"Central and Western District\",\"region_iso_code\":\"HCW\",\"region_geoname_id\":7533598,\"postal_code\":null,\"country\":\"Hong Kong\",\"country_code\":\"HK\",\"country_geoname_id\":1819730,\"country_is_eu\":false,\"continent\":\"Asia\",\"continent_code\":\"AS\",\"continent_geoname_id\":6255147,\"longitude\":114.146,\"latitude\":22.2795,\"security\":{\"is_vpn\":false},\"timezone\":{\"name\":\"Asia/Hong_Kong\",\"abbreviation\":\"HKT\",\"gmt_offset\":8,\"current_time\":\"21:15:54\",\"is_dst\":false},\"flag\":{\"emoji\":\"🇭🇰\",\"unicode\":\"U+1F1ED U+1F1F0\",\"png\":\"https://static.abstractapi.com/country-flags/HK_flag.png\",\"svg\":\"https://static.abstractapi.com/country-flags/HK_flag.svg\"},\"currency\":{\"currency_name\":\"HKD\",\"currency_code\":\"HKD\"},\"connection\":{\"autonomous_system_number\":45102,\"autonomous_system_organization\":\"Alibaba (US) Technology Co., Ltd.\",\"connection_type\":\"Corporate\",\"isp_name\":\"Alibaba.com LLC\",\"organization_name\":\"ALICLOUD-HK\"}}";
        return "{\"ip_address\":\"" + ip + "\",\"city\":\"New York\",\"city_geoname_id\":123,\"region\":\"Mars\",\"region_iso_code\":\"MA\",\"region_geoname_id\":123321,\"postal_code\":\"1234\",\"country\":\"United States\",\"country_code\":\"US\",\"country_geoname_id\":6252001,\"country_is_eu\":false,\"continent\":\"North America\",\"continent_code\":\"NA\",\"continent_geoname_id\":6255149,\"longitude\":-97.822,\"latitude\":37.751,\"security\":{\"is_vpn\":false},\"timezone\":{\"name\":\"America/Chicago\",\"abbreviation\":\"CDT\",\"gmt_offset\":-5,\"current_time\":\"19:27:29\",\"is_dst\":true},\"flag\":{\"emoji\":\"🇺🇸\",\"unicode\":\"U+1F1FA U+1F1F8\",\"png\":\"https://static.abstractapi.com/country-flags/US_flag.png\",\"svg\":\"https://static.abstractapi.com/country-flags/US_flag.svg\"},\"currency\":{\"currency_name\":\"USD\",\"currency_code\":\"USD\"},\"connection\":{\"autonomous_system_number\":20057,\"autonomous_system_organization\":\"ATT-MOBILITY-LLC-AS20057\",\"connection_type\":\"Cellular\",\"isp_name\":\"AT&T Mobility LLC\",\"organization_name\":\"Service Provider Corporation\"}}";
    }
}
