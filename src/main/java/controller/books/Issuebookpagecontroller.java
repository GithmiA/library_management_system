package controller.books;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import model.BookDTO;
import model.BorrowingDTO;
import model.MemberDTO;

import java.io.IOException;

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

            issuebookcontroller.issueBook(borrowingDTO);

        }
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

}
