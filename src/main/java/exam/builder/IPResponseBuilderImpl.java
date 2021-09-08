package exam.builder;

import exam.entity.*;

/**
 * This is a creator using to generate {@link IPResponse} objects.
 */
public class IPResponseBuilderImpl implements IPResponseBuilder {
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

    public IPResponseBuilderImpl() {
        this.reset();
    }

    @Override
    public void reset() {
        this.ipAddress = null;
        this.city = null;
        this.cityGeonameID = 0;
        this.region = null;
        this.regionIsoCode = null;
        this.regionGeonameID = 0;
        this.postalCode = null;
        this.country = null;
        this.countryCode = null;
        this.countryGeonameID = 0;
        this.countryIsEU = false;
        this.continent = null;
        this.continentCode = null;
        this.continentGeonameID = 0;
        this.longitude = 0;
        this.latitude = 0;
        this.security = null;
        this.timezone = null;
        this.flag = null;
        this.currency = null;
        this.connection = null;
        this.matchTime = false;
    }

    @Override
    public IPResponse build() {
        IPResponse ret = new IPResponse(
            ipAddress,
            city,
            cityGeonameID,
            region,
            regionIsoCode,
            regionGeonameID,
            postalCode,
            country,
            countryCode,
            countryGeonameID,
            countryIsEU,
            continent,
            continentCode,
            continentGeonameID,
            longitude,
            latitude,
            security,
            timezone,
            flag,
            currency,
            connection,
            matchTime
                );
        return ret;
    }

    @Override
    public IPResponseBuilder addIPAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    @Override
    public IPResponseBuilder addCity(String city) {
        this.city = city;
        return this;
    }

    @Override
    public IPResponseBuilder addCityGeonameID(long cityGeonameID) {
        this.cityGeonameID = cityGeonameID;
        return this;
    }

    @Override
    public IPResponseBuilder addRegion(String region) {
        this.region = region;
        return this;
    }

    @Override
    public IPResponseBuilder addRegionIsoCode(String regionIsoCode) {
        this.regionIsoCode = regionIsoCode;
        return this;
    }

    @Override
    public IPResponseBuilder addRegionGeonameID(long regionGeonameID) {
        this.regionGeonameID = regionGeonameID;
        return this;
    }

    @Override
    public IPResponseBuilder addPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    @Override
    public IPResponseBuilder addCountry(String country) {
        this.country = country;
        return this;
    }

    @Override
    public IPResponseBuilder addCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    @Override
    public IPResponseBuilder addCountryGeonameID(long countryGeonameID) {
        this.countryGeonameID = countryGeonameID;
        return this;
    }

    @Override
    public IPResponseBuilder addCountryIsEU(boolean countryIsEU) {
        this.countryIsEU = countryIsEU;
        return this;
    }

    @Override
    public IPResponseBuilder addContinent(String continent) {
        this.continent = continent;
        return this;
    }

    @Override
    public IPResponseBuilder addContinentCode(String continentCode) {
        this.continentCode = continentCode;
        return this;
    }

    @Override
    public IPResponseBuilder addContinentGeonameID(long continentGeonameID) {
        this.continentGeonameID = continentGeonameID;
        return this;
    }

    @Override
    public IPResponseBuilder addLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }

    @Override
    public IPResponseBuilder addLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    @Override
    public IPResponseBuilder addSecurity(Security security) {
        this.security = security;
        return this;
    }

    @Override
    public IPResponseBuilder addTimezone(Timezone timezone) {
        this.timezone = timezone;
        return this;
    }

    @Override
    public IPResponseBuilder addFlag(Flag flag) {
        this.flag = flag;
        return this;
    }

    @Override
    public IPResponseBuilder addCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    @Override
    public IPResponseBuilder addConnection(Connection connection) {
        this.connection = connection;
        return this;
    }

    @Override
    public IPResponseBuilder addMatchTime(boolean match) {
        this.matchTime = match;
        return this;
    }
}
