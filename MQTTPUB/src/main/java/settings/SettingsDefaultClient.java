package settings;

import adress.Adress;
import clientPub.ClientPub;
import com.anderson.mqttpub.Controller;
import comunication.Comunication;
import conection.Conection;
import midiaFile.MidiaFile;
import org.eclipse.paho.client.mqttv3.MqttClient;

public   class SettingsDefaultClient {
    public SettingsDefaultClient() {
    }

    public ClientPub settingsDefault(){

        MqttClient mqttClient = null;
        Adress adress=new Adress.AdressBuilder()
                .portServer(Controller.fieldPort_.getText().equals("")?"1883":Controller.fieldPort_.getText())
                .adressServer(Controller.fieldAdress_.getText().equals("")?"localhost":Controller.fieldAdress_.getText())
                .createAdress();

        Conection conection=new Conection.ConectionBuilder().adress(adress).createConection();

        Comunication comunication=new Comunication.ComunicationBuilder(mqttClient,new MidiaFile())
                .mqttClient(mqttClient)
                .createComunication();

        Controller.clientpub_
                =new ClientPub.ClientSubBuilder(
                Controller.fieldclientId_.getText().equals("")?"clientPub":Controller.fieldclientId_.getText()
                ,conection,comunication)
                .clientId(Controller.fieldclientId_.getText().equals("")?"clientPub":Controller.fieldclientId_.getText())
                .conection(conection)
                .comunication(comunication)
                .createClientPub();

        Controller.clientpub_.getConection()
                .configConection(Controller.clientpub_.getComunication(),Controller.clientpub_.getClientId());


        boolean isConect=Controller.clientpub_.getConection().initConection(Controller.clientpub_.getComunication().getMqttClient());
        if(isConect) {
            Controller.clientpub_.getComunication().subscribe();
            return Controller.clientpub_;
        }else{
            return null;
        }



    }



}
