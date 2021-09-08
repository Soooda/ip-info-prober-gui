package exam.builder;

import exam.entity.*;

public interface IPResponseBuilder {
    /**
     * Resets the builder to empty.
     */
    void reset();

    /**
     * Builds the instance.
     * @return The IPResponse object created.
     */
    IPResponse build();

    /**
     * Adds IP address.
     * @param ipAddress The IP Address.
     * @return This builder.
     */
    IPResponseBuilder addIPAddress(String ipAddress);

    /**
     * Adds City.
     * @param city
     * @return This builder.
     */
    IPResponseBuilder addCity(String city);

    /**
     * Adds City Geoname ID.
     * @param cityGeonameID
     * @return This builder.
     */
    IPResponseBuilder addCityGeonameID(long cityGeonameID);

    /**
     * Adds Region.
     * @param region
     * @return This builder.
     */
    IPResponseBuilder addRegion(String region);

    /**
     * Adds Region ISO Code.
     * @param regionIsoCode
     * @return This builder.
     */
    IPResponseBuilder addRegionIsoCode(String regionIsoCode);

    /**
     * Adds Region Geoname ID.
     * @param regionGeonameID
     * @return This builder.
     */
    IPResponseBuilder addRegionGeonameID(long regionGeonameID);

    /**
     * Adds Postal Code or ZIP.
     * @param postalCode
     * @return This builder.
     */
    IPResponseBuilder addPostalCode(String postalCode);

    /**
     * Adds Country.
     * @param country
     * @return This builder.
     */
    IPResponseBuilder addCountry(String country);

    /**
     * Adds Country Code.
     * @param countryCode
     * @return This builder.
     */
    IPResponseBuilder addCountryCode(String countryCode);

    /**
     * Adds Country Geoname ID.
     * @param countryGeonameID
     * @return This builder.
     */
    IPResponseBuilder addCountryGeonameID(long countryGeonameID);

    /**
     * Adds Country Is EU.
     * @param countryIsEU
     * @return This builder.
     */
    IPResponseBuilder addCountryIsEU(boolean countryIsEU);

    /**
     * Adds Continent.
     * @param continent
     * @return This builder.
     */
    IPResponseBuilder addContinent(String continent);

    /**
     * Adds Continent Code.
     * @param continentCode
     * @return This builder.
     */
    IPResponseBuilder addContinentCode(String continentCode);

    /**
     * Adds Continent Geoname ID.
     * @param continentGeonameID
     * @return This builder.
     */
    IPResponseBuilder addContinentGeonameID(long continentGeonameID);

    /**
     * Adds Longitude
     * @param longitude
     * @return This builder.
     */
    IPResponseBuilder addLongitude(double longitude);

    /**
     * Adds Latitude.
     * @param latitude
     * @return This builder.
     */
    IPResponseBuilder addLatitude(double latitude);

    /**
     * Adds {@link Security} Instance.
     * @param security
     * @return This builder.
     */
    IPResponseBuilder addSecurity(Security security);

    /**
     * Adds {@link Timezone} Instance.
     * @param timezone
     * @return This builder.
     */
    IPResponseBuilder addTimezone(Timezone timezone);

    /**
     * Adds {@link Flag} Instance.
     * @param flag
     * @return This builder.
     */
    IPResponseBuilder addFlag(Flag flag);

    /**
     * Adds {@link Currency} instance.
     * @param currency
     * @return This builder.
     */
    IPResponseBuilder addCurrency(Currency currency);

    /**
     * Adds {@link Connection} instance.
     * @param connection
     * @return This builder.
     */
    IPResponseBuilder addConnection(Connection connection);

    /**
     * Indicates whether this {@link IPResponse} instance matches the application's GMT offset.
     * @param match True/False.
     * @return This builder.
     */
    IPResponseBuilder addMatchTime(boolean match);
}
