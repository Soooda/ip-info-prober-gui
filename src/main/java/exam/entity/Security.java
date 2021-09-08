package exam.entity;


/**
 * This class stores the information of security section for the main {@link IPResponse}.
 */
public class Security {
    private boolean isVPN;

    /**
     * Security Constructor.
     * @param isVPN The IP address is VPN or not.
     */
    public Security(boolean isVPN) {
        this.isVPN = isVPN;
    }

    @Override
    public String toString() {
        String ret = null;
        if(isVPN) {
            ret = "Yes";
        } else {
            ret = "No";
        }
        return "Is VPN: " + ret + "\n";
    }

    /**
     * Accessor for attribute isVPN.
     */
    public boolean getIsVPN() {
        return isVPN;
    }
}
