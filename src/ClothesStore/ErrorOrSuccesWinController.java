package ClothesStore;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.stage.Stage;


public class ErrorOrSuccesWinController {


    @FXML
    private Button btnOK;


     
    public void ClickOk(ActionEvent actionEvent) {
        Stage stage = (Stage) btnOK.getScene().getWindow();
        stage.close();
    }

    


    
}
    


