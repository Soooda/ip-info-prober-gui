package exam.model;

import exam.entity.*;
import exam.api.*;
import exam.database.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.util.List;
import java.io.IOException;
import java.util.Arrays;

public class ModelFacadeImplTest {
    private ModelFacade model;
    private InputAPIHandler input;
    private OutputAPIHandler output;
    private DatabaseHandler database;

    @Before
    public void setup() throws IOException {
        List<String> args = Arrays.asList("offline", "offline");
        model = new ModelFacadeImpl(args);

        input = mock(InputAPIHandler.class);
        output = mock(OutputAPIHandler.class);
        database = mock(DatabaseHandler.class);

        model.setInputAPIHandler(input);
        model.setOutputAPIHandler(output);
        model.setDatabaseHandler(database);
    }

    @Test
    public void testLocateNotMatchingTime() throws IOException {
        when(input.get(anyString(), anyMap())).thenReturn("{\"ip_address\":\"47.52.140.225\",\"city\":\"Central\",\"city_geoname_id\":8223932,\"region\":\"Central and Western District\",\"region_iso_code\":\"HCW\",\"region_geoname_id\":7533598,\"postal_code\":null,\"country\":\"Hong Kong\",\"country_code\":\"HK\",\"country_geoname_id\":1819730,\"country_is_eu\":false,\"continent\":\"Asia\",\"continent_code\":\"AS\",\"continent_geoname_id\":6255147,\"longitude\":114.146,\"latitude\":22.2795,\"security\":{\"is_vpn\":false},\"timezone\":{\"name\":\"Asia/Hong_Kong\",\"abbreviation\":\"HKT\",\"gmt_offset\":8,\"current_time\":\"21:15:54\",\"is_dst\":false},\"flag\":{\"emoji\":\"🇭🇰\",\"unicode\":\"U+1F1ED U+1F1F0\",\"png\":\"https://static.abstractapi.com/country-flags/HK_flag.png\",\"svg\":\"https://static.abstractapi.com/country-flags/HK_flag.svg\"},\"currency\":{\"currency_name\":\"HKD\",\"currency_code\":\"HKD\"},\"connection\":{\"autonomous_system_number\":45102,\"autonomous_system_organization\":\"Alibaba (US) Technology Co., Ltd.\",\"connection_type\":\"Corporate\",\"isp_name\":\"Alibaba.com LLC\",\"organization_name\":\"ALICLOUD-HK\"}}");

        IPResponse r = null;
        try {
            r = model.locate("47.52.140.225");
        } catch(IllegalArgumentException e) {
            fail();
        }
        verify(input, times(1)).get(anyString(), anyMap());

        assertEquals("47.52.140.225", r.getIpAddress());
        assertEquals("Central", r.getCity());
        assertEquals(8223932, r.getCityGeonameID());
        assertEquals("Central and Western District", r.getRegion());
        assertEquals("HCW", r.getRegionIsoCode());
        assertEquals(7533598, r.getRegionGeonameID());
        assertNull(r.getPostalCode());
        assertEquals("Hong Kong", r.getCountry());
        assertEquals("HK", r.getCountryCode());
        assertEquals(1819730, r.getCountryGeonameID());
        assertFalse(r.getCountryIsEU());
        assertEquals("Asia", r.getContinent());
        assertEquals("AS", r.getContinentCode());
        assertEquals(6255147, r.getContinentGeonameID());
        assertEquals(114.146, r.getLongitude(), 0.001);
        assertEquals(22.2795, r.getLatitude(), 0.001);

        assertFalse(r.getSecurity().getIsVPN());

        assertEquals("Asia/Hong_Kong", r.getTimezone().getName());
        assertEquals("HKT", r.getTimezone().getAbbreviation());
        assertEquals(8, r.getTimezone().getGmtOffset());
        assertEquals("21:15:54", r.getTimezone().getCurrentTime());
        assertFalse(r.getTimezone().getIsDST());

        assertEquals("🇭🇰", r.getFlag().getEmoji());
        assertEquals("U+1F1ED U+1F1F0", r.getFlag().getUnicode());
        assertEquals("https://static.abstractapi.com/country-flags/HK_flag.png", r.getFlag().getPngURL());
        assertEquals("https://static.abstractapi.com/country-flags/HK_flag.svg", r.getFlag().getSvgURL());

        assertEquals("HKD", r.getCurrency().getCurrencyName());
        assertEquals("HKD", r.getCurrency().getCurrencyCode());

        assertEquals(45102, r.getConnection().getAutonomousSystemNumber());
        assertEquals("Alibaba (US) Technology Co., Ltd.", r.getConnection().getAutonomousSystemOrganization());
        assertEquals("Corporate", r.getConnection().getConnectionType());
        assertEquals("Alibaba.com LLC", r.getConnection().getIspName());
        assertEquals("ALICLOUD-HK", r.getConnection().getOrganisationName());

        assertFalse(r.matchTime());
    }

    @Test
    public void testLocateMatchingTime() throws IOException {
        when(input.get(anyString(), anyMap())).thenReturn("{\"ip_address\":\"47.52.140.225\",\"city\":\"Central\",\"city_geoname_id\":8223932,\"region\":\"Central and Western District\",\"region_iso_code\":\"HCW\",\"region_geoname_id\":7533598,\"postal_code\":null,\"country\":\"Hong Kong\",\"country_code\":\"HK\",\"country_geoname_id\":1819730,\"country_is_eu\":false,\"continent\":\"Asia\",\"continent_code\":\"AS\",\"continent_geoname_id\":6255147,\"longitude\":114.146,\"latitude\":22.2795,\"security\":{\"is_vpn\":false},\"timezone\":{\"name\":\"Asia/Hong_Kong\",\"abbreviation\":\"HKT\",\"gmt_offset\":8,\"current_time\":\"21:15:54\",\"is_dst\":false},\"flag\":{\"emoji\":\"🇭🇰\",\"unicode\":\"U+1F1ED U+1F1F0\",\"png\":\"https://static.abstractapi.com/country-flags/HK_flag.png\",\"svg\":\"https://static.abstractapi.com/country-flags/HK_flag.svg\"},\"currency\":{\"currency_name\":\"HKD\",\"currency_code\":\"HKD\"},\"connection\":{\"autonomous_system_number\":45102,\"autonomous_system_organization\":\"Alibaba (US) Technology Co., Ltd.\",\"connection_type\":\"Corporate\",\"isp_name\":\"Alibaba.com LLC\",\"organization_name\":\"ALICLOUD-HK\"}}");

        model.setGMT(8);
        IPResponse r = null;
        try {
            r = model.locate("47.52.140.225");
        } catch(IllegalArgumentException e) {
            fail();
        }
        verify(input, times(1)).get(anyString(), anyMap());

        assertEquals("47.52.140.225", r.getIpAddress());
        assertEquals("Central", r.getCity());
        assertEquals(8223932, r.getCityGeonameID());
        assertEquals("Central and Western District", r.getRegion());
        assertEquals("HCW", r.getRegionIsoCode());
        assertEquals(7533598, r.getRegionGeonameID());
        assertNull(r.getPostalCode());
        assertEquals("Hong Kong", r.getCountry());
        assertEquals("HK", r.getCountryCode());
        assertEquals(1819730, r.getCountryGeonameID());
        assertFalse(r.getCountryIsEU());
        assertEquals("Asia", r.getContinent());
        assertEquals("AS", r.getContinentCode());
        assertEquals(6255147, r.getContinentGeonameID());
        assertEquals(114.146, r.getLongitude(), 0.001);
        assertEquals(22.2795, r.getLatitude(), 0.001);

        assertFalse(r.getSecurity().getIsVPN());

        assertEquals("Asia/Hong_Kong", r.getTimezone().getName());
        assertEquals("HKT", r.getTimezone().getAbbreviation());
        assertEquals(8, r.getTimezone().getGmtOffset());
        assertEquals("21:15:54", r.getTimezone().getCurrentTime());
        assertFalse(r.getTimezone().getIsDST());

        assertEquals("🇭🇰", r.getFlag().getEmoji());
        assertEquals("U+1F1ED U+1F1F0", r.getFlag().getUnicode());
        assertEquals("https://static.abstractapi.com/country-flags/HK_flag.png", r.getFlag().getPngURL());
        assertEquals("https://static.abstractapi.com/country-flags/HK_flag.svg", r.getFlag().getSvgURL());

        assertEquals("HKD", r.getCurrency().getCurrencyName());
        assertEquals("HKD", r.getCurrency().getCurrencyCode());

        assertEquals(45102, r.getConnection().getAutonomousSystemNumber());
        assertEquals("Alibaba (US) Technology Co., Ltd.", r.getConnection().getAutonomousSystemOrganization());
        assertEquals("Corporate", r.getConnection().getConnectionType());
        assertEquals("Alibaba.com LLC", r.getConnection().getIspName());
        assertEquals("ALICLOUD-HK", r.getConnection().getOrganisationName());

        assertTrue(r.matchTime());
    }

    @Test
    public void testLocateIPUndefined() throws IOException {
        when(input.get(anyString(), anyMap())).thenReturn("");
        try {
            model.locate("2001:0db8:85a3:0000:0000:8a2e:0370:7334");
            fail();
        } catch(IllegalArgumentException e) {}
    }

    @Test
    public void testLocateInvalidAPIKey() throws IOException {
        when(input.get(anyString(), anyMap())).thenReturn("{\"error\":{\"message\":\"Invalid API key provided.\",\"code\":\"unauthorized\",\"details\":null}}");
        try {
            model.locate("2001:0db8:85a3:0000:0000:8a2e:0370:7334");
            fail();
        } catch(IllegalArgumentException e) {}
    }

    @Test
    public void testLocateTooManyRequests() throws IOException {
        when(input.get(anyString(), anyMap())).thenReturn("{\"error\":{\"message\":\"Free plan is limited to 1 request per second. Please wait or upgrade to remove this restriction.\",\"code\":\"too_many_requests\",\"details\":null}}");
        try {
            model.locate("2001:0db8:85a3:0000:0000:8a2e:0370:7334");
            fail();
        } catch(IllegalArgumentException e) {}
    }

    @Test
    public void testGenerateReport() throws IOException {
        when(output.post(anyString(), anyMap())).thenReturn("https://pastebin.com/UIFdu235s");
        IPResponse r = mock(IPResponse.class);
        when(r.toString()).thenReturn("123");

        try {
            assertEquals("https://pastebin.com/UIFdu235s", model.generateReport(r));
        } catch(IllegalArgumentException e) {
            fail();
        }
        verify(output, times(1)).post(anyString(), anyMap());
    }

    @Test
    public void testGenerateReportInvalidAPIOption() throws IOException {
        when(output.post(anyString(), anyMap())).thenReturn("Bad API request, invalid api_option");
        IPResponse r = mock(IPResponse.class);
        when(r.toString()).thenReturn("123");

        try {
            model.generateReport(r);
            fail();
        } catch(IllegalArgumentException e) {}
        verify(output, times(1)).post(anyString(), anyMap());
    }

    @Test
    public void testGenerateReportInvalidAPIDevKey() throws IOException {
        when(output.post(anyString(), anyMap())).thenReturn("Bad API request, invalid api_dev_key");
        IPResponse r = mock(IPResponse.class);
        when(r.toString()).thenReturn("123");

        try {
            model.generateReport(r);
            fail();
        } catch(IllegalArgumentException e) {}
        verify(output, times(1)).post(anyString(), anyMap());
    }

    @Test
    public void testGenerateReportPasteCodeEmpty() throws IOException {
        when(output.post(anyString(), anyMap())).thenReturn("Bad API request, api_paste_code was empty");
        IPResponse r = mock(IPResponse.class);
        when(r.toString()).thenReturn("123");

        try {
            model.generateReport(r);
            fail();
        } catch(IllegalArgumentException e) {}
        verify(output, times(1)).post(anyString(), anyMap());
    }

    @Test
    public void testGenerateReportMaxPasteFileSize() throws IOException {
        when(output.post(anyString(), anyMap())).thenReturn("Bad API request, maximum paste file size exceeded");
        IPResponse r = mock(IPResponse.class);
        when(r.toString()).thenReturn("123");

        try {
            model.generateReport(r);
            fail();
        } catch(IllegalArgumentException e) {}
        verify(output, times(1)).post(anyString(), anyMap());
    }

    @Test
    public void testCaching() throws IOException {
        assertFalse(model.isCached("47.52.140.225"));
        verify(database, times(1)).query("47.52.140.225");


        when(input.get(anyString(), anyMap())).thenReturn("{\"ip_address\":\"47.52.140.225\",\"city\":\"Central\",\"city_geoname_id\":8223932,\"region\":\"Central and Western District\",\"region_iso_code\":\"HCW\",\"region_geoname_id\":7533598,\"postal_code\":null,\"country\":\"Hong Kong\",\"country_code\":\"HK\",\"country_geoname_id\":1819730,\"country_is_eu\":false,\"continent\":\"Asia\",\"continent_code\":\"AS\",\"continent_geoname_id\":6255147,\"longitude\":114.146,\"latitude\":22.2795,\"security\":{\"is_vpn\":false},\"timezone\":{\"name\":\"Asia/Hong_Kong\",\"abbreviation\":\"HKT\",\"gmt_offset\":8,\"current_time\":\"21:15:54\",\"is_dst\":false},\"flag\":{\"emoji\":\"🇭🇰\",\"unicode\":\"U+1F1ED U+1F1F0\",\"png\":\"https://static.abstractapi.com/country-flags/HK_flag.png\",\"svg\":\"https://static.abstractapi.com/country-flags/HK_flag.svg\"},\"currency\":{\"currency_name\":\"HKD\",\"currency_code\":\"HKD\"},\"connection\":{\"autonomous_system_number\":45102,\"autonomous_system_organization\":\"Alibaba (US) Technology Co., Ltd.\",\"connection_type\":\"Corporate\",\"isp_name\":\"Alibaba.com LLC\",\"organization_name\":\"ALICLOUD-HK\"}}");
        model.locate("47.52.140.255");
        verify(database, times(1)).cache(anyString(), anyString());
    }

    @Test
    public void testGetCache() throws IOException {
        when(database.get(anyString())).thenReturn("{\"ip_address\":\"47.52.140.225\",\"city\":\"Central\",\"city_geoname_id\":8223932,\"region\":\"Central and Western District\",\"region_iso_code\":\"HCW\",\"region_geoname_id\":7533598,\"postal_code\":null,\"country\":\"Hong Kong\",\"country_code\":\"HK\",\"country_geoname_id\":1819730,\"country_is_eu\":false,\"continent\":\"Asia\",\"continent_code\":\"AS\",\"continent_geoname_id\":6255147,\"longitude\":114.146,\"latitude\":22.2795,\"security\":{\"is_vpn\":false},\"timezone\":{\"name\":\"Asia/Hong_Kong\",\"abbreviation\":\"HKT\",\"gmt_offset\":8,\"current_time\":\"21:15:54\",\"is_dst\":false},\"flag\":{\"emoji\":\"🇭🇰\",\"unicode\":\"U+1F1ED U+1F1F0\",\"png\":\"https://static.abstractapi.com/country-flags/HK_flag.png\",\"svg\":\"https://static.abstractapi.com/country-flags/HK_flag.svg\"},\"currency\":{\"currency_name\":\"HKD\",\"currency_code\":\"HKD\"},\"connection\":{\"autonomous_system_number\":45102,\"autonomous_system_organization\":\"Alibaba (US) Technology Co., Ltd.\",\"connection_type\":\"Corporate\",\"isp_name\":\"Alibaba.com LLC\",\"organization_name\":\"ALICLOUD-HK\"}}");
        when(database.query(anyString())).thenReturn(true);
        assertTrue(model.isCached("47.52.140.225"));
        verify(database, times(1)).query(anyString());

        IPResponse r = model.getCache("47.52.140.225");
        verify(database, times(2)).query("47.52.140.225");
        verify(database, times(1)).get(anyString());

        assertEquals("47.52.140.225", r.getIpAddress());
        assertEquals("Central", r.getCity());
        assertEquals(8223932, r.getCityGeonameID());
        assertEquals("Central and Western District", r.getRegion());
        assertEquals("HCW", r.getRegionIsoCode());
        assertEquals(7533598, r.getRegionGeonameID());
        assertNull(r.getPostalCode());
        assertEquals("Hong Kong", r.getCountry());
        assertEquals("HK", r.getCountryCode());
        assertEquals(1819730, r.getCountryGeonameID());
        assertFalse(r.getCountryIsEU());
        assertEquals("Asia", r.getContinent());
        assertEquals("AS", r.getContinentCode());
        assertEquals(6255147, r.getContinentGeonameID());
        assertEquals(114.146, r.getLongitude(), 0.001);
        assertEquals(22.2795, r.getLatitude(), 0.001);

        assertFalse(r.getSecurity().getIsVPN());

        assertEquals("Asia/Hong_Kong", r.getTimezone().getName());
        assertEquals("HKT", r.getTimezone().getAbbreviation());
        assertEquals(8, r.getTimezone().getGmtOffset());
        assertEquals("21:15:54", r.getTimezone().getCurrentTime());
        assertFalse(r.getTimezone().getIsDST());

        assertEquals("🇭🇰", r.getFlag().getEmoji());
        assertEquals("U+1F1ED U+1F1F0", r.getFlag().getUnicode());
        assertEquals("https://static.abstractapi.com/country-flags/HK_flag.png", r.getFlag().getPngURL());
        assertEquals("https://static.abstractapi.com/country-flags/HK_flag.svg", r.getFlag().getSvgURL());

        assertEquals("HKD", r.getCurrency().getCurrencyName());
        assertEquals("HKD", r.getCurrency().getCurrencyCode());

        assertEquals(45102, r.getConnection().getAutonomousSystemNumber());
        assertEquals("Alibaba (US) Technology Co., Ltd.", r.getConnection().getAutonomousSystemOrganization());
        assertEquals("Corporate", r.getConnection().getConnectionType());
        assertEquals("Alibaba.com LLC", r.getConnection().getIspName());
        assertEquals("ALICLOUD-HK", r.getConnection().getOrganisationName());
    }
}
