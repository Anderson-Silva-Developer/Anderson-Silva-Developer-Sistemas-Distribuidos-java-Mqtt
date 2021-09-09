package midiaFile;

import com.anderson.mqttpub.Controller;
import com.anderson.mqttpub.Main;
import convert.Convert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import notifications.NotificationsClass;
import org.json.JSONObject;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.Scanner;

public class MidiaFile {

    Convert convert=new Convert();
//    files[0]  video
    //files[1] Image
    private static  File[] files=new File[2];


    public MidiaFile() {

    }

    public void createFileVideo(File file){
                    try {
                        Media media=new Media(file.toURI().toString());
                        if(Controller.mediaPlayer!=null) {
                            Controller.mediaPlayer.stop();
                        }
                            Controller.mediaPlayer = new MediaPlayer(media);
                            Controller.mediaViewUploandVideo.setMediaPlayer(Controller.mediaPlayer);
                            files[0]=file;
                    }catch (Exception e){
                        System.out.println("Errro uploand video"+e.getMessage());

                    }
    }
    public void createFileImage(File file){
        try {
         Controller.imageViewUploandImage.setImage(new Image(file.toURI().toString()));
            files[1]=file;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void createFileTxt(File file){
        try {
            Scanner  in = new Scanner(new FileReader(file.getAbsoluteFile()));
            Controller.arrayListInfo.get(0).setText(searchContent(in,"justnowTitle:"));
            Controller.arrayListInfo.get(1).setText(searchContent(in,"justnowLaunch:"));
            Controller.arrayListInfo.get(2).setText(searchContent(in,"justnowDuration:"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String searchContent(Scanner  in , String search){
        try {

            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.contains(search)) {
                    String[] newline=line.split(search);
                    System.out.println(newline[0]);
                    return newline[1];
                }
                if(line==null){
                    continue;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

       return "Undefined";
    }


    public  void  convertTopublish(){
        JSONObject jsonmidia=new JSONObject();

        try {

            if(files[0]!=null && files[1]!=null) {
                for(TextField field:Controller.arrayListInfo) {
                    field.setText(field.getText().equals("")?"Undefined":field.getText());
                }

            byte[] bytesVideo =convert.convertPathNametoByte(files[0].getAbsolutePath());
            byte[] bytesImage = convert.convertPathNametoByte(files[1].getAbsolutePath());
            String strVideo = Base64.getEncoder().encodeToString(bytesVideo);
            String strImage = Base64.getEncoder().encodeToString(bytesImage);
            jsonmidia.put("video",strVideo);
            jsonmidia.put("Image",strImage);
            jsonmidia.put("title",Controller.arrayListInfo.get(0).getText());
            jsonmidia.put("launch",Controller.arrayListInfo.get(1).getText());
            jsonmidia.put("duration",Controller.arrayListInfo.get(2).getText());
            byte[] bytesjson = jsonmidia.toString().getBytes("UTF-8");
            //to comunication mqtt
            Controller.clientpub_.getComunication().publishMidia(bytesjson);

            //clear publish
                clearToDefaulPublishMidia();

            }else{
                new NotificationsClass().notification("Notification no file","No  files",2.0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public  void clearToDefaulPublishMidia(){

        try {
            files[0]=null;
            files[1]=null;
            Controller.mediaViewUploandVideo.setMediaPlayer(null);
            Controller.mediaPlayer=null;
            for(TextField field:Controller.arrayListInfo) {
                field.setText("");
            }
            Controller.imageViewUploandImage.setImage(new Image(
                    Main.class.getResource("/img/defaultImage.jpg").toURI().toString()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


    }












}
