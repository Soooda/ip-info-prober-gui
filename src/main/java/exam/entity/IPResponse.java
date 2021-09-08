package exam.entity;


/**
 * This class represents a Response instance of a certain IP address based on the API response.
 */
public class IPResponse {
    private String ipAddress;
    private String city;
    private long cityGeonameID;
    private String region;
    private String regionIsoCode;
    private long regionGeonameID;
    private String postalCode;
    private String country;
    private String countryCode;
    private long countryGeonameID;
    private boolean countryIsEU;
    private String continent;
    private String continentCode;
    private long continentGeonameID;
    private double longitude;
    private double latitude;
    private Security security;
    private Timezone timezone;
    private Flag flag;
    private Currency currency;
    private Connection connection;
    private boolean matchTime;

    /**
     * IPResponse Constructor.
     * @param ipAddress The IP Address.
     * @param city City's name.
     * @param cityGeonameID City's geoname ID.
     * @param region State or province in which the city is located.
     * @param regionIsoCode State or province's ISO 3166-2 code.
     * @param regionGeonameID State or province's geoname ID.
     * @param postalCode ZIP or postal code.
     * @param country Country's name.
     * @param countryCode Country's ISO 3166-1 alpha-2 code.
     * @param countryGeonameID Country's geoname ID.
     * @param countryIsEU True if the country is in the EU, false if it is not
     * @param continent Continent's name.
     * @param continentCode 2 letter continent code: AF, AS, EU, NA, OC, SA, AN
     * @param continentGeonameID Continent's geoname ID.
     * @param longitude Decimal of the longitude.
     * @param latitude Decimal of the latitude.
     * @param security Security section.
     * @param timezone Timezone section.
     * @param flag Flag section.
     * @param currency Currency section.
     * @param connection Connection section.
     */
    public IPResponse(
            String ipAddress,
            String city,
            long cityGeonameID,
            String region,
            String regionIsoCode,
            long regionGeonameID,
            String postalCode,
            String country,
            String countryCode,
            long countryGeonameID,
            boolean countryIsEU,
            String continent,
            String continentCode,
            long continentGeonameID,
            double longitude,
            double latitude,
            Security security,
            Timezone timezone,
            Flag flag,
            Currency currency,
            Connection connection,
            boolean matchTime
            ) {
                this.ipAddress = ipAddress;
                this.city = city;
                this.cityGeonameID = cityGeonameID;
                this.region = region;
                this.regionIsoCode = regionIsoCode;
                this.regionGeonameID = regionGeonameID;
                this.postalCode = postalCode;
                this.country = country;
                this.countryCode = countryCode;
                this.countryGeonameID = countryGeonameID;
                this.countryIsEU = countryIsEU;
                this.continent = continent;
                this.continentCode = continentCode;
                this.continentGeonameID = continentGeonameID;
                this.longitude = longitude;
                this.latitude = latitude;
                this.security = security;
                this.timezone = timezone;
                this.flag = flag;
                this.currency = currency;
                this.connection = connection;
                this.matchTime = matchTime;
            }

    @Override
    public String toString() {
        /** For reporting purpose */
        StringBuilder sb = new StringBuilder();

        /** Add * if match time */
        if(matchTime) {
            sb.append("*\n");
        }

        sb.append("IP Address: " + ipAddress + "\n");
        if(city != null) sb.append("City: " + city + "\n");
        if(region != null) sb.append("Region: " + region + "\n");
        if(regionIsoCode != null) sb.append("Region Abbreviation: " + regionIsoCode + "\n");

        /** For some ips, it may be null. */
        if(postalCode != null) {
            sb.append("Postal Code: " + postalCode + "\n");
        }

        if(country != null) sb.append("Country: " + country + "\n");
        if(countryCode != null) sb.append("Country Abbreviation: " + countryCode + "\n");
        if(continent != null) sb.append("Continent: " + continent + "\n");
        if(countryCode != null) sb.append("Continent Abbreviation: " + continentCode + "\n");
        sb.append("Longitude: " + longitude + "\n");
        sb.append("Latitude: " + latitude + "\n");
        sb.append(security);
        sb.append(timezone);
        sb.append(flag);
        sb.append(currency);
        sb.append(connection);

        String ret = sb.toString();
        return ret;
    }

    /**
     * Accessor for attribute ipAddress.
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * Accessor for attribute city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Accessor for attribute cityGeonameID.
     */
    public long getCityGeonameID() {
        return cityGeonameID;
    }

    /**
     * Accessor for attribute region.
     */
    public String getRegion() {
        return region;
    }

    /**
     * Accessor for attribute regionIsoCode.
     */
    public String getRegionIsoCode() {
        return regionIsoCode;
    }

    /**
     * Accessor for attribute regionGeonameID.
     */
    public long getRegionGeonameID() {
        return regionGeonameID;
    }

    /**
     * Accessor for attribute postalCode.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Accessor for attribute country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Accessor for attribute countryCode.
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Accessor for attribute countryGeonameID.
     */
    public long getCountryGeonameID() {
        return countryGeonameID;
    }

    /**
     * Accessor for attribute countryIsEU.
     */
    public boolean getCountryIsEU() {
        return countryIsEU;
    }

    /**
     * Accessor for attribute continent.
     */
    public String getContinent() {
        return continent;
    }

    /**
     * Accessor for attribute continentCode.
     */
    public String getContinentCode() {
        return continentCode;
    }

    /**
     * Accessor for attribute continentGeonameID.
     */
    public long getContinentGeonameID() {
        return continentGeonameID;
    }

    /**
     * Accessor for attribute longitude.
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Accessor for attribute latitude.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Accessor for attribute security.
     */
    public Security getSecurity() {
        return security;
    }

    /**
     * Accessor for attribute timezone.
     */
    public Timezone getTimezone() {
        return timezone;
    }

    /**
     * Accessor for attribute flag.
     */
    public Flag getFlag() {
        return flag;
    }

    /**
     * Accessor for attribute currency.
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * Accessor for attribute connection.
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Returns whether the GMT offset of this IP matches the application-defined GMT offset.
     * @return true if matches, otherwise false.
     */
    public boolean matchTime() {
        return matchTime;
    }
}
