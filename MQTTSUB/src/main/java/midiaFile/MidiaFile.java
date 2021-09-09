package midiaFile;

import com.anderson.mqttsub.Controller;
import com.jfoenix.controls.JFXButton;
import convert.Convert;
import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import notifications.NotificationsClass;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;

import java.awt.*;
import java.io.File;
import java.io.InputStream;
import java.util.Random;
import javafx.scene.image.Image;

public class MidiaFile {

    Convert convert=new Convert();
    static  boolean notification=false;



    public MidiaFile() {

    }

    public void createFileVideo(MqttMessage mqttMessage){

        Platform.runLater(new Runnable() {
                @Override
                public void run() {

                    try {
                        double nameFile=new Random().nextDouble() * 100;
                        JSONObject jsonmsg =convert.convertByteToJson(mqttMessage.getPayload());
                        byte[] videoFilebytes=convert.convertJsonToByte(jsonmsg,"video");
                        byte[] imageFilebytes=convert.convertJsonToByte(jsonmsg,"Image");

                        //create file to temp video
                        File fileVideo = File.createTempFile("meu-arquivo-temporario-video ", ".tmp");
                        InputStream inputStreamVideo=convert.createInputStream(videoFilebytes);
                        convert.createFilecopy(inputStreamVideo,fileVideo);
                        Media mediaVideo=new Media(fileVideo.toURI().toString());
                        //create file to temp image
                        File fileImage = File.createTempFile("meu-arquivo-temporario-image", ".tmp");
                        InputStream inputStreamImage=convert.createInputStream(imageFilebytes);
                        convert.createFilecopy(inputStreamImage,fileImage);
                        Image imageThailer=new Image(fileImage.toURI().toString());

                        ///

                        JFXButton btn=new JFXButton(jsonmsg.get("title").toString());

                        btn.setStyle("-fx-text-fill: #888a12");


                        btn.setOnMouseClicked(mouseEvent -> {
                            if(Controller.mediaPlayer!=null) {
                                Controller.mediaPlayer.stop();
                            }

                                Controller.mediaPlayer = new MediaPlayer(mediaVideo);
                                Controller.imageViewThailer.setImage(imageThailer);
                                Controller.mediaView_.setMediaPlayer(Controller.mediaPlayer);
                                Controller.tituloAtual.setText(jsonmsg.get("title").toString());
                                Controller.lancamentoAtual.setText(jsonmsg.get("launch").toString());
                                Controller.duracaoAtual.setText(jsonmsg.get("duration").toString());


                        });

                        btn.setPrefWidth(160);
                        btn.setPrefHeight(30);
                        fileVideo.deleteOnExit();


                        Controller.list_.getItems().add(btn);


                        new NotificationsClass().notification("Notification","nova midia",1.0);
                        Controller.notificationVideo.getSelectionModel().select(1);

                    }catch (Exception e){
                        e.printStackTrace();
                     new NotificationsClass().notification("Notification","Error message",2.0);
                    }
                }
            });

    }


}
