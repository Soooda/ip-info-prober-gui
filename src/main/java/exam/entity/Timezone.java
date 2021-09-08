package exam.entity;

/**
 * This class stores the information of timezone section for the main {@link IPResponse}.
 */
public class Timezone {
    private String name;
    private String abbreviation;
    private long gmtOffset;
    private String currentTime;
    private boolean isDST;

    /**
     * Timezone Constructor.
     * @param name The name of the Timezone.
     * @param abbreviation The abbreviation of the Timezone.
     * @param gmtOffset The Timezone's offset from Greenwich Mean Time.
     * @param currentTime Current time in the local time zone.
     * @param isDST True if the location is currently in Daylight Savings Time.
     */
    public Timezone(
            String name,
            String abbreviation,
            long gmtOffset,
            String currentTime,
            boolean isDST
            ) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.gmtOffset = gmtOffset;
        this.currentTime = currentTime;
        this.isDST= isDST;
            }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if(name != null) sb.append("Timezone Name: " + name + "\n");
        sb.append("Greenwich Mean Time Offset: " + gmtOffset + "\n");
        if(currentTime != null) sb.append("Current Time: " + currentTime + "\n");

        String ret = sb.toString();
        return ret;
    }

    /**
     * Accessor for attribute name.
     */
    public String getName() {
        return name;
    }

    /**
     * Accessor for attribute abbreviation.
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Accessor for attribute gmtOffset.
     */
    public long getGmtOffset() {
        return gmtOffset;
    }

    /**
     * Accessor for attribute currentTime.
     */
    public String getCurrentTime() {
        return currentTime;
    }

    /**
     * Accessor for attribute isDST.
     */
    public boolean getIsDST() {
        return isDST;
    }
}
