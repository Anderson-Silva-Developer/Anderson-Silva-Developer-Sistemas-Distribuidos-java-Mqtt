module com.anderson.mqttsub {
    requires javafx.base;
    requires java.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.eclipse.paho.client.mqttv3;
    requires java.desktop;
    requires com.jfoenix;
    requires org.controlsfx.controls;
    requires javafx.media;
    requires org.json;
    opens com.anderson.mqttsub to javafx.fxml;
    exports com.anderson.mqttsub;




}