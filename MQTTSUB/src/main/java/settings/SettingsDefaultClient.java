package settings;

import adress.Adress;
import clientSub.ClientSub;
import com.anderson.mqttsub.Controller;
import comunication.Comunication;
import conection.Conection;
import midiaFile.MidiaFile;
import org.eclipse.paho.client.mqttv3.MqttClient;

public   class SettingsDefaultClient {
    public SettingsDefaultClient() {
    }

    public ClientSub settingsDefault(){

        MqttClient mqttClient = null;
        Adress adress=new Adress.AdressBuilder()
                .portServer(Controller.fieldPort_.getText().equals("")?"1883":Controller.fieldPort_.getText())
                .adressServer(Controller.fieldAdress_.getText().equals("")?"localhost":Controller.fieldAdress_.getText())
                .createAdress();

        Conection conection=new Conection.ConectionBuilder().adress(adress).createConection();

        Comunication comunication=new Comunication.ComunicationBuilder(mqttClient,new MidiaFile())
                .mqttClient(mqttClient)
                .createComunication();

        Controller.clientsub_
                =new ClientSub.ClientSubBuilder(
                 Controller.fieldclientId_.getText().equals("")?"clientSub":Controller.fieldclientId_.getText(),conection,comunication)
                .clientId(Controller.fieldclientId_.getText().equals("")?"clientSub":Controller.fieldclientId_.getText())
                .conection(conection)
                .comunication(comunication)
                .createClientSub();

        Controller.clientsub_.getConection()
                .configConection(Controller.clientsub_.getComunication(),Controller.clientsub_.getClientId());

        boolean isConect=Controller.clientsub_.getConection().initConection(Controller.clientsub_.getComunication().getMqttClient());
        if(isConect) {
            Controller.clientsub_.getComunication().subscribe();
            Controller.clientsub_.getComunication().setTopic("/justnow");

            return Controller.clientsub_;
        }else{
            return null;
        }



    }



}
