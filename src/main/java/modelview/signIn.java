package modelview;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.mycompany.mvvmexample.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Thuan Luu
 */
public class signIn {
    
    @FXML
    private TextField userTextField;
    
    @FXML
    private PasswordField passTextField;
    
    static UserRecord currentUser;

    @FXML
    void signInButton(ActionEvent event) throws IOException {
        try {
            String user = userTextField.getText();
            String pass = passTextField.getText();
            
            currentUser = FirebaseAuth.getInstance().getUser(user);
            App.setRoot("AccessFBView.fxml");
            
        } catch (FirebaseAuthException | IllegalArgumentException ex) {
            System.err.println("Username does not exist or incomplete information, try inputting it again");
        }
    }

    @FXML
    void signUpButton(ActionEvent event) throws IOException {
        App.setRoot("signup.fxml");
    }
}

