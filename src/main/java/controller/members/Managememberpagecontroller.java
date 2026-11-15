package controller.members;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.MemberDTO;

import java.io.IOException;


public class Managememberpagecontroller {

    @FXML
    private TableColumn<MemberDTO, Void> actionColumn;

    @FXML
    private TableColumn<MemberDTO, String> emailColumn;

    @FXML
    private TableColumn<MemberDTO, String> idColumn;

    @FXML
    private TableView<MemberDTO> memberTable;

    @FXML
    private TableColumn<MemberDTO, String> nameColumn;

    @FXML
    private TableColumn<MemberDTO, String> phonenumberColumn;

    @FXML
    private TextField txtSearchById;

    Managemembercontroller managemembercontroller = new Managemembercontroller();


    public void backOnAction(ActionEvent event) {
        Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/maindashboard_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

    public void searchById(MouseEvent mouseEvent) {
    }

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phonenumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        memberTable.setItems(managemembercontroller.loadTable());
        setUpActionColumn();


    }

    private void setUpActionColumn() {


    }

}
