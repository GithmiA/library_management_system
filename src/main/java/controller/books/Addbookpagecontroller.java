package controller.books;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.BookDTO;

import java.io.IOException;

public class Addbookpagecontroller {

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtBookTitle;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtPublishYear;

    @FXML
    private TextField txtQuantity;


    public void addBookOnAction(ActionEvent event) {

        BookDTO bookDTO = new BookDTO();

        bookDTO.setBookId(txtBookId.getText());
        bookDTO.setBookTitle(txtBookTitle.getText());
        bookDTO.setBookAuthor(txtAuthor.getText());
        bookDTO.setBookCategory(txtCategory.getText());
        bookDTO.setBookPublishYear(Integer.parseInt(txtPublishYear.getText()));
        bookDTO.setBookQuantity(Integer.parseInt(txtQuantity.getText()));
    }

    public void clearOnAction(ActionEvent event) {
        Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/addbook_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

    public void backDashboardOnAction(ActionEvent event) {
        Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/maindashboard_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }
}
