package controller.books;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

    Addbookcontroller addbookcontroller = new Addbookcontroller();


    public void addBookOnAction(ActionEvent event) {

        try {
            BookDTO bookDTO = new BookDTO();

            bookDTO.setBookId(txtBookId.getText());
            bookDTO.setBookTitle(txtBookTitle.getText());
            bookDTO.setBookAuthor(txtAuthor.getText());
            bookDTO.setBookCategory(txtCategory.getText());
            bookDTO.setBookPublishYear(Integer.parseInt(txtPublishYear.getText()));
            bookDTO.setBookQuantity(Integer.parseInt(txtQuantity.getText()));

            addbookcontroller.saveBook(bookDTO);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Book Added Successfully!");
            alert.showAndWait();

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Unable to add book!");
            alert.showAndWait();
        }

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
