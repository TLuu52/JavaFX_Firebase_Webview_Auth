package modelview;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.mycompany.mvvmexample.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class signIn {

    @FXML
    private Button button_signIn, button_signUp;

    @FXML
    private TextField textField_user;
    
    @FXML
    private PasswordField textField_pass;
    
    static UserRecord currentUser;

    @FXML
    void handleButton_signIn(ActionEvent event) throws IOException {
        try {
            String user = textField_user.getText();
            String pass = textField_pass.getText();
            
            currentUser = FirebaseAuth.getInstance().getUser(user);
            App.setRoot("AccessFBView.fxml");
            
        } catch (FirebaseAuthException | IllegalArgumentException ex) {
            System.err.println("Username does not exist or incomplete information, try inputting it again");
        }
    }

    @FXML
    void handleButton_signUp(ActionEvent event) throws IOException {
        App.setRoot("signup.fxml");
    }
}

