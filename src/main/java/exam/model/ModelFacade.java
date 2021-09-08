package exam.model;

import exam.api.*;
import exam.entity.*;
import exam.database.*;

import java.io.IOException;

public interface ModelFacade {
    /**
     * Returns an IPResponse based on the input IP address.
     * @param ipAddress The IP address to locate.
     * @return The information of the IP address.
     * @throws IllegalArgumentException If inputs cause errors.
     * @throws IOException If the request could not be executed due to cancellation, a connectivity problem or timeout.
     */
    IPResponse locate(String ipAddress) throws IllegalArgumentException, IOException;

    /**
     * Generates a report using the input IP address to the output API.
     * @param ipResponse The {@link IPResponse} instance to generate a report.
     * @return The response from the output API or null if errors occur.
     * @throws IllegalArgumentException If input is null.
     */
    String generateReport(IPResponse ipResponse) throws IllegalArgumentException, IOException;

    /**
     * Sets the input API handler for this model.
     * @param input Input API handler.
     */
    void setInputAPIHandler(InputAPIHandler input);

    /**
     * Sets the output API handler for this model.
     * @param output Output API handler.
     */
    void setOutputAPIHandler(OutputAPIHandler output);

    /**
     * Sets the database handler for this model.
     * @param database Database Handler.
     */
    void setDatabaseHandler(DatabaseHandler database);

    /**
     * Checks whether an IP address is cached.
     * @param ipAddress The IP address to query.
     * @return True/False.
     */
    boolean isCached(String ipAddress);

    /**
     * Gets the cached IPResponse based on input IP address.
     * @param ipAddress The IP address to locate.
     * @return The cached information of the IP address.
     * @throws IllegalArgumentException If inputs cause errors.
     */
    IPResponse getCache(String ipAddress) throws IllegalArgumentException;

    /**
     * Sets the GMT offset when launching the application.
     * @param gmt An integer between -12 and 12.
     * @throws IllegalArgumentException If the input breachs the GMT condition.
     */
    void setGMT(int gmt) throws IllegalArgumentException;
}
