package modelview;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;
import com.mycompany.mvvmexample.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Thuan Luu
 */
public class signUp {
    
    
   @FXML
    private Button button_signIn, button_signUp;

    @FXML
    private TextField textField_email, textField_name, 
            textField_phone, textField_user;

    @FXML
    private PasswordField textField_pass1, textField_pass2;
    
    static UserRecord userRecord;

    @FXML
    void handleButton_signIn(ActionEvent event) throws IOException {
        App.setRoot("signin.fxml");
    }

    @FXML
    void handleButton_signUp(ActionEvent event) throws IOException {
        
        if (textField_pass1.getText() == null ? textField_pass2.getText() != null : !textField_pass1.getText().equals(textField_pass2.getText())) {
            System.err.println("Passwords do not match");
        } else {
            CreateRequest request = new CreateRequest()
                .setDisplayName(textField_name.getText())
                .setEmail(textField_email.getText())
                .setUid(textField_user.getText())
                .setPassword(textField_pass1.getText())
                .setPhoneNumber(textField_phone.getText());

            try {
                userRecord = App.fauth.createUser(request);
                System.out.println("Successfully created new user: " + userRecord.getUid());
            } catch (FirebaseAuthException ex) {
                System.err.println("Info taken or information incomplete");
            }

            handleButton_signIn(event);
        }
        
    }
    
}
