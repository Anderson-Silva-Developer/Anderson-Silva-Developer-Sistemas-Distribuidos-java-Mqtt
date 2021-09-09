module com.anderson.mqttpub {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires java.base;
    requires org.eclipse.paho.client.mqttv3;
    requires javafx.media;
    requires commons.lang3;
    requires org.apache.commons.io;
    requires org.json;
    requires com.jfoenix;
    requires org.controlsfx.controls;
    opens com.anderson.mqttpub to javafx.fxml;
    exports com.anderson.mqttpub;
}