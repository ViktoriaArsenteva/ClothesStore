package ClothesStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() 
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

            return dbConnection;

        }

    // метод записи значений в базу данных
    public void AddClothes(String category, String vendorCode, String name, String size, String color, int amount){
        String insert = "INSERT INTO" + " " + Const.CLOTHES_TABLE + "(" 
                        + Const.CLOTHES_VENDORCODE + "," 
                        + Const.CLOTHES_CATEGORY + "," 
                        + Const.CLOTHES_NAME + ","
                        + Const.CLOTHES_SIZE + ","
                        + Const.CLOTHES_COLOR + ","
                        + Const.CLOTHES_AMOUNT + ")"
                        + "VALUES(?,?,?,?,?,?)";

        
            try {
                PreparedStatement prSt = getDbConnection().prepareStatement(insert);
                prSt.setString(1, vendorCode);
                prSt.setString(2, category);
                prSt.setString(3, name);
                prSt.setString(4, size);
                prSt.setString(5, color);
                prSt.setInt(6, amount);
                prSt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
    }

    public String getAllClothes(){
        String data = "SELECT "  + "*"
                        + "FROM " + Const.CLOTHES_TABLE;
        return data;
        
    }  

    public boolean GetCount(String vendorCode, String category, String name, String size, String color) throws SQLException {
        String data = "SELECT COUNT(*) FROM "
        + Const.CLOTHES_TABLE + " " + "WHERE "
        + Const.CLOTHES_VENDORCODE + " = " + "'" + vendorCode + "'" + " AND "
        + Const.CLOTHES_CATEGORY + " = " + "'" + category + "'" + " AND "
        + Const.CLOTHES_NAME + " = " + "'" + name + "'" + " AND "
        + Const.CLOTHES_SIZE + " = " + "'" + size + "'" + " AND "
        + Const.CLOTHES_COLOR + " = " + "'" + color + "'";
        
        boolean check = false;

        DatabaseHandler dbHandler = new DatabaseHandler();
        try (PreparedStatement prSt = dbHandler.getDbConnection().prepareStatement(data)) {
            ResultSet resultSet = prSt.executeQuery(); 
            System.out.println(resultSet);
            while (resultSet.next()) {
                int count = resultSet.getInt("COUNT(*)");
                if (count == 0){check = true;}
                else {check = false;}
            }
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }


        return check;
        
    }
}
