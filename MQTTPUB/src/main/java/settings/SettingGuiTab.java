package settings;

import com.anderson.mqttpub.Main;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import notifications.NotificationsClass;
import org.controlsfx.control.Notifications;

public class SettingGuiTab {
    private Tab homeTab,videosTab,configTab,exitTab;

    private SettingGuiTab(Tab homeTab, Tab videosTab, Tab configTab, Tab exitTab) {
        this.homeTab = homeTab;
        this.videosTab = videosTab;
        this.configTab = configTab;
        this.exitTab = exitTab;
    }
    public static class SettingGuiTabBuilder {
        private Tab homeTab,videosTab,configTab,exitTab;

        public SettingGuiTabBuilder() {

        }
        public SettingGuiTabBuilder homeTab(Tab homeTab){
            this.homeTab=homeTab;
            return this;

        }
        public SettingGuiTabBuilder videosTab(Tab videosTab){
            this.videosTab=videosTab;
            return this;

        }
        public SettingGuiTabBuilder configTab(Tab configTab){
            this.configTab=configTab;
            return this;

        }
        public SettingGuiTabBuilder exitTab(Tab exitTab){
            this.exitTab=exitTab;
            return this;

        }
        public SettingGuiTab createSettingGuiTab(){
            return new SettingGuiTab(homeTab,videosTab,configTab,exitTab);
        }


    }

    public Tab getHomeTab() {
        return homeTab;
    }

    public void setHomeTab(Tab homeTab) {
        this.homeTab = homeTab;
    }

    public Tab getVideosTab() {
        return videosTab;
    }

    public void setVideosTab(Tab videosTab) {
        this.videosTab = videosTab;
    }

    public Tab getConfigTab() {
        return configTab;
    }

    public void setConfigTab(Tab configTab) {
        this.configTab = configTab;
    }

    public Tab getExitTab() {
        return exitTab;
    }

    public void setExitTab(Tab exitTab) {
        this.exitTab = exitTab;
    }

    public void  ActionTabGui(){

        homeTab.setOnSelectionChanged(event -> {

            homeTab.setStyle("-fx-background-color:#888a12");
            videosTab.setStyle("-fx-background-color:#DCDCDC");
            configTab.setStyle("-fx-background-color:#DCDCDC");

        });
        videosTab.setOnSelectionChanged(event -> {
            homeTab.setStyle("-fx-background-color:#DCDCDC");
            videosTab.setStyle("-fx-background-color:#888a12");
            configTab.setStyle("-fx-background-color:#DCDCDC");

        });
        configTab.setOnSelectionChanged(event -> {
            homeTab.setStyle("-fx-background-color:#DCDCDC");
            videosTab.setStyle("-fx-background-color:#DCDCDC");
            configTab.setStyle("-fx-background-color:#888a12");

        });
        exitTab.setOnSelectionChanged(event -> {

            System.exit(0);

        });


    }
    public void styleGuiTab(){

        homeTab.setStyle("-fx-background-color:#DCDCDC");
        videosTab.setStyle("-fx-background-color:#DCDCDC");
        configTab.setStyle("-fx-background-color:#DCDCDC");
        exitTab.setStyle("-fx-background-color:#DCDCDC");
        homeTab.setGraphic(buildImage(String.valueOf(Main.class.getResource("/img/Home.png"))));
        videosTab.setGraphic(buildImage(String.valueOf(Main.class.getResource("/img/play.png"))));
        configTab.setGraphic(buildImage(String.valueOf(Main.class.getResource("/img/config.png"))));
        exitTab.setGraphic(buildImage(String.valueOf(Main.class.getResource("/img/exit.png"))));


    }


    private static ImageView buildImage(String imgPatch) {
        Image i = new Image(imgPatch);
        ImageView imageView = new ImageView();
        imageView.setFitHeight(30);
        imageView.setFitWidth(30);
        imageView.setImage(i);
        return imageView;
    }


}
