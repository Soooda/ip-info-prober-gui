package exam.view;

import exam.entity.IPResponse;
import exam.presenter.Presenter;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/** 
 * This class provides the view to an IP request.
 */
public class ResponseView implements IPView {
    private final int WIDTH = 600;
    private final int HEIGHT = 500;
    private final Scene scene;
    private final Stage stage;
    private IPResponse data;

    private final Label ipAddressLabel = new Label("IP Address");
    private final TextField ipAddress = new TextField();
    private final Label cityLabel = new Label("City");
    private final TextField city = new TextField();
    private final Label regionLabel = new Label("Region");
    private final TextField region = new TextField();
    private final Label regionAbbreviationLabel = new Label("Region Abbreviation");
    private final TextField regionAbbreviation = new TextField();
    private final Label postalCodeLabel = new Label("Postal Code");
    private final TextField postalCode = new TextField();
    private final Label countryLabel = new Label("Country");
    private final TextField country = new TextField();
    private final Label countryAbbreviationLabel = new Label("Country Abbreviation");
    private final TextField countryAbbreviation = new TextField();
    private final Label continentLabel = new Label("Continent");
    private final TextField continent = new TextField();
    private final Label continentAbbreviationLabel = new Label("Continent Abbreviation");
    private final TextField continentAbbreviation = new TextField();
    private final Label longitudeLabel = new Label("Longitude");
    private final TextField longitude = new TextField();
    private final Label latitudeLabel = new Label("Latitude");
    private final TextField latitude = new TextField();
    private final Label isVPNLabel = new Label("Is VPN");
    private final TextField isVPN = new TextField();
    private final Label timezoneLabel = new Label("Timezone");
    private final TextField timezone = new TextField();
    private final Label gmtOffsetLabel = new Label("Greenwich Mean Time Offset");
    private final TextField gmtOffset = new TextField();
    private final Label currentTimeLabel = new Label("Current Time");
    private final TextField currentTime = new TextField();
    private final Label emojiLabel = new Label("Emoji");
    private final TextField emoji = new TextField();
    private final Label unicodeLabel = new Label("Unicode");
    private final TextField unicode = new TextField();
    private final Label pngLabel = new Label("Flag PNG");
    private final WebView png;
    private final Label svgLabel = new Label("Flag SVG");
    private final WebView svg;
    private final Label currencyLabel = new Label("Currency");
    private final TextField currency = new TextField();
    private final Label autonomousSystemOrganizationLabel = new Label("Autonomous System Organization");
    private final TextField autonomousSystemOrganization = new TextField();
    private final Label connectionTypeLabel = new Label("Connection Type");
    private final TextField connectionType = new TextField();
    private final Label ispNameLabel = new Label("Internet Service Provider");
    private final TextField ispName = new TextField();
    private final Label organizationLabel = new Label("Organization");
    private final TextField organization = new TextField();

    private final Button generate = new Button("Generate Report");
    private final Text message1 = new Text("You can use cursor to select and copy any useful information!");
    private final Text message2 = new Text("Some fields might be empty due to null returns from API.");
    private final Text matchTime = new Text();

    public ResponseView(Presenter presenter) {
        this.data = null;
        setTextFieldsUneditable();

        /** Set up ImageView */
        png = new WebView();
        png.setMaxHeight(100);
        png.setMaxWidth(150);
        svg = new WebView();
        svg.setMaxHeight(100);
        svg.setMaxWidth(150);

        /** Set Grid */
        GridPane pane = new GridPane();
        pane.setMinSize(WIDTH, HEIGHT);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);

        /** Add in */
        pane.add(ipAddressLabel, 0, 0);
        pane.add(ipAddress, 1, 0);
        pane.add(cityLabel, 2, 0);
        pane.add(city, 3, 0);
        pane.add(regionLabel, 0, 1);
        pane.add(region, 1, 1);
        pane.add(regionAbbreviationLabel, 2, 1);
        pane.add(regionAbbreviation, 3, 1);
        pane.add(postalCodeLabel, 0, 2);
        pane.add(postalCode, 1, 2);
        pane.add(countryLabel, 2, 2);
        pane.add(country, 3, 2);
        pane.add(countryAbbreviationLabel, 0, 3);
        pane.add(countryAbbreviation, 1, 3);
        pane.add(continentLabel, 2, 3);
        pane.add(continent, 3, 3);
        pane.add(continentAbbreviationLabel, 0, 4);
        pane.add(continentAbbreviation, 1, 4);
        pane.add(longitudeLabel, 2, 4);
        pane.add(longitude, 3, 4);
        pane.add(latitudeLabel, 0, 5);
        pane.add(latitude, 1, 5);
        pane.add(isVPNLabel, 2, 5);
        pane.add(isVPN, 3, 5);
        pane.add(timezoneLabel, 0, 6);
        pane.add(timezone, 1, 6);
        pane.add(gmtOffsetLabel, 2, 6);
        pane.add(gmtOffset, 3, 6);
        pane.add(currentTimeLabel, 0, 7);
        pane.add(currentTime, 1, 7);
        pane.add(emojiLabel, 2, 7);
        pane.add(emoji, 3, 7);
        pane.add(unicodeLabel, 0, 8);
        pane.add(unicode, 1, 8);
        pane.add(currencyLabel, 2, 8);
        pane.add(currency, 3, 8);
        pane.add(autonomousSystemOrganizationLabel, 0, 9);
        pane.add(autonomousSystemOrganization, 1, 9);
        pane.add(connectionTypeLabel, 2, 9);
        pane.add(connectionType, 3, 9);
        pane.add(ispNameLabel, 0, 10);
        pane.add(ispName, 1, 10);
        pane.add(organizationLabel, 2, 10);
        pane.add(organization, 3, 10);
        pane.add(pngLabel, 0, 11);
        pane.add(png, 1, 11);
        pane.add(svgLabel, 2, 11);
        pane.add(svg, 3, 11);

        pane.add(generate, 0, 12);
        pane.add(message1, 1, 12);
        pane.add(message2, 3, 12);

        /** Set Matchtime text */
        matchTime.setFill(Color.RED);
        matchTime.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 18));
        pane.add(matchTime, 1, 13, 4, 1);

        /** Generate report */
        this.generate.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                presenter.generateReport(getData());
            };
        });

        /** Create Scene */
        this.scene = new Scene(pane);
        this.stage = new Stage();
        this.stage.setScene(this.scene);
        this.stage.setResizable(false);
        this.stage.setTitle("Loading");
        this.stage.show();
    }

    @Override
    public Scene getScene() {
        return this.scene;
    }

    @Override
    public Stage getStage() {
        return this.stage;
    }

    /** Make all textfields uneditable for copying. */
    private void setTextFieldsUneditable() {
        ipAddress.setEditable(false);
        city.setEditable(false);
        region.setEditable(false);
        regionAbbreviation.setEditable(false);
        postalCode.setEditable(false);
        country.setEditable(false);
        countryAbbreviation.setEditable(false);
        continent.setEditable(false);
        continentAbbreviation.setEditable(false);
        longitude.setEditable(false);
        latitude.setEditable(false);
        isVPN.setEditable(false);
        timezone.setEditable(false);
        gmtOffset.setEditable(false);
        currentTime.setEditable(false);
        emoji.setEditable(false);
        unicode.setEditable(false);
        currency.setEditable(false);
        autonomousSystemOrganization.setEditable(false);
        connectionType.setEditable(false);
        ispName.setEditable(false);
        organization.setEditable(false);
    }

    @Override
    public void update(IPResponse ipResponse) {
        this.data = ipResponse;

        stage.setTitle(ipResponse.getIpAddress());

        png.getEngine().load(ipResponse.getFlag().getPngURL());
        svg.getEngine().load(ipResponse.getFlag().getSvgURL());

        ipAddress.setText(ipResponse.getIpAddress());
        city.setText(ipResponse.getCity());
        region.setText(ipResponse.getRegion());
        regionAbbreviation.setText(ipResponse.getRegionIsoCode());
        if(ipResponse.getPostalCode() == null) {
            postalCode.setText("Not Available");
        } else {
            postalCode.setText(ipResponse.getPostalCode());
        }
        country.setText(ipResponse.getCountry());
        countryAbbreviation.setText(ipResponse.getCountryCode());
        continent.setText(ipResponse.getContinent());
        continentAbbreviation.setText(ipResponse.getContinentCode());
        longitude.setText(ipResponse.getLongitude() + "");
        latitude.setText(ipResponse.getLatitude() + "");
        if (ipResponse.getSecurity().getIsVPN()) {
            isVPN.setText("Yes");
        } else {
            isVPN.setText("No");
        }
        timezone.setText(ipResponse.getTimezone().getName());
        gmtOffset.setText(ipResponse.getTimezone().getGmtOffset() + "");
        currentTime.setText(ipResponse.getTimezone().getCurrentTime());
        emoji.setText(ipResponse.getFlag().getEmoji());
        unicode.setText(ipResponse.getFlag().getUnicode());
        currency.setText(ipResponse.getCurrency().getCurrencyName());
        autonomousSystemOrganization.setText(ipResponse.getConnection().getAutonomousSystemOrganization());
        connectionType.setText(ipResponse.getConnection().getConnectionType());
        ispName.setText(ipResponse.getConnection().getIspName());
        organization.setText(ipResponse.getConnection().getOrganisationName());

        /** Display matching time */
        if(ipResponse.matchTime()) {
            matchTime.setText("Matching Time");
        }
    }

    @Override
    public IPResponse getData() {
        return this.data;
    }
}
