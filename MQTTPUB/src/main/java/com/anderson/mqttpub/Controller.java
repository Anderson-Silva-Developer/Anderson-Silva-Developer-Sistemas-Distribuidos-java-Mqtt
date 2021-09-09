package com.anderson.mqttpub;


import clientPub.ClientPub;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import org.eclipse.paho.client.mqttv3.MqttClient;
import settings.SettingDefaultScreen;
import settings.SettingGuiBtn;
import settings.SettingGuiTab;
import settings.SettingsDefaultClient;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    private ImageView imageViewImage;
    @FXML
    private  Pane  panewaitconection;
    @FXML
    private Tab homeTab,videosTab,configTab,exitTab;
    @FXML
    private TabPane base;
    @FXML
    private MediaView mediaView;
    @FXML
    private ImageView imageEditPort,imageEditAdress,imageEditTopic,imagemSave,imageEditClientId,imageUploand;
    @FXML
    private JFXButton  btneditClientId,btneditAdress,btneditPort,btneditTopic,btnSave,btnconection;
    @FXML
    private JFXButton btnPlay,btnPause,btnReset,btnUploandVideo,btnpublish;
    @FXML
    private TextField fieldclientId,fieldPort,fieldAdress,fieldTopic;
    @FXML
    private ProgressIndicator conectionIndication;

    @FXML
    private  TextField title,launch,duration;
    private double mousex=0,mousey=0;
    private Stage stage;



    //    private File file;
    public static Media media;
    public static MediaPlayer mediaPlayer;
    public static MediaView mediaViewUploandVideo;
    public static ImageView imageViewUploandImage;
    public static TextField title_,launch_,duration_;




//    public static Clientsub clientsub=new Clientsub("tcp://localhost:1883","clientsub");

    public static ClientPub clientpub_;
    public static SettingsDefaultClient settings=new SettingsDefaultClient();
    public static SettingGuiTab settingGuiTab;
    public static SettingGuiBtn settingGuiBtn;
    public static SettingDefaultScreen settingDefaultScreen;
    public static ArrayList<TextField> arrayListInfo=new ArrayList<>();
    public static  TextField fieldAdress_;
    public  static TextField fieldPort_;
    public static  TextField fieldclientId_;
    public static ProgressIndicator conectionIndication_;


//public static Clientsub clientsub=new Clientsub("tcp://test.mosquitto.org:1883","clientsub");

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle){


        settingDefaultScreen=new SettingDefaultScreen.SettingDefaultScreenBuilder()
                .mousex(this.mousex)
                .mousey(this.mousey)
                .Screen(this.base)
                .stage(this.stage)
                .createSettingDefaultScreen();
        settingDefaultScreen.settingScreen();

        settingGuiTab=new SettingGuiTab.SettingGuiTabBuilder()
                .homeTab(this.homeTab)
                .videosTab(this.videosTab)
                .configTab(this.configTab)
                .exitTab(this.exitTab)
                .createSettingGuiTab();
        settingGuiTab.styleGuiTab();
        settingGuiTab.ActionTabGui();

        settingGuiBtn=new SettingGuiBtn.SettingGuiBtnBuilder()
                .btneditClientId(this.btneditClientId)
                .btneditAdress(this.btneditAdress)
                .btneditPort(this.btneditPort)
                .btneditTopic(this.btneditTopic)
                .btnSave(this.btnSave)
                .btnconection(this.btnconection)
                .btnPlay(this.btnPlay)
                .btnPause(this.btnPause)
                .btnReset(this.btnReset)
                .btnUploandVideo(this.btnUploandVideo)
                .btnpublish(this.btnpublish)
                .createSettingGuiBtn();

        settingGuiBtn.styleGuiBtn(imageEditPort,
                imageEditAdress,imageEditTopic,
                imagemSave,imageEditClientId,imageUploand);
        settingGuiBtn.ActionBtnGui(
                panewaitconection,
                fieldclientId,fieldPort
                ,fieldAdress,fieldTopic);

        ///GUI elements

        mediaViewUploandVideo =mediaView;
        imageViewUploandImage=imageViewImage;
        arrayListInfo.add(this.title);
        arrayListInfo.add(this.launch);
        arrayListInfo.add(this.duration);
        fieldAdress_=fieldAdress;
        fieldPort_=fieldPort;
        fieldclientId_=fieldclientId;
        conectionIndication_=conectionIndication;


        ///
    }


}