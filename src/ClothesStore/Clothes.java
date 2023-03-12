package ClothesStore;

 
public class Clothes{
     
    private int id;
    private String vendorCode;
    private String category;
    private String name;
    private String color;
    private String size;
    private int amount;

    public Clothes(int id, String vendorCode, String category, String name, String color, String size, int amount) {
        this.id = id;
        this.vendorCode = vendorCode;
        this.category = category;
        this.name = name;
        this.color = color;
        this.size = size;
        this.amount = amount;
    }

    public Clothes() {
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
