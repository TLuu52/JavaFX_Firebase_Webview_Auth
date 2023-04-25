package modelview;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;
import com.mycompany.mvvmexample.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Sign Up Page
 *
 * @author Thuan Luu
 */
public class signUp {
    
    // Creates Text Fields
    @FXML
    private TextField emailTextfield, nameTextField, 
            phoneTextField, userTextField;
    
    //Creates Password Fields
    @FXML
    private PasswordField pass1TextField, Pass2TextField;
    
    static UserRecord userRecord;
    
    
    @FXML
    void signInButton(ActionEvent event) throws IOException {
        App.setRoot("signin.fxml");
    }
    
    // creates the user after pressing the signup button
    @FXML
    void signUpButton(ActionEvent event) throws IOException {
        
        if (pass1TextField.getText() == null ? Pass2TextField.getText() != null : !pass1TextField.getText().equals(Pass2TextField.getText())) {
            System.err.println("Passwords do not match, Try Again");
        } else {
            CreateRequest request = new CreateRequest()
                .setDisplayName( nameTextField.getText())
                .setEmail(emailTextfield.getText())
                .setUid(userTextField.getText())
                .setPassword(pass1TextField.getText())
                .setPhoneNumber(phoneTextField.getText());

            try {
                userRecord = App.fauth.createUser(request);
                System.out.println("Successfully created new user: " + userRecord.getUid());
            } catch (FirebaseAuthException ex) {
                System.err.println("Info taken or information incomplete");
            }

            signInButton(event);
        }
        
    }
    
}
