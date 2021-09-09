package notifications;

import com.anderson.mqttpub.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class NotificationsClass {
    public NotificationsClass() {
    }

    public void notification(String title, String text, double duracao){
        Notifications notification= Notifications.create()
                .title(title)
                .text(text)
                .graphic(null)
                .hideAfter(Duration.seconds(duracao))
                .position(Pos.CENTER)
                .onAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        System.out.println("notificação");
                    }
                });
        notification.darkStyle();
        notification.showConfirm();
    }
}
