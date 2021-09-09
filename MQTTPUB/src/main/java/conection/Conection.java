package conection;

import adress.Adress;
import comunication.Comunication;
import notifications.NotificationsClass;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;


public class Conection {
    private Adress adress;

    private Conection(Adress adress) {
        this.adress = adress;
    }

    public static class ConectionBuilder{
        private Adress adress;
        public ConectionBuilder(){}

        public ConectionBuilder adress(Adress adress){
            this.adress=adress;
            return this;
        }
        public Conection createConection(){
            return new Conection(adress);
        }


    }
    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public void configConection(Comunication comunication, String clientId){

        try {
            MemoryPersistence persistence = new MemoryPersistence();

            System.out.println(adress.returnAdress());
            comunication.setMqttClient(new MqttClient(adress.returnAdress(),clientId,persistence));
//            comunication.setMqttClient(new MqttClient("tcp://test.mosquitto.org:1883",clientId,persistence));

        } catch (MqttException e) {
            System.out.println("Error settings MqttClient "+e.getMessage());
        }

    }
    public boolean initConection(MqttClient mqttClientPub){
        try {
            MqttConnectOptions options = new MqttConnectOptions();
            options.setAutomaticReconnect(true);
            options.setKeepAliveInterval(10);
            mqttClientPub.connect(options);
            System.out.println("connected");
            return true;
        } catch (MqttException e) {
            System.out.println("Error connected "+e.getMessage());
            new NotificationsClass().notification("Notification Erro","No connectend ",3.0);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Conection{" +
                "adress=" + adress +
                '}';
    }
}
