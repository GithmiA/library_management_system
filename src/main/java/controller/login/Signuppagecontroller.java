package controller.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.LoginDTO;

import java.io.IOException;

public class Signuppagecontroller {

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private PasswordField txtConfirmPassword;

    Signupcontroller signupcontroller = new Signupcontroller();


    @FXML
    public void signUp(ActionEvent event) {

        LoginDTO loginDTO = new LoginDTO();

        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String confirmPassword = txtConfirmPassword.getText();

        if (username.isEmpty() || password.isEmpty() ||
                confirmPassword.isEmpty()) {
            showAlert("Please fill all fields");

        }
        if (!password.equals(confirmPassword)) {

            showAlert("Passwords do not match");

        }

        loginDTO.setPassword(confirmPassword);
        loginDTO.setUserName(username);

        signupcontroller.saveDetails(loginDTO);

    }


    @FXML
    public void clearFields(ActionEvent event) {

        txtUsername.clear();
        txtPassword.clear();
        txtConfirmPassword.clear();

    }


    @FXML
    public void backToLogin(ActionEvent event) {

        Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/login_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }


    private void showAlert(String message) {

        Alert alert = new Alert(Alert.AlertType.WARNING);

        alert.setTitle("Sign Up");
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }

}