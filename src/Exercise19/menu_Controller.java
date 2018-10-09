package Exercise19;
//Imports...
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.text.DecimalFormat;

public class menu_Controller {

    //Variables...
    boolean months, twelveMonthDiscount,senior ,seniorDiscount, training, trainingSessionDiscount = false;
    double membershipCost = 500.00;
    double trainingSessionCost = 100.00;
    double totalCost = 0;
    DecimalFormat df = new DecimalFormat(".00");
    //The gui controls...
    @FXML
    private Button back_btn = new Button();
    @FXML
    private Button exit_btn = new Button();
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

    /**
     * These 8 methods are used to change the buttons color when hovered
     * */
    public void calculate_btnHover(){
        calculate_btn.setStyle("-fx-background-color: #33cc33; -fx-border-style: solid; -fx-border-color: #33cc33; -fx-text-fill: #6600ff; -fx-border-radius: 5");
    }
    public void calculate_btnUnHover(){
        calculate_btn.setStyle("-fx-background-color: transparent; -fx-border-style: solid; -fx-border-color: red; -fx-text-fill: red; -fx-border-radius: 5");
    }
    public void clear_btnHover(){
        clear_btn.setStyle("-fx-background-color: red; -fx-border-color: red; -fx-border-radius: 5; -fx-text-fill: #6600ff; -fx-border-style: solid");
    }
    public void btn_ClearUnHover(){
        clear_btn.setStyle("-fx-background-color: transparent; -fx-border-color: red; -fx-border-radius: 5; -fx-text-fill: red; -fx-border-style: solid");
    }
    public void back_btnHover(){
        back_btn.setStyle("-fx-background-color: red; -fx-border-color: red; -fx-border-radius: 5; -fx-text-fill: #6600ff; -fx-border-style: solid");
    }
    public void back_btnUnHover(){
        back_btn.setStyle("-fx-background-color: transparent; -fx-border-color: red; -fx-border-radius: 5; -fx-border-style: solid; -fx-text-fill: white");
    }
    public void exitHover(){
        exit_btn.setStyle("-fx-background-color: red; -fx-border-color: red; -fx-border-radius: 5; -fx-text-fill: #6600ff; -fx-border-style: solid");
    }
    public void exitUnHover(){
        exit_btn.setStyle("-fx-background-color: transparent; -fx-border-color: red; -fx-border-radius: 5; -fx-border-style: solid; -fx-text-fill: white");
    }

    /**
     * This method will change the menu_scene back to the home_scene hen it is called.
     * In this method the ActionEvent parameter reads from the button to get the scene and the
     * throws IOException is set in place because it is reading from the file system.The Parent
     * menu is setup the same as the Parent root in the fitnessCenterMembershipCost class but
     * with menu_scene.fxml as its resource. The new scene and stage is then created.
     **/
    @FXML
    private void sceneSwitch (ActionEvent event) throws IOException {

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
    @FXML
    private void exit(){
        System.exit(1);
    }

    /**
     * This method is used to reset the text-fields and radio btn toggle group...
     * */
    @FXML
    private void clear(){
        monthsPaid.setText("");
        trainingSession.setText("");
        scTextField.setText("");
        summaryTArea.setText("");
        seniorDiscount = false;
        requiredField3.setVisible(false);
        requiredField3.setText("Required field!");
        requiredField1.setVisible(false);
        requiredField2.setVisible(false);
        requiredFields.setVisible(false);
    }


    //Validation method..
    /**
     * This is a validation method for the months paid in
     * advance and training sessions text-fields...
     * */
    private boolean textFieldValidation(TextField a){
        /**The try catch method checks to see if the test-field can be
        *parsed into an int and if so it returns true...
         */
        try {
            int valid = Integer.parseInt(a.getText());
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }



    /**
     * The required methods to get the information
     * needed to calculate the cost and to calculate
     * the cost.
     * */
    /**
     * The twelve months discount method takes in 4 parameters to see if the
     * months paid text-field input is a integer as well as acting as
     * a validator for the text-field and a trigger for validation error messages.
     * The method then returns a boolean value depending on users input of
     * an integer or not...
     * */
    private boolean twelveMonthsDiscount(TextField a, boolean b, Label c, Label d){
        b = false;
        c.setVisible(false);
        d.setVisible(false);
        if(textFieldValidation(a)){
            int months = Integer.parseInt(a.getText());
            if(months >= 12){
                b = true;
            }else {
                b = false;
            }
        }else if(a.getText().isEmpty()){
            c.setVisible(true);
            d.setVisible(true);
        }else {
            b = false;
            c.setText("Invalid Entry!");
            c.setVisible(true);
        }
        return  b;
    }

    /**
     * The training session discount method takes in 4 parameters to see if the
     * training session text-field input is a integer as well as acting as
     * a validator for the text-field and a trigger for validation error messages.
     * The method then returns a boolean value depending on users input of
     * an integer or not...
     * */
    private boolean trainingSessionDiscount(TextField a, boolean b, Label c, Label d){
        b = false;
        c.setVisible(false);
        d.setVisible(false);
        if(textFieldValidation(a)){
            int train = Integer.parseInt(a.getText());
            if(train >= 5){
                b = true;
            }else {
                b = false;
            }
        }else if(a.getText().isEmpty()){
            c.setVisible(true);
            d.setVisible(true);
        }else {
            b = false;
            c.setText("Invalid Entry!");
            c.setVisible(true);
        }
        return  b;
    }

    /**
     * The senior discount method takes in 4 parameters to see if the
     * senior citizen text-field equals yes or no as well as acting as
     * a validator for the text-field and a trigger for validation error messages.
     * The method then returns a boolean value depending on users input of
     * yes or no...
     * */
    private boolean seniorDiscount (Label a, TextField b, boolean c, Label d){
        a.setVisible(false);
        d.setVisible(false);
        if(b.getText().equalsIgnoreCase("Yes") || b.getText().equalsIgnoreCase("Y")){
            c = true;
            a.setVisible(false);

        }else if(b.getText().equalsIgnoreCase("No") || b.getText().equalsIgnoreCase("N")){
            c = false;
            a.setVisible(false);
        }else if(b.getText().isEmpty()){
            a.setVisible(true);
            d.setVisible(true);
        } else {
            a.setText("Invalid Entry!");
            a.setVisible(true);
        }
        return c;
    }
    /**
     * The discount method uses all the discount methods to assign the
     * correct value to its appropriate variable...
     * */
    public void discounts(){

        twelveMonthDiscount = twelveMonthsDiscount(monthsPaid, months, requiredField1, requiredFields);
        System.out.println(twelveMonthDiscount);
        trainingSessionDiscount = trainingSessionDiscount(trainingSession, training, requiredField2, requiredFields);
        System.out.println(trainingSessionDiscount);
        seniorDiscount = seniorDiscount(requiredField3, scTextField, senior, requiredFields);
        System.out.println(seniorDiscount);
    }

    /**
     * The total method calculates the the membership total and displays it
     * in the summary text-area. It uses an if statement to validate the text-field
     * inputs to avoid exception handling errors and also uses a few nested if statements
     * to calculate the totals and display them in the text-area*/
    @FXML
    private void totals ( ){

        if(textFieldValidation(monthsPaid) && textFieldValidation(trainingSession)){
            discounts();
            double memberDiscount = 0.15;
            double trainDiscount = 0.20;
            double scDiscount = 0.30;
            double monthsCost = 0;
            double trainingCost = 0;
            String tDiscount ="";
            String tCost ="";
            String a = monthsPaid.getText();
            String b = trainingSession.getText();
            int months = Integer.parseInt(a);
            int sessions = Integer.parseInt(b);
            if(requiredField1.isVisible() || requiredField2.isVisible() || requiredField3.isVisible()){
                requiredFields.setText("Complete all fields with the required input...");
                requiredFields.setVisible(true);
            }else {
                if(twelveMonthDiscount == true || trainingSessionDiscount == true || seniorDiscount == true){


                    if(trainingSessionDiscount == true){
                        trainingCost = (trainingSessionCost -(trainingSessionCost * trainDiscount)) * sessions;
                        tDiscount = "@"+ sessions + " + 20% Discount ea.  $" + df.format(trainingCost) + "\n\n";
                    }else {
                        trainingCost = trainingSessionCost  * sessions;
                        tDiscount = "@"+ sessions + "  $" + df.format(trainingCost) + "\n\n";
                    }

                    monthsCost = membershipCost * months;
                    trainingCost = trainingSessionCost * sessions;
                    totalCost = monthsCost + trainingCost;

                    if(twelveMonthDiscount == true && seniorDiscount == true){
                        totalCost = (totalCost - (totalCost * (memberDiscount + scDiscount)));
                        tCost = "15% 12 Months Paid In Advance Discount Added.\n30% Senior Citizen Discount Added\nTotal Cost:  $" + df.format(totalCost);
                    }else if(twelveMonthDiscount == true){
                        totalCost = (totalCost - (totalCost * memberDiscount));
                        tCost = "15% 12 Months Paid In Advance Discount Added.\nTotal Cost:  $" + df.format(totalCost);
                    }else if(seniorDiscount == true) {
                        totalCost = (totalCost - (totalCost * scDiscount));
                        tCost = "30% Senior Citizen Discount Added\nTotal Cost:  $" + df.format(totalCost);
                    }else {
                        tCost = "Total Cost:  $" + df.format(totalCost);
                    }

                    summaryTArea.appendText("Months paid in advance:\n");
                    summaryTArea.appendText("@"+ months + " $" + df.format(monthsCost) + "\n\n" );
                    summaryTArea.appendText("Training Sessions:\n");
                    summaryTArea.appendText(tDiscount);
                    summaryTArea.appendText(tCost);
                }else{
                    monthsCost = membershipCost * months;
                    trainingCost = trainingSessionCost * sessions;
                    totalCost = monthsCost + trainingCost;
                    summaryTArea.appendText("Months paid in advance:\n");
                    summaryTArea.appendText("@"+ months + " $" + df.format(monthsCost) + "\n\n" );
                    summaryTArea.appendText("Training Sessions:\n");
                    summaryTArea.appendText("@"+ sessions + " $" + df.format(trainingCost) + "\n\n" );
                    summaryTArea.appendText("Total Cost:  $" + df.format(totalCost));
                }
            }
        }else {
            requiredFields.setVisible(true);
            requiredField1.setVisible(true);
            requiredField3.setVisible(true);
            requiredField2.setVisible(true);
        }
    }



}
