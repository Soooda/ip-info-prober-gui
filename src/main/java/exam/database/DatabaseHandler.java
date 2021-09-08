package exam.database;

public interface DatabaseHandler {
    /**
     * Checks whether the IP address is cached in the database.
     * @param ip The IP address to query.
     * @return True/False.
     */
    boolean query(String ip);

    /**
     * Stores the data of an IP address into the database.
     * @param ip The IP address that the data belong to.
     * @param json The data.
     * @return True for successful insertion, or False for failing.
     */
    boolean cache(String ip, String json);

    /**
     * Gets the data of the IP address from the database.
     * @param ip The IP address to look up.
     * @return The data in the form of JSON string or null if something went wrong.
     */
    String get(String ip);
}
