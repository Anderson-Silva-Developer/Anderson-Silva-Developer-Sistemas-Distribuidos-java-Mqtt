package comunication;


import midiaFile.MidiaFile;
import org.eclipse.paho.client.mqttv3.*;


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

             createFile(topic,mqttMessage);
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
                System.out.println("Successful delivery");
            }
        });
    }
    public void createFile(String topic ,MqttMessage mqttMessage){

        if(topic.equals("/justnow")) {
            this.midiaFile.createFileVideo(mqttMessage);
        }


    }


    public void setTopic(String topic){
        try {
            this.mqttClient.subscribe(topic,2);
        } catch (MqttException e) {
            System.out.println("Error subscribe topic");
        }

    }

}
