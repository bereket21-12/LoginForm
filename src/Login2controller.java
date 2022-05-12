import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
public class Login2controller {

    @FXML
    private TextField emailfield;

    @FXML
    private TextField firstnamefield;

    @FXML
    private TextField genderfeild;

    @FXML
    private Label info_lable;

    @FXML
    private TextField lastnamefeild;

    @FXML
    private TextField passwordfield;

    @FXML
    private Button sign_in_btn;

    @FXML
    void sign_in_btn_on_action(ActionEvent event) throws IOException {

         store();
         if(emailfield.getText().isBlank() == true || firstnamefield.getText().isBlank() == true ||genderfeild.getText().isBlank() == true ||lastnamefeild.getText().isBlank() == true || passwordfield.getText().isBlank() == true){

            info_lable.setText("Please Fill Required informations");
        }else{
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Sucess");
           alert.setContentText("You are sucessfully registered");
           Optional<ButtonType> result = alert.showAndWait();
           if(result.get() == ButtonType.OK){
            Parent tvp = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene =  new Scene(tvp);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
           }


        }

    }

    public void store(){
        Dbconnection c = new  Dbconnection();
        Connection con = c.getconnection();

    String sql = ("insert into info (email,password,firstname,lastname,gender) values(?,?,?,?,?)");
    try {
        PreparedStatement st = con.prepareStatement(sql);

        st.setString(1, emailfield.getText());
        st.setString(2, passwordfield.getText());
        st.setString(3, firstnamefield.getText());
        st.setString(4, lastnamefeild.getText());
        st.setString(5, genderfeild.getText());

    
        st.executeUpdate();
 
      
   
        } catch (Exception e) {
     System.out.println(e);
    }

}
@FXML
void backbtn(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
    Scene scene =  new Scene(root);
    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();

}

}
