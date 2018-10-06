package Exercise19;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class menu_Controller {

    //Methods for menu_scene.fxml...

    /**
     * This method will change the menu_scene back to the home_scene hen it is called.
     * In this method the ActionEvent parameter reads from the button to get the scene and the
     * throws IOException is set in place because it is reading from the file system.The Parent
     * menu is setup the same as the Parent root in the fitnessCenterMembershipCost class but
     * with menu_scene.fxml as its resource. The new scene and stage is then created.
     */
    public void sceneSwitch (ActionEvent event) throws IOException {

        Parent menu = FXMLLoader.load(getClass().getResource("home_scene.fxml"));
        Scene menuScene = new Scene(menu);
        //This line gets the stage info and cast it as a stage called window...
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(menuScene);
        window.setTitle("Fitness Center");
        window.setResizable(false);
        window.show();
    }

}
