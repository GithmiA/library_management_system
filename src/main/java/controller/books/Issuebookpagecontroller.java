package controller.books;

import entity.Book;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import model.BookDTO;
import model.BorrowingDTO;
import model.MemberDTO;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class Issuebookpagecontroller {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnIssueBook;

    @FXML
    private DatePicker txtDueDate;

    @FXML
    private DatePicker txtIssueBook;

    @FXML
    private ComboBox<BookDTO> txtSelectBook;

    @FXML
    private ComboBox<MemberDTO> txtSelectMemeber;

    Issuebookcontroller issuebookcontroller = new Issuebookcontroller();

    public void issueBookOnAction(ActionEvent event) {

        BorrowingDTO borrowingDTO = new BorrowingDTO();

        if( (txtSelectBook.getValue() != null) && (txtSelectMemeber.getValue() != null) ) {
            borrowingDTO.setMemberId(txtSelectMemeber.getValue().getMemberId());
            borrowingDTO.setFullName(txtSelectMemeber.getValue().getFullName());
            borrowingDTO.setBookId(txtSelectBook.getValue().getBookId());
            borrowingDTO.setBookTitle(txtSelectBook.getValue().getBookTitle());
            borrowingDTO.setIssueDate(txtIssueBook.getValue().toString());
            borrowingDTO.setDueDate(txtDueDate.getValue().toString());
            borrowingDTO.setReturnDate(" - ");
            borrowingDTO.setStatus("Borrowed");

            issuebookcontroller.issueBook(borrowingDTO);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Book issued Successfully!");
            alert.showAndWait();
        }
        clearFields();
    }
    private void clearFields() {
        txtSelectBook.getSelectionModel().clearSelection();
        txtSelectMemeber.getSelectionModel().clearSelection();
        txtIssueBook.setValue(null);
        txtDueDate.setValue(null);
    }

    public void clearOnAction(ActionEvent event) {
        Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/issuebook_page.fxml"))));
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
    @FXML
    public void initialize(){
        Collection<BookDTO> books = issuebookcontroller.getAllBooks();
        List<MemberDTO> members = issuebookcontroller.getAllMembers();

        txtSelectBook.setItems(FXCollections.observableArrayList(books));
        txtSelectMemeber.setItems(FXCollections.observableArrayList(members));
    }

}
