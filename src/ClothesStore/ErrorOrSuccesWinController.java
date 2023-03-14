package ClothesStore;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class ErrorOrSuccesWinController {


    @FXML
    private Button btnOK;


     
    public void ClickOk(ActionEvent actionEvent) {
        Stage stage = (Stage) btnOK.getScene().getWindow();
        stage.close();
    }

    


    
}
    


