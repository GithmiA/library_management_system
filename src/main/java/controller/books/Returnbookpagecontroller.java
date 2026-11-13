package controller.books;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.BorrowingDTO;

import java.io.IOException;

public class Returnbookpagecontroller {
    @FXML
    private Button btnBack;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnReturn;

    @FXML
    private DatePicker dpReturnDate;

    @FXML
    private Label lblBookTitle;

    @FXML
    private Label lblBorrowedDate;

    @FXML
    private Label lblDueDate;

    @FXML
    private Label lblFullName;

    @FXML
    private Label lblMemberId;

    @FXML
    private Label lblPhoneNumber;

    @FXML
    private Label lblStatus;

    @FXML
    private TextField txtSearchBox;

    Returnbookcontroller returnbookcontroller = new Returnbookcontroller();

    public void searchBook(MouseEvent mouseEvent) {

        BorrowingDTO borrowingDTO = returnbookcontroller.load(txtSearchBox.getText());

        if (borrowingDTO != null) {

            lblMemberId.setText(borrowingDTO.getMemberId());
            lblFullName.setText(borrowingDTO.getFullName());
            lblPhoneNumber.setText(borrowingDTO.getPhonenumber());
            lblStatus.setText(borrowingDTO.getStatus());
            lblBookTitle.setText(borrowingDTO.getBookTitle());
            lblBorrowedDate.setText(borrowingDTO.getIssueDate());
            lblDueDate.setText(borrowingDTO.getDueDate());
        }


    }

    public void returnOnAction(ActionEvent event) {

    }

    public void clearOnAction(ActionEvent event) {
        Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/returnbook_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

    public void backOnAction(ActionEvent event) {
        Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/maindashboard_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }
}
