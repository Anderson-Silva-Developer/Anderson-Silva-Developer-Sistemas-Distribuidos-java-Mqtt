package settings;

import javafx.scene.Node;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SettingDefaultScreen {
    private double mousex=0,mousey=0;
    private Stage stage;
    private TabPane screen;

    private SettingDefaultScreen(double mousex, double mousey, Stage stage, TabPane screen) {
        this.mousex = mousex;
        this.mousey = mousey;
        this.stage = stage;
        this.screen = screen;
    }
    public static class  SettingDefaultScreenBuilder{
        private double mousex=0,mousey=0;
        private Stage stage;
        private TabPane screen;
        public SettingDefaultScreenBuilder stage (Stage stage){
            this.stage=stage;
            return this;

        }
        public SettingDefaultScreenBuilder Screen (TabPane screen){
            this.screen=screen;
            return this;

        }
        public SettingDefaultScreenBuilder mousex (double mousex){
            this.mousex=mousex;
            return this;

        }
        public SettingDefaultScreenBuilder mousey (double mousey){
            this.mousey=mousey;
            return this;

        }
        public SettingDefaultScreen createSettingDefaultScreen(){
            return  new SettingDefaultScreen(mousex,mousey,stage,screen);
        }


    }

    public void settingScreen() {
        this.screen.setOnMousePressed(mouseEvent -> {
            this.mousex=mouseEvent.getSceneX();
            this.mousey=mouseEvent.getSceneY();
        });
        this.screen.setOnMouseDragged(mouseEvent -> {
            stage=(Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
            stage.setX(mouseEvent.getScreenX()-this.mousex);
            stage.setY(mouseEvent.getScreenY()-this.mousey);

        });
    }
}
