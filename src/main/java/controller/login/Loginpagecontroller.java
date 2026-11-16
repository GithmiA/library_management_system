package controller.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.LoginDTO;

import java.io.IOException;

public class Loginpagecontroller {

    @FXML
    private PasswordField txtpassword;

    @FXML
    private TextField txtusername;

    Logincontroller Logincontroller = new Logincontroller();

    @FXML
    void SignupOnAction(ActionEvent event) {

        Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/signup_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

    public void loginOnAction(ActionEvent event) {

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserName(txtusername.getText());
        loginDTO.setPassword(txtpassword.getText());

        if(Logincontroller.nameandpasswordcheck(loginDTO)) {
            Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/maindashboard_page.fxml"))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.show();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid username or password!");
            alert.showAndWait();
        }
    }

    public void clearOnAction(ActionEvent event) {

        Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/login_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

}
