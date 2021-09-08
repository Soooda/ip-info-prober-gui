package exam.entity;

/**
 * This class stores the information of connection section for the main {@link IPResponse}.
 */
public class Connection {
    private long autonomousSystemNumber;
    private String autonomousSystemOrganization;
    private String connectionType;
    private String ispName;
    private String organizationName;

    /**
     * Connection Constructor.
     * @param autonomousSystemNumber Autonomous System number.
     * @param autonomousSystemOrganization Autonomous System Organisation name.
     * @param connectionType Type of network connection.
     * @param ispName Internet Service Provider name.
     * @param organisationName Organisation name.
     */
    public Connection(
            long autonomousSystemNumber,
            String autonomousSystemOrganization,
            String connectionType,
            String ispName,
            String organizationName
            ) {
        this.autonomousSystemNumber = autonomousSystemNumber;
        this.autonomousSystemOrganization = autonomousSystemOrganization;
        this.connectionType = connectionType;
        this.ispName = ispName;
        this.organizationName = organizationName;
            }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        /** Omits unavilable fields */
        if(autonomousSystemOrganization != null) sb.append("Autonomous System Organization: " + autonomousSystemOrganization + "\n");
        if(connectionType != null) sb.append("Connection Type: " + connectionType + "\n");
        if(ispName != null) sb.append("Internet Service Provider Name: " + ispName + "\n");
        if(organizationName != null) sb.append("Organization Name: " + organizationName + "\n");

        String ret = sb.toString();
        return ret;
    }

    /**
     * Accessor for attribute autonomousSystemNumber.
     */
    public long getAutonomousSystemNumber() {
        return autonomousSystemNumber;
    }

    /**
     * Accessor for attribute autonomousSystemOrganization.
     */
    public String getAutonomousSystemOrganization() {
        return autonomousSystemOrganization;
    }

    /**
     * Accessor for attribute connectionType.
     */
    public String getConnectionType() {
        return connectionType;
    }

    /**
     * Accessor for attribute ispName.
     */
    public String getIspName() {
        return ispName;
    }

    /**
     * Accessor for attribute organisationName.
     */
    public String getOrganisationName() {
        return organizationName;
    }
}
