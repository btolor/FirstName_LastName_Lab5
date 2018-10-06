package Exercise19;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class menu_Controller {

    /**
     * Theses are the gui controls...
     * */
    @FXML
    private Button calculate_btn = new Button();
    @FXML
    private Button clear_btn = new Button();
    @FXML
    private Label requiredField1 = new Label();
    @FXML
    private Label requiredField2 = new Label();
    @FXML
    private Label requiredField3 = new Label();
    @FXML
    private Label requiredFields = new Label();
    @FXML
    private TextField monthsPaid = new TextField();
    @FXML
    private TextField scTextField = new TextField();
    @FXML
    private TextArea summaryTArea = new TextArea();
    @FXML
    private TextField trainingSession = new TextField();


    //Methods for menu_scene.fxml...
    //Buttons methods...
    /**
     * This method will change the menu_scene back to the home_scene hen it is called.
     * In this method the ActionEvent parameter reads from the button to get the scene and the
     * throws IOException is set in place because it is reading from the file system.The Parent
     * menu is setup the same as the Parent root in the fitnessCenterMembershipCost class but
     * with menu_scene.fxml as its resource. The new scene and stage is then created.
     **/
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

    /**
     * This method will terminate the java program when the Exit
     * btn is clicked...
     */
    public void exit(){
        System.exit(1);
    }

    /**
     * This method is used to reset the text-fields and radio btn toggle group...
     * */
    public void clear(){
        monthsPaid.setText("");
        trainingSession.setText("");
        scTextField.setText("");
        summaryTArea.setText("");
    }
    //Validation methods...
    /**
     * This is a validation method for the months paid in
     * advance and training sessions text-fields...
     * */
    public boolean textFieldValidation(TextField test, String score ){
        /**The try catch method checks to see if the test-field can be
        *parsed into an int and if so it returns true...
         */
        try {
            int valid = Integer.parseInt(test.getText());
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    /**
     * This validation methods checks to see if the senior sitizen text-field is empty.
     * It returns true if the text-field has text and false if the tex-field is empty...
     * */
    public boolean seniorCitizen(){
        if(scTextField.getText().isEmpty()){
            return false;
        }else {
            return true;
        }
    }



}
