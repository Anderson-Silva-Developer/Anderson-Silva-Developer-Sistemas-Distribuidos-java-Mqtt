package comunication;


import com.anderson.mqttpub.Controller;
import midiaFile.MidiaFile;
import notifications.NotificationsClass;
import org.eclipse.paho.client.mqttv3.*;

import java.io.File;
import java.net.ContentHandler;
import java.util.ArrayList;


public class Comunication {
    private MqttClient mqttClient;
    private MidiaFile midiaFile;
    public MidiaFile getMidiaFile() {
        return midiaFile;
    }

    public void setMidiaFile(MidiaFile midiaFile) {
        this.midiaFile = midiaFile;
    }

    public MqttClient getMqttClient() {
        return mqttClient;
    }

    public void setMqttClient(MqttClient mqttClient) {
        this.mqttClient = mqttClient;
    }


    private Comunication(MqttClient mqttClient,MidiaFile midiaFile) {
        this.mqttClient = mqttClient;
        this.midiaFile=midiaFile;

    }
    public static class ComunicationBuilder{
        private MqttClient mqttClient;
        private MidiaFile midiaFile;

        public ComunicationBuilder(MqttClient mqttClient,MidiaFile midiaFile) {
            this.mqttClient = mqttClient;
            this.midiaFile=midiaFile;

        }

        public ComunicationBuilder mqttClient(MqttClient mqttClient) {
            this.mqttClient = mqttClient;
            return this;
        }
        public ComunicationBuilder midiaFile(MidiaFile midiaFile) {
            this.midiaFile = midiaFile;
            return this;
        }

        public Comunication createComunication(){
            return new Comunication(mqttClient,midiaFile);
        }

    }

    public void subscribe(){
        this.mqttClient.setCallback(new MqttCallback() {
            @Override
            public void connectionLost(Throwable throwable) {
                System.out.println("connection lost");
            }

            @Override
            public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {

                 System.out.println("Message kkkkk");

            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
                System.out.println("Successful delivery");
            }
        });
    }


    public void setTopic(String topic){
        try {
            this.mqttClient.subscribe(topic);
        } catch (MqttException e) {
            System.out.println("Error subscribe topic");
        }

    }

    public  void  publishMidia(byte[] publish){

        try {
            MqttMessage message = new MqttMessage();
            message.setPayload(publish);
            message.setQos(2);
            message.setRetained(true);
            mqttClient.publish("/justnow",message);
            new NotificationsClass().notification("Notification","Sending Success",3.0);

        } catch (MqttException e) {
            new NotificationsClass().notification("Notification","No Success",3.0);
            System.out.println(e.getMessage());
        }


    }


}
