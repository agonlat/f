package com.example.fluganzeigetafel.Flights.Manager;

import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Flights.Data.Flight;
import com.example.fluganzeigetafel.Flights.Utility.TimeHandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewChangeManager {

   private ToggleButton utc;
   private ToggleButton local;
   private ToggleGroup group;



    public ViewChangeManager() {
        Stage stage = new Stage();
        Image img = new Image(getClass().getResourceAsStream("/Icons/view-stacked.png"));
        stage.getIcons().add(img);
        stage.setWidth(150);
        stage.setResizable(false);
        VBox vbox = new VBox();
        Scene scene = new Scene(vbox);

        group = new ToggleGroup();
        utc = new ToggleButton("UTC TIME");
        local = new ToggleButton("LOCAL TIME");

        vbox.getChildren().addAll(utc, local);
        vbox.setAlignment(Pos.CENTER);

        // Set padding to add spacing between buttons and the frame
        vbox.setPadding(new Insets(10));

        VBox.setMargin(utc, new Insets(0,0,7,0));
        utc.setToggleGroup(group);
        local.setToggleGroup(group);

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (newValue == utc) {
                    DataInterface.getInstance().addTemporaryFlights(DataInterface.getInstance().getFlights());
                    for (Flight f : DataInterface.getInstance().getFlights()) {
                        if (!f.getItt().isBlank()) {
                            f.setItt(TimeHandler.getUTC(f.getItt()));
                        }
                        if (!f.getStt().isBlank()) {
                            f.setStt(TimeHandler.getUTC(f.getStt()));
                        }
                    }
                    DataInterface.flightsTable.refresh();
                } else if (newValue == local) {

                    for (Flight f: DataInterface.getInstance().getFlights()) {
                        if (!f.getItt().isBlank()) {
                            f.setItt(TimeHandler.getLocalTimeFromUTC(f.getItt()));
                        }
                        if (!f.getStt().isBlank()) {
                            f.setStt(TimeHandler.getLocalTimeFromUTC(f.getStt()));
                        }

                    }


                    DataInterface.flightsTable.refresh();
                }
            }
        });

        stage.setScene(scene);
        stage.setTitle("View options");
        stage.showAndWait();
    }
}
