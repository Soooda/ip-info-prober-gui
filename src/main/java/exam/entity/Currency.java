package exam.entity;

/**
 * This class stores the information of currency section for the main {@link IPResponse}.
 */
public class Currency {
    private String currencyName;
    private String currencyCode;

    /**
     * Currency Constructor.
     * @param currencyName The name of the Currency.
     * @param currencyCode The code of the Currency.
     */
    public Currency(String currencyName, String currencyCode) {
        this.currencyName = currencyName;
        this.currencyCode = currencyCode;
    }

    @Override
    public String toString() {
        /** Omits unavilable fields */
        if(currencyName == null) return "";
        return "Currency: " + currencyName + "\n";
    }

    /**
     * Accessor for attribute currencyName.
     */
    public String getCurrencyName() {
        return currencyName;
    }

    /**
     * Accessor for attribute currencyCode.
     */
    public String getCurrencyCode() {
        return currencyCode;
    }
}
