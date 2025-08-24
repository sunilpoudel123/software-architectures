package com.ecommerce.product;

public class Product {

    private String productNumber;
    private String name;
    private int numberOnStock;

    public Product(String productNumber, String name, int numberOnStock) {
        this.productNumber = productNumber;
        this.name = name;
        this.numberOnStock = numberOnStock;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOnStock() {
        return numberOnStock;
    }

    public void setNumberOnStock(int numberOnStock) {
        this.numberOnStock = numberOnStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productNumber='" + productNumber + '\'' +
                ", name='" + name + '\'' +
                ", numberOnStock=" + numberOnStock +
                '}';
    }
}
