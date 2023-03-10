package ClothesStore;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClothesListController {

    private ObservableList<Clothes> clothesData = FXCollections.observableArrayList();
    
    @FXML
    private TableView<Clothes> clothesTable;

    @FXML
    private TableColumn<Clothes, String> vendorCodeCol;

    @FXML
    private TableColumn<Clothes, String> categoryCol;

    @FXML
    private TableColumn<Clothes, String> nameCol;

    @FXML
    private TableColumn<Clothes, String> colorCol;

    @FXML
    private TableColumn<Clothes, String> sizeCol;

    @FXML
    private TableColumn<Clothes, Integer> amountCol;

    @FXML
    private void initialize() {
        try {
            initData();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // устанавливаем тип и значение которое должно хранится в колонке
        vendorCodeCol.setCellValueFactory(new PropertyValueFactory<Clothes, String>("vendorCode"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<Clothes, String>("category"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Clothes, String>("name"));
        colorCol.setCellValueFactory(new PropertyValueFactory<Clothes, String>("color"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<Clothes, String>("size"));
        amountCol.setCellValueFactory(new PropertyValueFactory<Clothes, Integer>("amount"));

        // заполняем таблицу данными
        clothesTable.setItems(clothesData);
    }

    // подготавливаем данные для таблицы
    private void initData() throws SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        String data = dbHandler.getClothes();
        try (PreparedStatement prSt = dbHandler.getDbConnection().prepareStatement(data)) {
            ResultSet resultSet = prSt.executeQuery();
            while (resultSet.next()) {
                String dbVendorCode = resultSet.getString("vendorCode");
                String dbCategory = resultSet.getString("category");
                String dbName = resultSet.getString("name");
                String dbColor = resultSet.getString("color");
                String dbSize = resultSet.getString("size");
                int dbAmount =resultSet.getInt("amount");
                clothesData.add(new Clothes(dbVendorCode, dbCategory, dbName, dbColor, dbSize, dbAmount));
   }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
    
        


