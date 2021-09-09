package settings;

import clientSub.ClientSub;
import com.anderson.mqttsub.Controller;
import com.jfoenix.controls.JFXButton;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import notifications.NotificationsClass;
import org.controlsfx.control.Notifications;
import org.eclipse.paho.client.mqttv3.MqttException;

public class SettingGuiBtn {
    private JFXButton btneditClientId,btneditAdress,btneditPort,btneditTopic,btnSave,btnconection,btnPlay,btnPause,btnReset;

    private SettingGuiBtn(JFXButton btneditClientId, JFXButton btneditAdress, JFXButton btneditPort,
                          JFXButton btneditTopic, JFXButton btnSave, JFXButton btnconection,
                          JFXButton btnPlay, JFXButton btnPause, JFXButton btnReset) {
        this.btneditClientId = btneditClientId;
        this.btneditAdress = btneditAdress;
        this.btneditPort = btneditPort;
        this.btneditTopic = btneditTopic;
        this.btnSave = btnSave;
        this.btnconection = btnconection;
        this.btnPlay=btnPlay;
        this.btnPause=btnPause;
        this.btnReset=btnReset;
    }
    public static class SettingGuiBtnBuilder {
        private JFXButton btneditClientId,btneditAdress,btneditPort,
                btneditTopic,btnSave,btnconection,btnPlay,btnPause,btnReset;

        public SettingGuiBtnBuilder() {

        }
        public  SettingGuiBtnBuilder btneditClientId(JFXButton btneditClientId){
            this.btneditClientId=btneditClientId;
            return this;

        }
        public  SettingGuiBtnBuilder btneditAdress(JFXButton btneditAdress){
            this.btneditAdress=btneditAdress;
            return this;

        }
        public  SettingGuiBtnBuilder btneditPort(JFXButton btneditPort){
            this.btneditPort=btneditPort;
            return this;

        }

        public  SettingGuiBtnBuilder btneditTopic(JFXButton btneditTopic){
            this.btneditTopic=btneditTopic;
            return this;

        }
        public  SettingGuiBtnBuilder btnSave(JFXButton btnSave){
            this.btnSave=btnSave;
            return this;

        }
        public  SettingGuiBtnBuilder btnconection(JFXButton btnconection){
            this.btnconection=btnconection;
            return this;

        }
        public  SettingGuiBtnBuilder btnPlay(JFXButton btnPlay){
            this.btnPlay=btnPlay;
            return this;

        }
        public  SettingGuiBtnBuilder btnPause(JFXButton btnPause){
            this.btnPause=btnPause;
            return this;

        }
        public  SettingGuiBtnBuilder btnReset(JFXButton btnReset){
            this.btnReset=btnReset;
            return this;

        }



        public  SettingGuiBtn  createSettingGuiBtn(){
            return new SettingGuiBtn(btneditClientId,btneditAdress,btneditPort,
                    btneditTopic,btnSave,btnconection,btnPlay,btnPause,btnReset);

        }



    }

    public JFXButton getBtneditClientId() {
        return btneditClientId;
    }

    public void setBtneditClientId(JFXButton btneditClientId) {
        this.btneditClientId = btneditClientId;
    }

    public JFXButton getBtneditAdress() {
        return btneditAdress;
    }

    public void setBtneditAdress(JFXButton btneditAdress) {
        this.btneditAdress = btneditAdress;
    }

    public JFXButton getBtneditPort() {
        return btneditPort;
    }

    public void setBtneditPort(JFXButton btneditPort) {
        this.btneditPort = btneditPort;
    }

    public JFXButton getBtneditTopic() {
        return btneditTopic;
    }

    public void setBtneditTopic(JFXButton btneditTopic) {
        this.btneditTopic = btneditTopic;
    }

    public JFXButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(JFXButton btnSave) {
        this.btnSave = btnSave;
    }

    public JFXButton getBtnconection() {
        return btnconection;
    }

    public void setBtnconection(JFXButton btnconection) {
        this.btnconection = btnconection;
    }

    public JFXButton getBtnPlay() {
        return btnPlay;
    }

    public void setBtnPlay(JFXButton btnPlay) {
        this.btnPlay = btnPlay;
    }

    public JFXButton getBtnPause() {
        return btnPause;
    }

    public void setBtnPause(JFXButton btnPause) {
        this.btnPause = btnPause;
    }

    public JFXButton getBtnReset() {
        return btnReset;
    }

    public void setBtnReset(JFXButton btnReset) {
        this.btnReset = btnReset;
    }

    public void styleGuiBtn(ImageView imageEditPort, ImageView imageEditAdress,
                            ImageView imageEditTopic, ImageView imagemSave, ImageView imageEditClientId){
        this.btneditPort.setGraphic(imageEditPort);
        this.btneditAdress.setGraphic(imageEditAdress);
        this.btneditTopic.setGraphic(imageEditTopic);
        this.btneditClientId.setGraphic(imageEditClientId);
        this.btnSave.setGraphic(imagemSave);

    }
    public void  ActionBtnGui( Pane panewaitconection ,TextField fieldclientId, TextField fieldPort,
                              TextField fieldAdress, TextField fieldTopic){
        //
        this.btneditPort.setOnMouseClicked(mouseEvent -> {
            fieldPort.setEditable(true);
            fieldPort.setText(Controller.clientsub_.getConection().getAdress().getPortServer());

        });
        this.btneditAdress.setOnMouseClicked(mouseEvent -> {
            fieldAdress.setEditable(true);
            fieldAdress.setText(Controller.clientsub_.getConection().getAdress().getAdressServer());

        });
        this.btneditTopic.setOnMouseClicked(mouseEvent -> {
            fieldTopic.setEditable(true);
//
        });
        this.btneditClientId.setOnMouseClicked(mouseEvent -> {
            fieldclientId.setEditable(true);
            fieldclientId.setText(Controller.clientsub_.getClientId());
        });
        this.btnconection.setOnMouseClicked(mouseEvent -> {
            if(this.btnconection.getText().equals("unplugged")){
                Controller.conectionIndication_.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);
                Controller.conectionIndication_.setVisible(true);
                Controller.settings.settingsDefault();
                boolean resultConect = Controller.clientsub_ != null ? false : true;
                panewaitconection.setVisible(resultConect);
                this.btnconection.setStyle(!resultConect ? "-fx-text-fill:#00FF00" : "-fx-text-fill:#f20e02");
                this.btnconection.setText("connected");
            }else{
                if(this.btnconection.getText().equals("connected")) {
                    try {
                        Controller.conectionIndication_.setProgress(0.0);
                        Controller.conectionIndication_.setVisible(false);
                        Controller.clientsub_.getComunication().getMqttClient().disconnect();
                        panewaitconection.setVisible(true);//
                        this.btnconection.setText("unplugged");
                        this.btnconection.setStyle("-fx-text-fill:#f20e02");
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }
                }

            }



        });

        this.btnSave.setOnMouseClicked(mouseEvent -> {
            try {
                if (!fieldclientId.getText().equals("") && !fieldAdress.getText().equals("") && !fieldPort.getText().equals("")) {

                Controller.clientsub_.setClientId(fieldclientId.getText());
                Controller.clientsub_.getConection().getAdress().setPortServer(fieldPort.getText());
                Controller.clientsub_.getConection().getAdress().setAdressServer(fieldAdress.getText());

                    if(!fieldTopic.getText().equals("")){
                        Controller.clientsub_.getComunication().setTopic(fieldTopic.getText());
                    }
                    if (Controller.clientsub_.getComunication().getMqttClient().isConnected()){
                        Controller.clientsub_.getComunication().getMqttClient().disconnect();
                    }
                Controller.settings.settingsDefault();

                    new NotificationsClass().notification("Notification Save", "Save Input ", 2.0);

                } else {
                    new NotificationsClass().notification("Notification Error", "Not Input ", 2.0);
                }
            }catch (Exception e){
                new NotificationsClass().notification("Notification Error", "Input Error", 2.0);


            }

        });
        this.btnPlay.setOnMouseClicked(mouseEvent -> {
            if(Controller.mediaPlayer!=null) {
                Controller.mediaPlayer.play();
            }
        });
        this.btnPause.setOnMouseClicked(mouseEvent -> {
            if(Controller.mediaPlayer!=null) {
                Controller.mediaPlayer.pause();
            }

        });
        this.btnReset.setOnMouseClicked(mouseEvent -> {
            if(Controller.mediaPlayer!=null) {
                if (Controller.mediaPlayer.getStatus() != MediaPlayer.Status.READY) {
                    Controller.mediaPlayer.seek(Duration.seconds(0.0));
                }
            }


        });





    }
}
