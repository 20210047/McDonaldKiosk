package entity;

public class Product {
    private int id;
    private String productName;
    private int price;
    private int category;


    public Product(String productName, int price, int category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public Product(int id, String productName, int price, int category){
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.category = category;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
