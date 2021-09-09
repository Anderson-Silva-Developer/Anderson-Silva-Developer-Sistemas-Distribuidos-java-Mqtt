package com.anderson.mqttsub;

import clientSub.ClientSub;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import settings.SettingDefaultScreen;
import settings.SettingGuiBtn;
import settings.SettingGuiTab;
import settings.SettingsDefaultClient;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {


    @FXML
    private  Pane  panewaitconection;
    @FXML
    private Tab homeTab,videosTab,configTab,exitTab;
    @FXML
    private TabPane base;
    @FXML
    private Label titulo;
    @FXML
    private Label duracao;
    @FXML
    private Label lancamento;
    @FXML
    private MediaView mediaView;
    @FXML
    private JFXListView<JFXButton> list;
    @FXML
    private ImageView imageEditPort,imageEditAdress,imageEditTopic,imagemSave,imageEditClientId;
    @FXML
    private JFXButton  btneditClientId,btneditAdress,btneditPort,btneditTopic,btnSave,btnconection;
    @FXML
    private JFXButton btnPlay,btnPause,btnReset;
    @FXML
    private TextField fieldclientId,fieldPort,fieldAdress,fieldTopic;
    @FXML
    ImageView imageThailer;
    @FXML
    private ProgressIndicator conectionIndication;

    private double mousex=0,mousey=0;
    private Stage stage;



//    private File file;
    public static Media media;
    public static MediaPlayer mediaPlayer;
    public static MediaView mediaView_;
    public static JFXListView<JFXButton> list_;
    public static Label tituloAtual;
    public static Label lancamentoAtual;
    public static Label duracaoAtual;
    public static TabPane notificationVideo;
    public static TextField fieldAdress_;
    public static TextField fieldPort_;
    public  static TextField fieldclientId_;
    @FXML
    public static ProgressIndicator conectionIndication_;


//    public static Clientsub clientsub=new Clientsub("tcp://localhost:1883","clientsub");

    public static ClientSub clientsub_;
    public static SettingsDefaultClient settings=new SettingsDefaultClient();
    public static SettingGuiTab settingGuiTab;
    public static SettingGuiBtn settingGuiBtn;
    public static SettingDefaultScreen settingDefaultScreen;
    public static ImageView imageViewThailer;

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

               .createSettingGuiBtn();

       settingGuiBtn.styleGuiBtn(imageEditPort,
               imageEditAdress,imageEditTopic,
               imagemSave,imageEditClientId);
                settingGuiBtn.ActionBtnGui(
               panewaitconection,
               fieldclientId,fieldPort
               ,fieldAdress,fieldTopic);

       ///GUI elements
        tituloAtual=titulo;
        lancamentoAtual=lancamento;
        duracaoAtual=duracao;
        mediaView_=mediaView;
        list_=list;
        notificationVideo=base;
        imageViewThailer=imageThailer;
        fieldAdress_=fieldAdress;
        fieldPort_=fieldPort;
        fieldclientId_=fieldclientId;
        conectionIndication_=conectionIndication;
        ///
    }
    


}