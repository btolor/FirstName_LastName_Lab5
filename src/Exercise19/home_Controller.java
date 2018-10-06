package Exercise19;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//The implements Initializable is used to enable an initializer to run code as soon as the view loads...
public class home_Controller implements Initializable {

    //home_scene.fxml controls...
    @FXML
    private TextArea discountsTextArea = new TextArea();

    //Methods for home_scene.fxml...

    /**The initialize method will run its code as soon as the view loads
     * populating the text-are with all of the available discounts...
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        discountsTextArea.appendText("30% Discount for all senior citizens.\n\n");
        discountsTextArea.appendText("15% Discount if membership is bought and \npaid for 12 or months in advance.\n\n");
        discountsTextArea.appendText("20% Discount on each personal training \nsession when 5 or more sessions are \npurchased.");
    }

    /**
     * This method will change the home_scene to the menu_scene when it is called.
     * In this method the ActionEvent parameter reads from the button to get the scene and the
     * throws IOException is set in place because it is reading from the file system.The Parent
     * menu is setup the same as the Parent root in the fitnessCenterMembershipCost class but
     * with menu_scene.fxml as its resource. The new scene and stage is then created.
     */
    public void sceneSwitch (ActionEvent event) throws IOException {

        Parent menu = FXMLLoader.load(getClass().getResource("menu_scene.fxml"));
        Scene menuScene = new Scene(menu);
        //This line gets the stage info and cast it as a stage called window...
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(menuScene);
        window.setTitle("Membership Options");
        window.setResizable(false);
        window.show();
    }






}
