package controller.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Loginpagecontroller {

    @FXML
    private PasswordField txtpassword;

    @FXML
    private TextField txtusername;

    Logincontroller Logincontroller = new Logincontroller();

    public void loginOnAction(ActionEvent event) {
    }

    public void clearOnAction(ActionEvent event) {
    }

    public void resetOnAction(ActionEvent event) {
    }
}
