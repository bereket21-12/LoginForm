import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
public class Logincontroller {
     private Stage stage;
     private Scene scene;
    @FXML
    private TextField emailfiled;

    @FXML
    private Button loginbtn;

    @FXML
    private PasswordField passwordfiled;

    @FXML
    private Button sinin_btn;

    @FXML
    private Label error_msg;
    
    

    @FXML
    void loginbtn_on_acton(ActionEvent event) throws IOException {
        if(emailfiled.getText().isBlank() == false && passwordfiled.getText().isBlank() == false){
            
            Dbconnection con = new Dbconnection();
            Connection connectDb = con.getconnection();
            String Varifylogin = "SELECT count(1) FROM info WHERE email = '"+emailfiled.getText()+"' AND password = '"+passwordfiled.getText()+"'";


           
            try {
                Statement  statement = connectDb.createStatement();
                ResultSet queryResult = statement.executeQuery(Varifylogin);
        
                
                while(queryResult.next()){
                    if(queryResult.getInt(1) ==1){
                     
                        
                        Parent root = FXMLLoader.load(getClass().getResource("login3.fxml"));
                         Stage stage = (Stage) loginbtn.getScene().getWindow();
                         stage.setScene(new Scene(root));
        


                    }else{
                            error_msg.setText("your email or password is incorrect please try again");

                    }
                }
            } catch (Exception e) {
              e.printStackTrace();;
            }
        }else{
            error_msg.setText("Please provide email and password");
        }

    }

    @FXML
    public void sinin_btn_onaction(ActionEvent event) throws IOException  {

        Parent tvp = FXMLLoader.load(getClass().getResource("login2.fxml"));
        Scene scene =  new Scene(tvp);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
   
    }

}
