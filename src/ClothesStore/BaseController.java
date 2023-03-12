package ClothesStore;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import java.io.IOException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BaseController {

    @FXML
    private Button closeBtn;

    // метод Открывает окно "добавить новый товар"
    public void ClickAdd(ActionEvent actionEvent) throws IOException {
        try {
            Stage window = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("AddProduct.fxml"));
            Parent root = loader.load();
            window.setTitle("Добавить новый товар");
            window.setScene(new Scene(root));
            window.initModality(Modality.APPLICATION_MODAL);
            window.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ClickClothesList(ActionEvent actionEvent) throws IOException {
        try {
            Stage window = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ClothesList.fxml"));
            Parent root = loader.load();
            window.setTitle("Список товаров");
            window.setScene(new Scene(root));
            window.initModality(Modality.APPLICATION_MODAL);
            window.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ClickClose(ActionEvent actionEvent) {
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }

}