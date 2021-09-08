package exam.view;

import exam.entity.IPResponse;

public interface IPView extends View {
    /**
     * Updates the information displayed for the IP address.
     * @param ipResponse IP Address info data.
     */
    public void update(IPResponse ipResponse);

    /**
     * Gets the data stored in this view.
     * @return The {@link IPResponse} object.
     */
    public IPResponse getData();
}
