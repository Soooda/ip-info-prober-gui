package exam.json;

import exam.entity.IPResponse;

public interface JSONConverter {
    /**
     * Checks whether the json contains any error messages.
     * @param json The JSON string.
     * @return null for error-free (good to convert) or an error message.
     */
    String checkError(String json);

    /**
     * Converts the json into an {@link IPResponse} object.
     * @param json The JSON string.
     * @return The {@link IPResponse} object or null if json cannot be parsed.
     */
    IPResponse convert(String json);

    /**
     * Sets the GMT offset.
     * @param gmt An integer between -12 and 12.
     */
    void setGMT(int gmt);
}
