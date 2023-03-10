package ClothesStore;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddProductController  {
    @FXML
    private ChoiceBox category;
    @FXML
    private TextField vendorCode;
    @FXML
    private TextField name;
    @FXML
    private ChoiceBox size;
    @FXML
    private ChoiceBox color;
    @FXML
    private TextField amount;
    @FXML
    private Button save;
    @FXML
    private Button cancel;

    ObservableList<String> categoryList = FXCollections.observableArrayList("Топ", "Футболка", "Блузка или рубашка", "Свитер","Платье", "Джинсы", "Брюки", "Шорты", "Юбка", "Верхняя одежда", "Аксессуары");
    ObservableList<String> sizeList = FXCollections.observableArrayList("One size", "XXS", "XS", "S", "M", "L", "XL", "XXL");
    ObservableList<String> colorList = FXCollections.observableArrayList("Разноцветный", "Белый", "Черный", "Красный","Синий", "Голубой", "Розовый", "Желтый", "Зеленый", "Коричневый", "Серый", "Бежевый", "Фиолетовый");



    // метод зыкрытия модального окна по кнопке отмена
    public void ClickCancel(ActionEvent actionEvent) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    // обработка нажатия кнопки сохранить : если данные введены неправильно, то вызывается окно ошибки
    public void ClickSave(ActionEvent actionEvent) throws IOException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        try {
            String dbCategory = category.getValue().toString();
            String dbVendorCode = vendorCode.getText();
            String dbName = name.getText();
            String dbSize = size.getValue().toString();
            String dbColor = color.getValue().toString();
            int dbaAmount;
            dbaAmount = Integer.parseInt(amount.getText());
            dbHandler.AddClothes(dbCategory, dbVendorCode, dbName, dbSize, dbColor, dbaAmount);
            ErrorWindow("Succes",true);
            Stage stage = (Stage) save.getScene().getWindow();
            stage.close();


        } catch (Exception e) {
            ErrorWindow("Error",false);
        }

    }
    // метод вызывает окно ошибки или окно успешного сохранения
    public void ErrorWindow(String title, boolean check) throws IOException {
        try {
            String name;
            Stage window = new Stage();
            FXMLLoader loader = new FXMLLoader();
            if (check == true){
                name = "SuccesWin.fxml";
            }
            else{
                name = "ErrorWin.fxml";
            }
            loader.setLocation(getClass().getResource(name));
            Parent root = loader.load();
            window.setTitle(title);
            window.setScene(new Scene(root));
            window.initModality(Modality.APPLICATION_MODAL);
            window.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void initialize() {
        category.setItems(categoryList);
        size.setItems(sizeList);
        color.setItems(colorList);

    }


}