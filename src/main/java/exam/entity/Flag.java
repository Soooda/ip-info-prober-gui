package exam.entity;

/**
 * This class stores the information of flag section for the main {@link IPResponse}.
 */
public class Flag {
    private String emoji;
    private String unicode;
    private String pngURL;
    private String svgURL;

    /**
     * Flag Constructor.
     * @param emoji The emoji of the Flag.
     * @param unicode The unicode of the Flag.
     * @param pngURL The URL to the png image of the Flag.
     * @param svgURL The URL to the svg image of the FLag.
     */
    public Flag(
            String emoji,
            String unicode,
            String pngURL,
            String svgURL
            ) {
        this.emoji = emoji;
        this.unicode = unicode;
        this.pngURL = pngURL;
        this.svgURL = svgURL;
            }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        /** Omits unavilable fields */
        if(emoji != null) sb.append("Flag Emoji: " + emoji + "\n");
        if(unicode != null) sb.append("Flag Unicode: " + unicode + "\n");
        if(pngURL != null) sb.append("Flag PNG URL: " + pngURL + "\n");
        if(svgURL != null) sb.append("Flag SVG URL: " + svgURL + "\n");

        String ret = sb.toString();
        return ret;
    }

    /**
     * Accessor for attribute emoji.
     */
    public String getEmoji() {
        return emoji;
    }

    /**
     * Accessor for attribute unicode.
     */
    public String getUnicode() {
        return unicode;
    }

    /**
     * Accessor for attribute pngURL.
     */
    public String getPngURL() {
        return pngURL;
    }

    /**
     * Accessor for attribute svgURL.
     */
    public String getSvgURL() {
        return svgURL;
    }
}
