package exam.presenter;

import exam.entity.IPResponse;

public interface Presenter {
    /**
     * This method throws an error pop up box with corresponding message.
     * @param message The message to display in the pop up box.
     */
    void error(String message);

    /**
     * Generates an IPResponse view based on the input IP address.
     * @param ipAddress The IP address to locate.
     */
    void locate(String ipAddress);

    /**
     * Generates an IPResponse view based on the cached data.
     * @param ipAddress The IP address to locate.
     */
    void getCache(String ipAddress);

    /**
     * If the IP is cached, seek confirmation from the user.
     * @param ipAddress The IP address to locate.
     */
    void confirm(String ipAddress);

    /**
     * Generates a report using the input IP address to the output API.
     * @param ipResponse The data to generate a report for.
     */
    void generateReport(IPResponse ipResponse);


    /**
     * Sets the GMT offset when launching the application.
     * @param gmt An integer between -12 and 12.
     * @throws IllegalArgumentException If the input breachs the GMT condition.
     */
    void setGMT(int gmt) throws IllegalArgumentException;
}
